package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SeekBar timesTable;



    ListView listView;

    int timesTablenumber;
    int startingPos=10;
    public void generateTimesTable(int j)
    {

        ArrayList<String> tableContent=new ArrayList<String>();

        for(int i=0;i<=100;i++)
        {
            tableContent.add(Integer.toString(i* j));
        }

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,tableContent);

        listView.setAdapter(arrayAdapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timesTable = findViewById(R.id.seekBar);
        listView = findViewById(R.id.timetablesListView);

        generateTimesTable(startingPos);

        timesTable.setMax(20);
        timesTable.setProgress(10);
        timesTable.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;

                if(progress<min){
                    timesTablenumber=min;
                   timesTable.setProgress(timesTablenumber);
                }
                else
                {
                    timesTablenumber=progress;
                    timesTable.setProgress(timesTablenumber);
                }

                generateTimesTable(timesTablenumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}