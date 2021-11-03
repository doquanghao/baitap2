package com.example.baitap2;

import static com.example.baitap2.R.drawable.chunhat;
import static com.example.baitap2.R.drawable.tron;
import static com.example.baitap2.R.drawable.vuong;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.a);
        findViewById(R.id.do_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imageView.setColorFilter(getResources().getColor(R.color.do_1));
            }
        });
        findViewById(R.id.xanh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imageView.setBackgroundColor(getResources().getColor(R.color.xanh));

            }
        });
        findViewById(R.id.cam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setBackgroundColor(getResources().getColor(R.color.cam));

            }
        });
        findViewById(R.id.tim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setBackgroundColor(getResources().getColor(R.color.tim));

            }
        });
        findViewById(R.id.hong).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setBackground(getResources().getDrawable(R.color.hong));

            }
        });
        findViewById(R.id.vang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setBackgroundColor(getResources().getColor(R.color.vang));

            }
        });
        findViewById(R.id.vuong).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource( R.drawable.vuong);

            }
        });
        findViewById(R.id.tron).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imageView.setImageResource(tron);
            }
        });
        findViewById(R.id.chunhat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(chunhat);
            }
        });

    }
}