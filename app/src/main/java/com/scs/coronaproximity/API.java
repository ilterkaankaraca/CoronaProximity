package com.scs.coronaproximity;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class API {
    private String districtUrl = "https://api.corona-zahlen.org/districts/02000";
    String response = "-1";
    public CoronaData deserializeJson(String jsonStr) {
        return  new Gson().fromJson(jsonStr, CoronaData.class);
    }
}