package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public  int count=0;
    public void switchDog(View view){

        ImageView image=(ImageView) findViewById(R.id.DogimageView);

        if(count==0){
            image.setImageResource(R.drawable.dog2);
            count++;
        }
        else if(count==1)
        {
            image.setImageResource(R.drawable.dog3);
            count++;
        }
        else
        {
            image.setImageResource(R.drawable.dog1);
            count=0;
        }

        Log.i("info", "switchDog: pressed");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}