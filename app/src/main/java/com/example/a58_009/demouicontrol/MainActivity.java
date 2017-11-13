package com.example.a58_009.demouicontrol;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    ListView listView;

    String[] getactivityNames()  {
        String[] activityNames = new String[classes.length];
        for(int i = 0;i<classes.length;i++){
            activityNames[i] = classes[i].getSimpleName();
        }
        return activityNames;
    }
    Class<?>[] classes={
            AlertDialogEx.class,
            CheckBoxEx.class,
             DatePickerEx.class,
            ListViewEx.class,
            ProgressBarEx.class,
            RadioButtonEx.class,
            RatingBarEx.class,
            TimePickerEx.class,
            ToggleButtonEx.class,
            SpinnerEx.class,
            GridViewEx.class
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listview1);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,getactivityNames());
        listView.setAdapter(adapter);
//        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,classes[position]);
                startActivity(intent);
            }
        });
    }
}
