package com.example.baitap2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class animation extends AppCompatActivity {
    ImageView imgView;
    Animation animation;
    int[] imgsID;
    int [] animsID;
    int tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        imgView=findViewById(R.id.image);
        imgsID = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4,
                R.drawable.img5, R.drawable.img6};
                animsID = new int[]{R.anim.truottrai,R.anim.truotphai, R.anim.room, R.anim.thunho, R.anim.roomout,R.anim.upto};
        tt = 0;

        LoadAnh_Animation();

    }
    private void LoadAnh_Animation(){

        animation= AnimationUtils.loadAnimation
                (getApplicationContext(),animsID[tt%animsID.length]);
        System.out.println(tt);
        imgView.setImageResource(imgsID[tt % imgsID.length]);
        imgView.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                LoadAnh_Animation();
            }
        });
        tt++;
    }


}