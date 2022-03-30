package com.example.jsondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public class DownloadTask extends AsyncTask<String,Void,String>{

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
                for(int i=0;i< arr.length();i++)
                {
                    JSONObject jsonpart= arr.getJSONObject(i);
                    Log.i("main", jsonpart.getString("main"));
                    Log.i("description", jsonpart.getString("description"));
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadTask task= new DownloadTask();
        task.execute("https://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=cf95f65fdc444897ebda1a031d4f8e1d");
    }
}