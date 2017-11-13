package com.example.a58_009.demouicontrol;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressBarEx extends AppCompatActivity {
    ProgressBar progressBar;
    TextView tvPercent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);
        progressBar =(ProgressBar)findViewById(R.id.progressBar);
        tvPercent =(TextView)findViewById(R.id.percent);

        new MyAsyncTask().execute("開始下載");//開始執行
    }
    private class MyAsyncTask extends AsyncTask<String,Integer,String>{     //MyAsyncTask反黑 所以須建立一個物件(上兩行)
        @Override
        protected String doInBackground(String... params) {
            int k = (int)(Math.random()*5);
            if(params[0].equals("開始下載"))
            for(int i=0;i<=101;i+=k){
                try {

                        Thread.sleep(100);//每隔一段時間 遞增i的值
                        publishProgress(i);//要通知出去的i值(陣列)

//                    tvPercent.setText(i+"%");//UI的互動 必須從UI Thread(執行緒)執行 不能寫在內部類別裡
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "下載完畢";
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tvPercent.setText(values[0]+"%");   //doInBackground傳過來的值 放入陣列裡 設定%數
            progressBar.setProgress(values[0]); //設定數條跑進度
            progressBar.setSecondaryProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String result) {    //傳入 "下載完畢"
            super.onPostExecute(result);
            Toast.makeText(ProgressBarEx.this,result,Toast.LENGTH_LONG).show();
        }
    }
}
