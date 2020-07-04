package com.example.prueba.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.prueba.Model.Product;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "Liverpool.db";
    public static final String TAG = "DatabaseHelper";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Table product
        sqLiteDatabase.execSQL("CREATE TABLE " + ProductContract.ProductEntry.TABLE_NAME + " ("
                + ProductContract.ProductEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ProductContract.ProductEntry.NAME + " TEXT NOT NULL,"
                + ProductContract.ProductEntry.IMAGE + " TEXT NOT NULL,"
                + ProductContract.ProductEntry.PRICE + " REAL,"
                + ProductContract.ProductEntry.LOCATION + " TEXT NOT NULL,"
                + "UNIQUE (" + ProductContract.ProductEntry._ID + "))");
    }

    public long saveProduct(Product product) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        String name = product.getTitulo(); //NAME
        String[] parametros = {name};
        long response;

        if(name != null) {

            Cursor cursor = sqLiteDatabase.rawQuery("SELECT " + ProductContract.ProductEntry.NAME +
                    " FROM " + ProductContract.ProductEntry.TABLE_NAME + " WHERE " + ProductContract.ProductEntry.NAME + "=? ", parametros);

            if (cursor.moveToFirst())  {

                // Don't save
                response = -1;

            } else {

                response = sqLiteDatabase.insert(
                        ProductContract.ProductEntry.TABLE_NAME,
                        null,
                        product.toContentValues());
            }
        } else {
            response = -1;
        }

        return response;
    }

    public ArrayList<Product> allProducts () {

        ArrayList<Product> listProduct = new ArrayList<>();
        Product product = null;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + ProductContract.ProductEntry._ID + ", "
                + ProductContract.ProductEntry.NAME + ", "
                + ProductContract.ProductEntry.IMAGE + ", "
                + ProductContract.ProductEntry.PRICE + ", "
                + ProductContract.ProductEntry.LOCATION + " FROM " + ProductContract.ProductEntry.TABLE_NAME,null);
        if (cursor.moveToFirst()) {
            do {
                try {
                    product = new Product();

                    product.setTitulo(cursor.getString(0));
                    product.setImagen(cursor.getString(1));
                    product.setPrecio(cursor.getString(2));
                    product.setUbicacion(cursor.getString(3));

                    listProduct.add(product);

                    Log.e(TAG, "_ID: " + cursor.getInt(0));
                    Log.e(TAG, "NAME: " + cursor.getString(1));
                    Log.e(TAG, "PRICE: " + cursor.getString(2));
                    Log.e(TAG, "LOCATION: " + cursor.getInt(3));

                } catch (NullPointerException e) {
                    Log.e(TAG, e.getMessage());
                }

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return listProduct;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versionAntigua, int versionNueva) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ProductContract.ProductEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
