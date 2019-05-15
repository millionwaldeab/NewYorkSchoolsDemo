package com.example.data_layer.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {
    public static final String URL = "https://data.cityofnewyork.us";
    public static Retrofit mRetrofit;

    /*
    This public static method will return a singleton pattern Retrofit client instance anywhere in the application
    */
    public static Retrofit getRetrofitClient() {
        if (mRetrofit == null) {
            //Defining the Retrofit using Builder
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create()) // Convertor library used to convert response into POJO
                    .build();
        }
        return mRetrofit;
    }
}
