package com.scs.coronaproximity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;

public class CalendarActivity extends AppCompatActivity {
    private MaterialDatePicker.Builder<Pair<Long, Long>> builder;
    private MaterialDatePicker<Pair<Long, Long>> picker;
    FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }
    @SuppressLint("SetTextI18n")
    public void onClickButtonSelectDate(View view) {
        TextView quarantineText = (TextView)findViewById(R.id.quarantineText);
        quarantineText.setText("Select a beginning date in calendar");
        builder = MaterialDatePicker.Builder.dateRangePicker();
        picker = builder.build();
        picker.show(getSupportFragmentManager(), picker.toString());
    }

    public void onClickSearchButton(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }


}