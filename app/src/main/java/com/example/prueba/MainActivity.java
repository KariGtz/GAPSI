package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.prueba.Adapters.ProductAdapter;
import com.example.prueba.Adapters.RecentsAdapter;
import com.example.prueba.Database.DatabaseHelper;
import com.example.prueba.Interface.ShoppAppLiverpoolApi;
import com.example.prueba.Model.ObjResponse;
import com.example.prueba.Model.Product;
import com.example.prueba.Model.Record;
import com.example.prueba.Network.NetworkConnection;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rVProducts;
    private ProgressBar loading_spinner;
    private RecyclerView rvSearchRecent;
    private RecyclerView.LayoutManager layoutManager;
    private List<Record> productList;
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
        loading_spinner = (ProgressBar) findViewById(R.id.loading_spinner);
        rvSearchRecent = (RecyclerView) findViewById(R.id.rvSearchRecent);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        layoutManager = new LinearLayoutManager(this);
        rVProducts.setLayoutManager(layoutManager);
        rVProducts.setHasFixedSize(true);

        loading_spinner.setVisibility(View.GONE);

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

        hideKeyboard(MainActivity.this);
        loading_spinner.setVisibility(View.VISIBLE);

        shoppAppLiverpoolApi = NetworkConnection.getApiLiverpool().create(ShoppAppLiverpoolApi.class);

        Call<ObjResponse> call = shoppAppLiverpoolApi.getProducts(
                "",
                searchstring,
                "",
                "",
                1,
                10,
                false,
                false,
                ""
        );
        call.enqueue(new Callback<ObjResponse>() {
            @Override
            public void onResponse(Call<ObjResponse> call, Response<ObjResponse> response) {

                loading_spinner.setVisibility(View.GONE);
                ObjResponse records = response.body();

                productList = records.getPlpResults().getRecords();
                productAdapter = new ProductAdapter(productList, MainActivity.this);
                rVProducts.setAdapter(productAdapter);

            }

            @Override
            public void onFailure(Call<ObjResponse> call, Throwable t) {
                loading_spinner.setVisibility(View.GONE);
                Log.e("Error", t.getMessage());
            }
        });

    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
