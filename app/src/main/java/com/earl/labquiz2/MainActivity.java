package com.earl.labquiz2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUser, etPassword;
    Button btn_rememberMe, btn_login;
    SharedPreferences.Editor editor;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = findViewById(R.id.user);
        etPassword = findViewById(R.id.password);

        btn_rememberMe = findViewById(R.id.rememberMe);
        btn_login = findViewById(R.id.login);

        preferences = getPreferences(Context.MODE_PRIVATE);

        SharedPreferences preferences = getApplicationContext().getSharedPreferences(" ", MODE_PRIVATE);
        editor = preferences.edit();

    }

    public void rememberUser (View view) {

        editor.putString("username", etUser.getText().toString());
        editor.putString("password", etPassword.getText().toString());
        editor.commit();
        Toast.makeText(this, "Account is saved!", Toast.LENGTH_SHORT).show();

    }

    public void login (View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        preferences = getApplication().getSharedPreferences(" ", MODE_PRIVATE);

        etUser = findViewById(R.id.user);
        etPassword = findViewById(R.id.password);

        String user = preferences.getString("username", "");
        String pwd = preferences.getString("password", "");

        if(etUser.getText().toString().equalsIgnoreCase(user) && etPassword.getText().toString().equals(pwd)){
            startActivity(intent);
            //correct password
        }else{
            Toast.makeText(this, "Invalid account!", Toast.LENGTH_SHORT).show();
            //wrong password
        }


    }
}
