package com.example.a58_009.demouicontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewEx extends AppCompatActivity {
    ListView listView;
    String[] arrays ={"網路概論","通訊網路實驗","通訊概論"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView= (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_single_choice,arrays);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewEx.this,"第"+(position+1)+"項"+((CheckedTextView)view).getText(),Toast.LENGTH_SHORT).show();
                Toast.makeText(ListViewEx.this,parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
