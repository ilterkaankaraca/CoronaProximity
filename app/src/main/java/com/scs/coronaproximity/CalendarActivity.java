package com.scs.coronaproximity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }
    @SuppressLint("SetTextI18n")
    public void onClickButtonSelectDate(View view) {
        TextView quarantineText = (TextView)findViewById(R.id.quarantineText);
        quarantineText.setText("Select a beginning date in calendar");
    }

    public void onClickSearchButton(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }


}