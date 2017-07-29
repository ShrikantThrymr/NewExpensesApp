package com.example.thrymr.newexpensesapp.Activity.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.thrymr.newexpensesapp.Activity.employee.TripNameExpensesActivity;
import com.example.thrymr.newexpensesapp.Adapter.employee.IndividualExpensesAdapter;
import com.example.thrymr.newexpensesapp.Adapter.employee.TripExpensesAdapter;
import com.example.thrymr.newexpensesapp.R;
import com.example.thrymr.newexpensesapp.Views.CustomFontTextView;
import com.example.thrymr.newexpensesapp.listners.admin.IndividualExpensesItemClickListner;
import com.example.thrymr.newexpensesapp.listners.employee.TripExpensesItemClickListner;
import com.example.thrymr.newexpensesapp.models.IndividualExpenses;
import com.example.thrymr.newexpensesapp.models.TripExpenses;

import java.util.ArrayList;
import java.util.List;

public class TripExpensesActivity extends AppCompatActivity {

    private RecyclerView revNameOfExpenses;
    private CustomFontTextView tripName;
    private CustomFontTextView tripDate;
    private RelativeLayout notificationRl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_expenses);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Shrikant Tripathi");

        setWights();
    }

    private void setWights() {
        notificationRl = (RelativeLayout) findViewById(R.id.notification_layout);
        tripName = (CustomFontTextView) findViewById(R.id.trip_name);
        tripDate = (CustomFontTextView) findViewById(R.id.trip_date);
        revNameOfExpenses = (RecyclerView) findViewById(R.id.rev_name_of_expenses);

        revNameOfExpenses.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        List<IndividualExpenses> individualExpensesArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            IndividualExpenses individualExpenses = new IndividualExpenses();
            individualExpenses.setExpensesName("Cab");
            individualExpenses.setExpensesDate("12-07-2017");
            individualExpenses.setTotalAmount("$500");
            individualExpenses.setExpensesStatus("Accept");
            individualExpensesArrayList.add(individualExpenses);

        }
        revNameOfExpenses.setAdapter(new IndividualExpensesAdapter(this, individualExpensesArrayList, new IndividualExpensesItemClickListner() {
            @Override
            public void itemOnClickListner(IndividualExpenses individualExpenses) {
                startActivity(new Intent(TripExpensesActivity.this, ExpensesDetailsActivity.class));
            }
        }));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStack();
            } else {
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
