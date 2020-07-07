package com.example.prueba.Interface;

import com.example.prueba.Model.ObjResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShoppAppLiverpoolApi {

    @GET("v3/plp")
    Call<ObjResponse> getProducts(
            @Query("category-id") String category_id,
            @Query("search-string") String search_string,
            @Query("sort-option") String sort_option,
            @Query("refinement-options") String refinement_options,
            @Query("page-number") int page_number,
            @Query("number-of-items-per-page") int number_of_items_per_page,
            @Query("page-number") boolean force_plp,
            @Query("return-blp-products") boolean return_blp_products,
            @Query("sellerId") String sellerId
    );
}
