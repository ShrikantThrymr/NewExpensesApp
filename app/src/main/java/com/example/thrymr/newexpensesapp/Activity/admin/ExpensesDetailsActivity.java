package com.example.thrymr.newexpensesapp.Activity.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.thrymr.newexpensesapp.Activity.MainActivity;
import com.example.thrymr.newexpensesapp.R;
import com.example.thrymr.newexpensesapp.Views.CustomFontTextView;
import com.example.thrymr.newexpensesapp.Views.CustomImageView;

public class ExpensesDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout notificationRl;
    private CustomFontTextView dateOfBillTv;
    private CustomFontTextView detailsTv;
    private CustomFontTextView totalAmountTv;
    private CustomImageView billPictureImg;
    private CustomFontTextView approveBtn;
    private CustomFontTextView rejectBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Expenses Details");

        setWights();
    }

    private void setWights() {
        notificationRl = (RelativeLayout) findViewById(R.id.notification_layout);
        dateOfBillTv = (CustomFontTextView) findViewById(R.id.dateOfBill_tv);
        detailsTv = (CustomFontTextView) findViewById(R.id.details_tv);
        totalAmountTv = (CustomFontTextView) findViewById(R.id.total_amount_tv);
        billPictureImg = (CustomImageView) findViewById(R.id.bill_picture_img);
        approveBtn = (CustomFontTextView) findViewById(R.id.approve_btn);
        rejectBtn = (CustomFontTextView) findViewById(R.id.reject_btn);


        approveBtn.setOnClickListener(this);
        rejectBtn.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.approve_btn:
                finish();
                break;
            case R.id.reject_btn:
                finish();
                //startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
