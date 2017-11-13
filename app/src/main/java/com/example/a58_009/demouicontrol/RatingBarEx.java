package com.example.a58_009.demouicontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingBarEx extends AppCompatActivity {

    RatingBar ra1,ra2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratingbar);
        ra1 = (RatingBar)findViewById(R.id.ratingBar);
        ra2 = (RatingBar)findViewById(R.id.ratingBar2);
        ra2.setOnRatingBarChangeListener(listener); //ra2設定監聽器
    }

    RatingBar.OnRatingBarChangeListener listener = new RatingBar.OnRatingBarChangeListener() {//設立RatingBar一個監聽器
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            Toast.makeText(RatingBarEx.this,"您給的評分是:"+(int)(rating+0.5)+"顆星",Toast.LENGTH_SHORT).show();
        }
    };
}
