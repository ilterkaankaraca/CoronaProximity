package com.scs.coronaproximity.api;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

// request data by ags code - https://api.corona-zahlen.org/districts/06414 (base url  + ags)
public interface APIInterface {
    @GET("06533")
    Call<String> getCity();
}
