package com.scs.coronaproximity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class CalendarActivity extends AppCompatActivity {
    private MaterialDatePicker.Builder<Pair<Long, Long>> builder;
    private MaterialDatePicker<Pair<Long, Long>> picker;
    private Button mPickDateButton;
    private  TextView quarantineText;
    boolean inQuarantine;
    final Handler handler = new Handler();
    FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        mPickDateButton = findViewById(R.id.button);
        quarantineText = (TextView)findViewById(R.id.quarantineText);
        builder = MaterialDatePicker.Builder.dateRangePicker();
        picker = builder.setTitleText("Select date").build();
        inQuarantine=false;
        Calendar cal = Calendar.getInstance();
        int year  = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int date  = cal.get(Calendar.DATE);
        cal.clear();
        cal.set(year, month, date);
        long todayMillis = cal.getTimeInMillis();

        mPickDateButton.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // getSupportFragmentManager() to
                        // interact with the fragments
                        // associated with the material design
                        // date picker tag is to get any error
                        // in logcat
                        if(!inQuarantine){
                            picker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
                        }
                        else if (inQuarantine){
                            quarantineText.setText("Start quarantine");
                            inQuarantine=false;
                        }
                    }
                });



        // now handle the positive button click from the
        // material design date picker
        picker.addOnPositiveButtonClickListener(
                new MaterialPickerOnPositiveButtonClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onPositiveButtonClick(Object selection) {

                        Timer timer = new Timer(false);
                        quarantineText.setText("You are in quarantine: " + (picker.getSelection().second-todayMillis)/(1000*60*60*24) + "days");
                        mPickDateButton.setText("End quarantine");
                        inQuarantine=true;
                    }
                });
    }
    public void onClickSearchButton(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
}