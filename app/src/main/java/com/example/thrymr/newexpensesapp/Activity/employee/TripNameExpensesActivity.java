package com.example.thrymr.newexpensesapp.Activity.employee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.thrymr.newexpensesapp.Adapter.employee.IndividualTripAdapter;
import com.example.thrymr.newexpensesapp.R;
import com.example.thrymr.newexpensesapp.models.TripIndividualModel;
import com.example.thrymr.newexpensesapp.models.TripModel;

import java.util.ArrayList;

public class TripNameExpensesActivity extends AppCompatActivity {
    private RecyclerView.Adapter itemsAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private TripModel tripModel;
    private ArrayList<TripIndividualModel> listOfTrips;
    private TripIndividualModel tripIndividualModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perticular_trip_list_expenses);
        setValues();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Singapore Trip");
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }

    private void setValues() {
        recyclerView = (RecyclerView) findViewById(R.id.perticular_trip_recycleview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(layoutManager);
        listOfTrips = setStaticIndividualTripData();
        itemsAdapter = new IndividualTripAdapter(listOfTrips);
        recyclerView.setAdapter(itemsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_noticication, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.add_tripExpense:
                Intent intent = new Intent(this, AddIndividualExpensesActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.notification).setVisible(false);
        return true;
    }

    public ArrayList<TripIndividualModel> setStaticIndividualTripData() {
        listOfTrips = new ArrayList<>();
        tripIndividualModel = new TripIndividualModel(1, "Cab", "23-2-2014", "Pending", "$10000", 1);
        listOfTrips.add(tripIndividualModel);
        tripIndividualModel = new TripIndividualModel(2, "Food", "26-2-2014", "Approved", "$1000", 1);
        listOfTrips.add(tripIndividualModel);
        tripIndividualModel = new TripIndividualModel(3, "Shoes", "24--2018", "Pending", "$70000", 2);
        listOfTrips.add(tripIndividualModel);
        tripIndividualModel = new TripIndividualModel(4, "Giftpack", "26-7-2016", "Pending", "$10000", 2);
        listOfTrips.add(tripIndividualModel);
        tripIndividualModel = new TripIndividualModel(5, "stationary", "23-2-2014", "Pending", "$10000", 2);
        listOfTrips.add(tripIndividualModel);
        return listOfTrips;
    }

}
