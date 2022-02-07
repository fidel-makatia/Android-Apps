package com.example.audio_project;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    String check="";
    public void playBtn(View view){

        mediaPlayer.start();
    }

    public  void pauseBtn(View view){

        mediaPlayer.pause();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer=MediaPlayer.create(this, R.raw.demo);
        audioManager= (AudioManager) getSystemService(AUDIO_SERVICE);

        int maxVol=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVol=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);


        SeekBar volumeControl=(SeekBar) findViewById(R.id.volumeseekBar);

        volumeControl.setMax(maxVol);
        volumeControl.setProgress(currentVol);

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress,0);
               check = Integer.toString(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
       // Toast.makeText(this,  " Volume:"+check, Toast.LENGTH_SHORT).show();

        SeekBar scrubSeekBar=(SeekBar)findViewById(R.id.scrubseekBar);
        scrubSeekBar.setMax(mediaPlayer.getDuration());
        scrubSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
       new Timer().scheduleAtFixedRate(new TimerTask() {
           @Override
           public void run() {
               scrubSeekBar.setProgress(mediaPlayer.getCurrentPosition());
           }
       },0,300);
    }
}