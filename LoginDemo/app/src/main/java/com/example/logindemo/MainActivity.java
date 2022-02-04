package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public  void loginFunction(View view){
        EditText userName= (EditText) findViewById(R.id.username);

        EditText passwordText=(EditText)findViewById(R.id.Password);

        Log.i("info", "Button Pressed: ");
        Log.i("UserName", userName.getText().toString());
        Log.i("Password", passwordText.getText().toString());

        Toast.makeText(this, "Hi "+ userName.getText().toString(), Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}