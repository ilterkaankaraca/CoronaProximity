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

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private APIInterface apiInterface;
    TextView countyText;
    TextView stateText;
    TextView populationText;
    TextView casesText;
    TextView deathsText;
    TextView casesPerWeekText;
    TextView deathsPerText;
    TextView stateAbbreviationText;
    TextView recoveredText;
    TextView weekIncidenceText;
    TextView casesPer100KText;
    TextView deltaCasesText;
    TextView deltaDeathsText;
    TextView deltaRecoveredText;

    CoronaData coronaData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<String> call = apiInterface.getCity();
        countyText = findViewById(R.id.name);
        stateText = findViewById(R.id.county);
        populationText = findViewById(R.id.population);
        casesText = findViewById(R.id.cases);
        deathsText = findViewById(R.id.deaths);
        casesPerWeekText = findViewById(R.id.casesPerWeek);
        deathsPerText = findViewById(R.id.deathsPerWeek);
        stateAbbreviationText = findViewById(R.id.stateAbbreviation);
        weekIncidenceText = findViewById(R.id.weekIncidence);
        deltaCasesText = findViewById(R.id.deltaCases);
        deltaDeathsText = findViewById(R.id.deltaDeaths);
        deltaRecoveredText = findViewById(R.id.deltaRecovered);
        recoveredText = findViewById(R.id.recovered);
        casesPer100KText = findViewById(R.id.casesPer100k);

        call.enqueue(new Callback<String>() {
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("TAG", "onFailure: ");
                t.printStackTrace();
                call.cancel();
            }

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String responseString = response.body();
                    Log.d("TAG", "onResponse");
                    int thirdOpening = StringUtils.ordinalIndexOf(responseString, "{", 3);
                    int firstClosing = StringUtils.ordinalIndexOf(responseString, "}", 2) +1;
                    responseString = responseString.substring(thirdOpening, firstClosing);
                    coronaData = new Gson().fromJson(responseString, CoronaData.class);
                    Log.d("TAG", coronaData.name);


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
    public void onClickSearchButton(View view) {


    }

    @Override
    public boolean onQueryTextSubmit(String query) {


        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}