package com.example.jieleo.matierialdesigndemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;

import com.example.jieleo.matierialdesigndemo.R;

public class RatingBarActivity extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener {

    RatingBar mRatingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);
        mRatingBar = (RatingBar) findViewById(R.id.rating_bar);
        mRatingBar.setOnRatingBarChangeListener(this);
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        Log.d("RatingBarActivity", "rating:" + rating);
    }
}
