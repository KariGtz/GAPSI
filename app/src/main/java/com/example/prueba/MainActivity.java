package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.prueba.Adapters.ProductAdapter;
import com.example.prueba.Adapters.RecentsAdapter;
import com.example.prueba.Database.DatabaseHelper;
import com.example.prueba.Interface.ShoppAppLiverpoolApi;
import com.example.prueba.Model.Product;
import com.example.prueba.Network.NetworkConnection;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rVProducts;
    private RecyclerView rvSearchRecent;
    private RecyclerView.LayoutManager layoutManager;
    private List<Product> productList;
    private ProductAdapter productAdapter;
    private ShoppAppLiverpoolApi shoppAppLiverpoolApi; // Interface
    private EditText inputSearch;
    private TextView titleSearchRecent;

    DatabaseHelper databaseHelper;
    ArrayList<Product> listaProducts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        titleSearchRecent = (TextView) findViewById(R.id.titleSearchRecent);
        rVProducts = (RecyclerView) findViewById(R.id.rVProducts);
        rvSearchRecent = (RecyclerView) findViewById(R.id.rvSearchRecent);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        layoutManager = new LinearLayoutManager(this);
        rVProducts.setLayoutManager(layoutManager);
        rVProducts.setHasFixedSize(true);

        //Instance DBHelper
        databaseHelper = new DatabaseHelper(MainActivity.this);
        listaProducts = new ArrayList<Product>();
        rvSearchRecent.setLayoutManager(new LinearLayoutManager(this));

        consultarListaProductos();

        RecentsAdapter adapter = new RecentsAdapter(listaProducts, this);
        rvSearchRecent.setAdapter(adapter);


        inputSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    Log.e("TAG", "Busqueda: " + inputSearch.getText());
                    String keySearch = inputSearch.getText().toString();
                    getProducts(keySearch);
                    saveProduct(keySearch);
                    handled = true;
                }
                return handled;
            }
        });

    }

    public void saveProduct(String searchWord) {
        Product objProduct = new Product(searchWord,"","", "");
        long success = databaseHelper.saveProduct(objProduct);

        if(success != -1) {
            Log.e("TAG", "Insert success: " + success);
        } else {
            Log.e("TAG", "Error insert: " + success);
        }
    }

    private void consultarListaProductos() {
        listaProducts.addAll(databaseHelper.allProducts());
    }

    private void getProducts(String searchstring) {

        shoppAppLiverpoolApi = NetworkConnection.getApiLiverpool().create(ShoppAppLiverpoolApi.class);

        Call<List<Product>> call = shoppAppLiverpoolApi.getProducts(searchstring, 1, 10);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

                Log.e("TAG", response.toString());
                productList = response.body();
                productAdapter = new ProductAdapter(productList, MainActivity.this);
                rVProducts.setAdapter(productAdapter);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e("TAG", t.getMessage());
            }
        });

    }
}
