package com.example.a58_009.demouicontrol;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditTextEx extends AppCompatActivity {
    public static final String PREF_FILE = "settings";
    public EditText etAccount ;
    public EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);
        findView();
        restore();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }
    void findView(){
        etAccount = (EditText) findViewById(R.id.account);
        etPassword =(EditText) findViewById(R.id.password);


    }
    private  void restore() {
        SharedPreferences settings = getSharedPreferences(PREF_FILE, 0);
        String account = settings.getString(PREF_FILE, "");
        String password = settings.getString(PREF_FILE, "");
        if (!"".equals(account))
            etAccount.setText(account);
        if (!password.equals(""))
            etPassword.setText(password);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences settings = getSharedPreferences(PREF_FILE, 0);
        settings.edit().putString("etAccount",etAccount.getText().toString());
        settings.edit().putString("etPassword",etPassword.getText().toString());
    }
}
