package com.scs.coronaproximity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.google.gson.Gson;
import com.scs.coronaproximity.api.APIClient;
import com.scs.coronaproximity.api.APIInterface;
import com.scs.coronaproximity.api.CoronaData;

import org.apache.commons.lang3.StringUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity{
    CoronaData coronaData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        APIInterface  apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<String> call = apiInterface.getCity();
        TextView countyText = findViewById(R.id.name);
        TextView stateText = findViewById(R.id.county);
        TextView populationText = findViewById(R.id.population);
        TextView casesText = findViewById(R.id.cases);
        TextView deathsText = findViewById(R.id.deaths);
        TextView casesPerWeekText = findViewById(R.id.casesPerWeek);
        TextView deathsPerText = findViewById(R.id.deathsPerWeek);
        TextView stateAbbreviationText = findViewById(R.id.stateAbbreviation);
        TextView weekIncidenceText = findViewById(R.id.weekIncidence);
        TextView deltaCasesText = findViewById(R.id.deltaCases);
        TextView deltaDeathsText = findViewById(R.id.deltaDeaths);
        TextView deltaRecoveredText = findViewById(R.id.deltaRecovered);
        TextView recoveredText = findViewById(R.id.recovered);
        TextView casesPer100KText = findViewById(R.id.casesPer100k);
        call.enqueue(new Callback<String>() {
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("TAG", "onFailure: ");
                countyText.setText("Connection Error");
                stateText.setText("Connection Error");
                populationText.setText("Connection Error");
                casesText.setText("Connection Error");
                deathsText.setText("Connection Error");
                casesPerWeekText.setText("Connection Error");
                deathsPerText.setText("Connection Error");
                stateAbbreviationText.setText("Connection Error");
                weekIncidenceText.setText("Connection Error");
                deltaCasesText.setText("Connection Error");
                deltaDeathsText.setText("Connection Error");
                deltaRecoveredText.setText("Connection Error");
                recoveredText.setText("Connection Error");
                casesPer100KText.setText("Connection Error");
                t.printStackTrace();
                call.cancel();
            }

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String responseString = response.body();
                    Log.d("TAG", "onResponse");
                    //check if response is okay
                        int thirdOpening = StringUtils.ordinalIndexOf(responseString, "{", 3);
                        int firstClosing = StringUtils.ordinalIndexOf(responseString, "}", 2) + 1;
                        responseString = responseString.substring(thirdOpening, firstClosing);
                        coronaData = new Gson().fromJson(responseString, CoronaData.class);
                        Log.d("TAG", coronaData.getName());
                        countyText.setText(coronaData.getName());
                        stateText.setText(coronaData.getCounty());
                        populationText.setText(coronaData.getPopulation());
                        casesText.setText(coronaData.getCases());
                        deathsText.setText(coronaData.getDeaths());
                        casesPerWeekText.setText(coronaData.getCasesPerWeek());
                        deathsPerText.setText(coronaData.getDeathsPerWeek());
                        stateAbbreviationText.setText(coronaData.getStateAbbreviation());
                        weekIncidenceText.setText(coronaData.getWeekIncidence());
                        deltaCasesText.setText(coronaData.getDelta().getCases());
                        deltaDeathsText.setText(coronaData.getDelta().getCases());
                        deltaRecoveredText.setText(coronaData.getDelta().getRecovered());
                        recoveredText.setText(coronaData.getRecovered());
                        casesPer100KText.setText(coronaData.getCasesPer100k());
                }
            }
        });
    }
}