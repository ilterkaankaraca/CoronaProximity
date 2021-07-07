package com.scs.coronaproximity.api;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface APIInterface {
    @GET("02000")
    Call<String> getHamburg();
}
