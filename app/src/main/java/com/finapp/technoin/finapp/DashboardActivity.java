package com.finapp.technoin.finapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private static String username;
    private static String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        drawerLayout = findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                username = "Swarnali";
                email ="swarnali@gmail.com";
            } else {
                username = extras.getString("username");
                email = extras.getString("email");
            }
        } else {
            username = (String) savedInstanceState.getSerializable("username");
            email = (String) savedInstanceState.getSerializable("email");
        }

        NavigationView mNavigationView = findViewById(R.id.navigationView);
        View headerView = mNavigationView.getHeaderView(0);
        TextView navUsername =  headerView.findViewById(R.id.headerusername);
        TextView navEmail =  headerView.findViewById(R.id.headeremail);
        navUsername.setText(username);
        navEmail.setText(email);

        if (mNavigationView != null) {
            mNavigationView.setNavigationItemSelectedListener(this);
        }


        CardView inviteCardView = findViewById(R.id.inviteAndEarn);
        inviteCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, InviteActivity.class);
                startActivity(intent);
            }
        });

        CardView rewardCardView = findViewById(R.id.reward);
        rewardCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, RewardActivity.class);
                startActivity(intent);
            }
        });


        CardView leaderBoardView = findViewById(R.id.leaderBoard);
        leaderBoardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, LeaderBoardActivity.class);
                startActivity(intent);
            }
        });

        CardView playQuiz = findViewById(R.id.play_quiz);
        playQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, QuizStartActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent;
        switch (menuItem.getItemId()){
            case R.id.rules:
                intent = new Intent(DashboardActivity.this, RulesActivity.class);
                startActivity(intent);
                break;
            case R.id.db:
                intent = new Intent(DashboardActivity.this, DashboardActivity.class);
                startActivity(intent);
                break;
            case R.id.rate:
                intent = new Intent(DashboardActivity.this, RateActivity.class);
                startActivity(intent);
                break;
            case R.id.logout:
                intent = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
        return false;
    }
}
