package com.example.fadinganimatons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int count=0;
    public void fade(View view){
        ImageView imageView=(ImageView) findViewById(R.id.imageView);
        ImageView imageView1=(ImageView)findViewById(R.id.homerimageView);
        if(count==0) {
            imageView.animate().alpha(0).setDuration(2000);
            imageView1.animate().alpha(1).setDuration(2000);
            count++;
        }
        else
        {
            imageView1.animate().alpha(0).setDuration(2000);
            imageView.animate().alpha(1).setDuration(2000);
            count=0;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}