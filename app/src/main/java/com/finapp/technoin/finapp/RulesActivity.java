package com.finapp.technoin.finapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
