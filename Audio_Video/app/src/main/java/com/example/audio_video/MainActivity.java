package com.example.audio_video;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageButton play,pause;

    SeekBar seekBar;

    Thread updateSeek;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=findViewById(R.id.play);
        pause=findViewById(R.id.pause);
        seekBar=findViewById(R.id.seekBar);

        mediaPlayer=MediaPlayer.create(this,R.raw.harhargange);
        mediaPlayer.start();
        seekBar.setMax(mediaPlayer.getDuration());
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try{
                   seekBar.setProgress(mediaPlayer.getCurrentPosition());
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, 0,800);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());

            }
        });

        play.setOnClickListener(v -> mediaPlayer.start());
        pause.setOnClickListener(v -> mediaPlayer.pause());

    }

    private void clearMediaPlayer(){
        mediaPlayer.stop();
        mediaPlayer.release();
        updateSeek.interrupt();
        mediaPlayer=null;
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        clearMediaPlayer();
    }
}