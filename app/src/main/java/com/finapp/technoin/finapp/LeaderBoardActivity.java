package com.finapp.technoin.finapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.finapp.technoin.finapp.domain.LeaderBoard;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LeaderBoardActivity extends AppCompatActivity {

    private String URL = "https://finapp-bengalhack.herokuapp.com/leaderboard";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final RecyclerView leaderBoard = findViewById(R.id.scoreList);
        leaderBoard.setLayoutManager(new LinearLayoutManager(this));

        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                LeaderBoard[] leaderBoardJson = gson.fromJson(response, LeaderBoard[].class);
                leaderBoard.setAdapter(new LeaderBoardAdapter(leaderBoardJson, LeaderBoardActivity.this));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LeaderBoardActivity.this,"Something went wrong",Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}
