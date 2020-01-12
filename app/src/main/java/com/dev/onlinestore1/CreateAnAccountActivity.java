package com.dev.onlinestore1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class CreateAnAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_an_account);

        getSupportActionBar().setTitle(getString(R.string.btn_signup));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
