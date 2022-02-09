package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView timerText;
    SeekBar timerBar;
    boolean counterIsActive=false;
    Button goButton;
    CountDownTimer countDownTimer;
    public void resetTimer()
    {
        timerText.setText("0:30");
        timerBar.setProgress(30);
        timerBar.setEnabled(true);
        countDownTimer.cancel();
        goButton.setText("GO!");
        counterIsActive=false;
    }
    public  void buttonClicked(View view){

        if(counterIsActive)
        {
            resetTimer();



        }else
        {
            counterIsActive=true;
            timerBar.setEnabled(false);
            goButton.setText("STOP!");
        }


      countDownTimer=  new CountDownTimer(timerBar.getProgress()*1000+100,1000){


            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int) millisUntilFinished/1000);

            }

            @Override
            public void onFinish() {
                Log.i("Finished! ", "Timer Done: ");
                MediaPlayer mplayer=MediaPlayer.create(getApplicationContext(),R.raw.airhorn);
                mplayer.start();
                Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
                resetTimer();

            }
        }.start();
    }

    public  void updateTimer(int secondsleft){
        int minutes=secondsleft/60;
        int seconds=secondsleft-(minutes*60);
        String secondString= Integer.toString(seconds);


        if(seconds<=9)
        {
            secondString="0"+ secondString;
        }

        timerText.setText(Integer.toString(minutes) +":"+ secondString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerBar=findViewById(R.id.timerseekBar);
      timerText=findViewById(R.id.countdowntextView);
      goButton=findViewById(R.id.Gobutton);

        timerBar.setMax(600);
        timerBar.setProgress(30);
        timerBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);

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