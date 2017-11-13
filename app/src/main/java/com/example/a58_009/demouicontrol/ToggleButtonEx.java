package com.example.a58_009.demouicontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class ToggleButtonEx extends AppCompatActivity {

    ToggleButton tgbtn1,tgbtn2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_togglebutton);
        findView();
        setListener();
    }
    void findView(){
        tgbtn1 = (ToggleButton) findViewById(R.id.toggleButton1);
        tgbtn2 = (ToggleButton) findViewById(R.id.toggleButton2);
        imageView = (ImageView) findViewById(R.id.imageView);
    }
    private void setListener(){
        tgbtn1.setOnCheckedChangeListener(listener);
        tgbtn2.setOnCheckedChangeListener(listener);
    }
    ToggleButton.OnCheckedChangeListener listener = new ToggleButton.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked)
                imageView.setImageResource(R.drawable.tip_bright);
            else
                imageView.setImageResource(R.drawable.tip_dark);
        }
    };
}
