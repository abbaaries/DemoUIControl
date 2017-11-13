package com.example.a58_009.demouicontrol;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RadioButtonEx extends AppCompatActivity {
    RadioGroup rg1,rg2,rg3;
    Button submit;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobutton);
        findView();
        setListeners();
    }
    private void findView(){
        rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        rg3 = (RadioGroup) findViewById(R.id.radioGroup3);
        submit = (Button) findViewById(R.id.submit);
        result = (TextView) findViewById(R.id.result1);

    }
    private  void setListeners(){       //監聽器按鈕
        submit.setOnClickListener(btnListener);
        rg1.setOnCheckedChangeListener(rgListener);
        rg2.setOnCheckedChangeListener(rgListener);
        rg3.setOnCheckedChangeListener(rgListener);
    }
    View.OnClickListener btnListener =new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            RadioButton rBtn = (RadioButton)findViewById(rg1.getCheckedRadioButtonId());
            String text = "您對此次用餐感到?"+rBtn.getText();
            result.setText(text);

//            RadioButton rBtn2 = (RadioButton)findViewById(rg2.getCheckedRadioButtonId());
//            text +=result.getText().toString()+ "您對此次用餐感到?"+rBtn2.getText();
//            result.setText(text2);
//            RadioButton rBtn3 = (RadioButton)findViewById(rg3.getCheckedRadioButtonId());
//            text3 = "您對此次用餐感到?"+rBtn3.getText();
//            result.setText(text3);
        }
    };
        RadioGroup.OnCheckedChangeListener rgListener = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                int resId = group.getId();
                String groupName = getResources().getResourceEntryName(resId);
                String itemName = getResources().getResourceEntryName(checkedId);
                RadioButton rBtn = (RadioButton)findViewById(checkedId);
                switch (resId){
                    case R.id.radioGroup1:
                        String text1 = "您對此次用餐感到?"+rBtn.getText();
                        Toast.makeText(RadioButtonEx.this,text1,Toast.LENGTH_LONG).show();
                    case R.id.radioGroup2:
                        String text2 = "您的性別是?"+rBtn.getText();
                        Toast.makeText(RadioButtonEx.this,text2,Toast.LENGTH_LONG).show();
                    case R.id.radioGroup3:
                        String text3 = "您的年齡是?"+rBtn.getText();
                        Toast.makeText(RadioButtonEx.this,text3,Toast.LENGTH_LONG).show();
//                        Toast.makeText(RadioButtonEx.this,groupName+":"+itemName,Toast.LENGTH_LONG).show();      //加上Toast 測試是否正常運作
                         break;
                }
//                RadioButton rBtn = (RadioButton)findViewById(checkedId);
//                String text = "您對此次用餐感到?"+rBtn.getText();
//                result.setText(text);
//                Toast.makeText(RadioButtonEx.this,text,Toast.LENGTH_LONG).show();
            }
        };
}
