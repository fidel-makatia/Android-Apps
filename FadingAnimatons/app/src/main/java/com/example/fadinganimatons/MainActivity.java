package com.example.fadinganimatons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view){

        ImageView imageView1=(ImageView)findViewById(R.id.homerimageView);
        ImageView imageView=(ImageView) findViewById(R.id.imageView);
            imageView.animate().scaleX(0.5f).scaleY(0.5f).setDuration(1000);
           // imageView1.animate().alpha(1).setDuration(2000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ImageView imageView=(ImageView) findViewById(R.id.imageView);
        imageView.setX(-1000);
        imageView.animate().translationXBy(1000).rotation(3600).setDuration(2000);

    }
}