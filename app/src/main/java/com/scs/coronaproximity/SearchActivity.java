package com.scs.coronaproximity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class SearchActivity extends AppCompatActivity {
    private API api;
    String json = "{\"data\":{\"02000\":{\"ags\":\"02000\",\"name\":\"Hamburg\",\"county\":\"SK Hamburg\",\"state\":\"Hamburg\",\"population\":1847253,\"cases\":77455,\"deaths\":1597,\"casesPerWeek\":163,\"deathsPerWeek\":0,\"stateAbbreviation\":\"HH\",\"recovered\":75349,\"weekIncidence\":8.823913129387257,\"casesPer100k\":4192.982769550245,\"delta\":{\"cases\":22,\"deaths\":0,\"recovered\":20}}},\"meta\":{\"source\":\"Robert Koch-Institut\",\"contact\":\"Marlon Lueckert (m.lueckert@me.com)\",\"info\":\"https://github.com/marlon360/rki-covid-api\",\"lastUpdate\":\"2021-07-04T00:00:00.000Z\",\"lastCheckedForUpdate\":\"2021-07-04T13:32:35.485Z\"}" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView nameText;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        nameText = (TextView)findViewById(R.id.name);
        int thirdOpening = StringUtils.ordinalIndexOf(json, "{", 3);
        int firstClosing = StringUtils.ordinalIndexOf(json, "}", 2) +1;
        json = json.substring(thirdOpening, firstClosing);
        nameText.setText(getObject().getName());
    }

    private CoronaData getObject(){

        CoronaData targetObject = new Gson().fromJson(json, CoronaData.class);
        return targetObject;
    }
}