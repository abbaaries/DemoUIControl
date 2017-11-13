package com.example.a58_009.demouicontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.sql.Array;

public class CheckBoxEx extends AppCompatActivity {
    CheckBox cbox11,cbox12,cbox13,cbox21,cbox22,cbox23;
    Button submit;
    TextView result1,result2;
    CheckBox[] cboxsport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        findView();
        setListener();
    }
    void findView(){
        cbox11 = (CheckBox) findViewById(R.id.checkBox11);
        cbox12 = (CheckBox) findViewById(R.id.checkBox12);
        cbox13 = (CheckBox) findViewById(R.id.checkBox13);
        cbox21 = (CheckBox) findViewById(R.id.checkBox21);
        cbox22 = (CheckBox) findViewById(R.id.checkBox22);
        cbox23 = (CheckBox) findViewById(R.id.checkBox23);
        cboxsport = new CheckBox[]{cbox21,cbox22,cbox23};
        submit = (Button) findViewById(R.id.submit);
        result1 = (TextView) findViewById(R.id.result1);
        result2 = (TextView) findViewById(R.id.result2);
    }
    private void setListener(){
        submit.setOnClickListener(btnListener);
        cbox21.setOnCheckedChangeListener(cboxListener);
        cbox22.setOnCheckedChangeListener(cboxListener);
        cbox23.setOnCheckedChangeListener(cboxListener);
    }
    View.OnClickListener btnListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String text ="您喜歡的顏色是:";
            if(cbox11.isChecked())
              text += cbox11.getText()+"、";
            if(cbox12.isChecked())
                text += cbox12.getText()+"、";
            if(cbox13.isChecked())
                text += cbox13.getText()+"、";
            if(text.endsWith("、"))
                result1.setText(text.substring(0,text.length()-1));	//取消掉最後的、符號
            else
                result1.setText(text);

        }
    };
    CheckBox.OnCheckedChangeListener cboxListener = new CheckBox.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String text ="平常的休閒活動是:";
            for(int i=0;i<cboxsport.length;i++) {
                if(cboxsport[i].isChecked() )
                text += cboxsport[i].getText() + "、";
            }
            if (text.endsWith("、"))
                result2.setText(text.substring(0, text.length() - 1));
            result2.setText(text);
        }
    };
}
