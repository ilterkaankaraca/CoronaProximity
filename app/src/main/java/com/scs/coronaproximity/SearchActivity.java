package com.scs.coronaproximity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class SearchActivity extends AppCompatActivity {
    private API api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
    public void onClickSearchButton(View view) throws IOException {
       String json1;
        api = new API();
        Button button9 = (Button)findViewById(R.id.button9);
        TextView textView = (TextView)findViewById(R.id.textView);
        button9.setText("hey1");
        json1 = api.getJson();
        Log.d("AG", "onClickSearchButton: "+json1);

        textView.setText(json1);
    }
}