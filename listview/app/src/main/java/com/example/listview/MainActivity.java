package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView=findViewById(R.id.myListView);

        ArrayList<String> myFamily= new ArrayList<String>();
        myFamily.add("Fidel");
        myFamily.add("Cynthia");
        myFamily.add("Beryl");
        myFamily.add("Mum");
        myFamily.add("Dad");
        myFamily.add("Fidel");
        myFamily.add("Cynthia");
        myFamily.add("Beryl");
        myFamily.add("Mum");
        myFamily.add("Dad");
        myFamily.add("Fidel");
        myFamily.add("Cynthia");
        myFamily.add("Beryl");
        myFamily.add("Mum");
        myFamily.add("Dad");
        myFamily.add("Fidel");
        myFamily.add("Cynthia");
        myFamily.add("Beryl");
        myFamily.add("Mum");
        myFamily.add("Dad");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myFamily);
        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Person Selected", myFamily.get(position));

                Toast.makeText(getApplicationContext(), "Hello "+myFamily.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}