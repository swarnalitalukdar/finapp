package com.finapp.technoin.finapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RewardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
