package com.example.whatstheweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

   EditText editText;
   TextView resultTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editTextTextPersonName2);
        resultTextView=findViewById(R.id.resultView);



    }

    public  void BtnWeather (View view){

        DownloadTask task= new DownloadTask();
        task.execute("https://api.openweathermap.org/data/2.5/weather?q="+editText.getText().toString()+"&appid=cf95f65fdc444897ebda1a031d4f8e1d");
        InputMethodManager mgr=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(editText.getWindowToken(),0);

    }


    public class DownloadTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls) {
            String results="";
            URL url;
            HttpURLConnection urlConnection=null;
            try {
                url =new URL(urls[0]);
                urlConnection=(HttpURLConnection) url.openConnection();
                InputStream in =urlConnection.getInputStream();
                InputStreamReader reader =new InputStreamReader((in));
                int data=reader.read();

                while (data !=-1)
                {
                    char current=(char) data;
                    results+=current;
                    data=reader.read();

                }
                return results;



            }catch (Exception e)
            {
                e.printStackTrace();

                Toast.makeText(getApplicationContext(), "Could not find weather :(", Toast.LENGTH_SHORT).show();
                return  null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject jsonObject=new JSONObject(s);
                String weatherInfo=jsonObject.getString("weather");
                Log.i("Weather content", weatherInfo);
                JSONArray arr=new JSONArray(weatherInfo);

                String message="";
                for(int i=0;i< arr.length();i++)
                {
                    JSONObject jsonpart= arr.getJSONObject(i);
                    String main=jsonpart.getString("main");
                    String description=jsonpart.getString("description");

                    if(!main.equals("") && !description.equals(""))
                    {
                        message+=main+": "+description;
                    }

                    Log.i("main", jsonpart.getString("main"));
                    Log.i("description", jsonpart.getString("description"));
                }
                if(!message.equals("")){
                    resultTextView.setText(message);
                }else{
                    Toast.makeText(getApplicationContext(), "Could not find weather :(", Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Could not find weather :(", Toast.LENGTH_SHORT).show();
            }

        }
    }

}