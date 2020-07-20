package com.finapp.technoin.finapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.hsalf.smilerating.SmileRating;

public class RateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SmileRating smileRating = (SmileRating) findViewById(R.id.smile_rating);
        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley) {

                switch (smiley) {
                    case SmileRating.BAD:
                        Toast.makeText(RateActivity.this, "BAD", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.GOOD:
                        Toast.makeText(RateActivity.this, "GOOD", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.GREAT:
                        Toast.makeText(RateActivity.this, "GREAT", Toast.LENGTH_SHORT).show();

                        break;
                    case SmileRating.OKAY:
                        Toast.makeText(RateActivity.this, "OKAY", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.TERRIBLE:
                        Toast.makeText(RateActivity.this, "TERRIBLE", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        smileRating.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level) {
//                Toast.makeText(RateActivity.this, "SELECTED RATING"+level, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
