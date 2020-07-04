package com.example.prueba.Interface;

import com.example.prueba.Model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShoppAppLiverpoolApi {

    @GET("services/v3/plp?force-plp=true")
    Call<List<Product>> getProducts(
            @Query("searchstring") String searchstring,
            @Query("page-number") int page_number,
            @Query("number-of-items-per-page") int number_of_items_per_page
    );
}
