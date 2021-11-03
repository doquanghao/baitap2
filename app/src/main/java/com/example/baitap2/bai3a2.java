package com.example.baitap2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class bai3a2 extends AppCompatActivity {
    TextView imageView;
    Animation animation;
    Button fadeIn,fadeOut, blink, zoomIn, zoomOut, rotate, move, slideUp, slideDown, sequential, together;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3a2);
        imageView = findViewById(R.id.hion);
        fadeIn=findViewById(R.id.fadein);
        fadeOut=findViewById(R.id.fadeout);
        blink=findViewById(R.id.blink);
        zoomIn=findViewById(R.id.zoomin);
        zoomOut=findViewById(R.id.zoomout);
        rotate=findViewById(R.id.rotate);
        move=findViewById(R.id.move);
        sequential=findViewById(R.id.sequential);
        together=findViewById(R.id.together);

        fadeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
                start(animation);
            }
        });
        fadeOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeout); start(animation);
            }
        });
        blink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink); start(animation);
            }
        });
        zoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomin); start(animation);
            }
        });
        zoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomout); start(animation);
            }
        });
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imageView.animate().translationY(-400).setDuration(1000).setStartDelay(0);
//                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
//                start(animation);
            }
        });
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move); start(animation);
            }
        });


        together.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.truottrai); start(animation);
            }
        });
    }
    void start(Animation animation){
        imageView.startAnimation(animation); }
}