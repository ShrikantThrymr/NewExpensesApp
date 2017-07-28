package com.example.thrymr.newexpensesapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.thrymr.newexpensesapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        setValues();
    }

    private void setValues() {
        loginButton=(RelativeLayout)findViewById(R.id.email_sign_in_button);

        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.email_sign_in_button:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
        }
    }
}
