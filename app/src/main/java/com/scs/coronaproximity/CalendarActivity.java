package com.scs.coronaproximity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class CalendarActivity extends AppCompatActivity {
    private MaterialDatePicker.Builder<Pair<Long, Long>> builder;
    private MaterialDatePicker<Pair<Long, Long>> picker;
    private Button mPickDateButton;
    private  TextView quarantineText;
    FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        mPickDateButton = findViewById(R.id.button);
        quarantineText = (TextView)findViewById(R.id.quarantineText);
        builder = MaterialDatePicker.Builder.dateRangePicker();
        picker = builder.build();
        picker.show(getSupportFragmentManager(), picker.toString());
        mPickDateButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // getSupportFragmentManager() to
                        // interact with the fragments
                        // associated with the material design
                        // date picker tag is to get any error
                        // in logcat
                        picker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
                    }
                });

        // now handle the positive button click from the
        // material design date picker
        picker.addOnPositiveButtonClickListener(
                new MaterialPickerOnPositiveButtonClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onPositiveButtonClick(Object selection) {

                        // if the user clicks on the positive
                        // button that is ok button update the
                        // selected date
                        mPickDateButton.setText("hey");
                        quarantineText.setText("Selected Date is : " + picker.getHeaderText());
                        // in the above statement, getHeaderText
                        // is the selected date preview from the
                        // dialog
                    }
                });
    }
    @SuppressLint("SetTextI18n")
    public void onClickButtonSelectDate(View view) {
<<<<<<< Updated upstream
        TextView quarantineText = (TextView)findViewById(R.id.quarantineText);
        quarantineText.setText("Select a beginning date in calendar");
        picker.show(getSupportFragmentManager(), picker.toString());
        //picker.addOnPositiveButtonClickListener();
=======

>>>>>>> Stashed changes
    }


    public void onClickSearchButton(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
}