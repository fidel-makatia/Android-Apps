package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public double currency=0.0;
    public void convFunction(View view)
    {
        EditText amount=(EditText) findViewById(R.id.usdText);
        double d=Double.parseDouble(amount.getText().toString());
        currency=d*107;
        Toast.makeText(this, "Ksh"+currency, Toast.LENGTH_LONG).show();
        Log.i("info", "Button Clicked: ");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}