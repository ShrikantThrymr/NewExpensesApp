package com.example.thrymr.newexpensesapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.thrymr.newexpensesapp.Adapter.NotificationAdapter;
import com.example.thrymr.newexpensesapp.R;
import com.example.thrymr.newexpensesapp.models.NotificationModel;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {
    private RecyclerView.Adapter itemsAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private ArrayList<NotificationModel> listOfNotifications;
    private  NotificationModel notificationModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        recyclerView = (RecyclerView) findViewById(R.id.notification_recycle_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Notifications");
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        listOfNotifications = setStaticNotificationData();
        itemsAdapter = new NotificationAdapter(listOfNotifications);
        recyclerView.setAdapter(itemsAdapter);
    }

    private ArrayList<NotificationModel> setStaticNotificationData() {
        listOfNotifications = new ArrayList<>();
        notificationModel = new NotificationModel(1, "CabPayment", "23-2-2014", "Approved");
        listOfNotifications.add(notificationModel);
        notificationModel =new NotificationModel(2, "FoodPayment", "26-2-2014", "Pending");
        listOfNotifications.add(notificationModel);
        notificationModel = new NotificationModel(3, "HosipatelPayment", "24-6-2018", "Approved");
        listOfNotifications.add(notificationModel);
        return listOfNotifications;
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


}
