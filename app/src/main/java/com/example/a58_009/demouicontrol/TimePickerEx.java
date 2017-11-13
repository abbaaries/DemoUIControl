package com.example.a58_009.demouicontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class TimePickerEx extends AppCompatActivity {
    TimePicker timePicker;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepickerex);

        timePicker = (TimePicker)findViewById(R.id.timePicker);
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();
                Toast.makeText(TimePickerEx.this,"您選擇的時間是:"+hour+":"+minute,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
