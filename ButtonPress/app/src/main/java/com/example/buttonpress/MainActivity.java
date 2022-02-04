package com.example.buttonpress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    public void clickFunction(View view){

        EditText nameEditText= (EditText) findViewById(R.id.nameEditText);

        Log.i("info", "Button clicked: ");

        Log.i("values", nameEditText.getText().toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}