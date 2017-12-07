package com.earl.labquiz2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView etDisplay;
    Button btn_logout;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        etDisplay = findViewById(R.id.display);
        btn_logout = findViewById(R.id.logout);
        preferences = getApplication().getSharedPreferences(" ", MODE_PRIVATE);

        String user = preferences.getString("username", "");
        String pwd = preferences.getString("password", "");

        etDisplay.setText(user);

    }

    public void logout (View view) {

        Intent intent = new Intent(this, MainActivity.class);
        String user = preferences.getString("username", "");
        user = null;
        startActivity(intent);

    }


}
