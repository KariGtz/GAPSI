package com.example.prueba.Model;

import android.content.ContentValues;

import com.example.prueba.Database.ProductContract;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("titulo")
    private String titulo;

    @SerializedName("precio")
    private String precio;

    @SerializedName("ubicacion")
    private String ubicacion;

    @SerializedName("imagen")
    private String imagen;

    public Product() {

    }

    public Product(String titulo, String precio, String ubicacion, String imagen) {
        this.titulo = titulo;
        this.precio = precio;
        this.ubicacion = ubicacion;
        this.imagen = imagen;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPrecio() {
        return precio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getImagen() {
        return imagen;
    }


    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(ProductContract.ProductEntry.NAME, titulo);
        values.put(ProductContract.ProductEntry.IMAGE, imagen);
        values.put(ProductContract.ProductEntry.PRICE, precio);
        values.put(ProductContract.ProductEntry.LOCATION, ubicacion);
        return values;
    }
}
