package com.example.thrymr.newexpensesapp.Activity.employee;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.thrymr.newexpensesapp.R;
import com.example.thrymr.newexpensesapp.Views.CustomEditText;

import java.util.Calendar;

public class AddTripNameAcitvity extends AppCompatActivity implements View.OnClickListener {

    private CustomEditText edtvTripName, edtvTripDate;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Trip Name");

        setValues();


    }

    private void setValues() {
        edtvTripName = (CustomEditText) findViewById(R.id.edtv_trip_name);
        edtvTripDate = (CustomEditText) findViewById(R.id.edtv_trip_date);
        edtvTripDate.setInputType(InputType.TYPE_NULL);
        button = (Button) findViewById(R.id.save_data_btn);

        edtvTripDate.setOnClickListener(this);
        button.setOnClickListener(this);


    }

    public void setDatepicker() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        // date picker dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        edtvTripDate.setText(dayOfMonth + "/"
                                + (monthOfYear + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edtv_trip_date:
                setDatepicker();
                break;
            case R.id.save_data_btn:
                startActivity(new Intent(this, TripNameExpensesActivity.class));
                break;
        }
    }
}
