package com.example.graphicsanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgView;
    Button btnBlink, btnRotate, btnFade, btnMove, btnSlide, btnZoom, btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgView=findViewById(R.id.imageView);
        btnBlink=findViewById(R.id.btnBlink);
        btnRotate=findViewById(R.id.btnClockwise);
        btnSlide=findViewById(R.id.btnSlide);
        btnFade=findViewById(R.id.btnFade);
        btnMove=findViewById(R.id.btnMove);
        btnZoom=findViewById(R.id.btnZoom);
        btnStop=findViewById(R.id.btnStop);

        btnBlink.setOnClickListener(v ->{
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
            imgView.startAnimation(animation);
        });

        btnRotate.setOnClickListener(v ->{
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
            imgView.startAnimation(animation);
        });

        btnFade.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
            imgView.startAnimation(animation);
        });

        btnMove.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
            imgView.startAnimation(animation);
        });

        btnSlide.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide);
            imgView.startAnimation(animation);
        });

        btnZoom.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
            imgView.startAnimation(animation);
        });

        btnStop.setOnClickListener(v->{
            imgView.clearAnimation();
        });
    }


}