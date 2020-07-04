package com.example.prueba.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkConnection {

    public static final String BASE_URL = "https://shoppapp.liverpool.com.mx/appclienteservices/";
    public static Retrofit retrofit;

    public static Retrofit getApiLiverpool() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(NetworkConnection.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
