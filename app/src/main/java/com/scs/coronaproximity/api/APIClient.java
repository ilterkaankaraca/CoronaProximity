package com.scs.coronaproximity.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class APIClient {

    public static Retrofit retrofit = null;

// configure the retrofit builder
    public static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.corona-zahlen.org/districts/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(client)
                .build();
        return(retrofit);
    }

}