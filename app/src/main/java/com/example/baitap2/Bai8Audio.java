package com.example.baitap2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterView;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Bai8Audio extends AppCompatActivity {

    CircleImageView hinhbaihat;
    TextView tenbaihat,tencasi,demthoigian,thoigan;
    SeekBar seekBar;
    ImageFilterView lailai,pause,play,chuyenbaitiep,laplai,laplai1;
    MediaPlayer mediaPlayer;
    Handler handler = new Handler();
    ArrayList<listamnhac>arrayList;
    int so;
    Boolean check;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai8_audio);
        anhxa();
        so=0;
        check=true;
        arrayList=new ArrayList<>();
        arrayList.add(new listamnhac("https://aredir.nixcdn.com/NhacCuaTui1021/AiNo1-MasewKhoiVu-7078913.mp3?st=uKDVpIWxCB5VjOLbgWObiw&e=1635844614&download=true","Ái Nộ","https://avatar-ex-swe.nixcdn.com/song/2021/08/30/2/1/a/e/1630316309035_500.jpg","Masew,Khôi vũ"));
        arrayList.add(new listamnhac("https://aredir.nixcdn.com/NhacCuaTui1021/CuoiThoi-MasewMasiuBRayTAPVietNam-7085648.mp3?st=w7OQDCGJf2BMPuvmhPyBTA&e=1635844797&download=true","Cưới thôi","https://avatar-ex-swe.nixcdn.com/song/2021/09/09/f/c/f/d/1631181753902_500.jpg","Masew,Masiu,B Ray,V.A"));
        arrayList.add(new listamnhac("https://aredir.nixcdn.com/NhacCuaTui1012/TheLuong-PhucChinh-6971140.mp3?st=wnclhjs02WFtJKAs_o8d6w&e=1635844925&download=true","Thê lương","https://avatar-ex-swe.nixcdn.com/song/2021/03/12/e/2/9/e/1615554946033_500.jpg","Phúc Chinh"));
         animation = AnimationUtils.loadAnimation(Bai8Audio.this, R.anim.rotation);


        lammoi();
        chuyenbaitiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                so++;
                if(so > arrayList.size() -1){
                    so =0;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    seekBar.setProgress(0);
                }
                lammoi();
                mediaPlayer.start();
                hinhbaihat.startAnimation(animation);
                play.setVisibility(View.GONE);
                pause.setVisibility(View.VISIBLE);
            }
        });
        lailai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                so--;
                if(so < 0){
                    so = arrayList.size() -1;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    seekBar.setProgress(0);
                }
                lammoi();
                mediaPlayer.start();
                hinhbaihat.startAnimation(animation);
                play.setVisibility(View.GONE);
                pause.setVisibility(View.VISIBLE);

            }
        });
        laplai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               check=false;
               laplai.setVisibility(View.GONE);
               laplai1.setVisibility(View.VISIBLE);
            }
        });
        laplai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check=true;
                laplai.setVisibility(View.VISIBLE);
                laplai1.setVisibility(View.GONE);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play.setVisibility(View.GONE);
                pause.setVisibility(View.VISIBLE);
                mediaPlayer.start();
                hinhbaihat.startAnimation(animation);
                updateSeekbar();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play.setVisibility(View.VISIBLE);
                pause.setVisibility(View.GONE);
                handler.removeCallbacks(update);
                mediaPlayer.pause();
                hinhbaihat.setAnimation(null);
            }
        });
        seekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                SeekBar seekBar = (SeekBar) view;
                int viTri = (mediaPlayer.getDuration()/100)*seekBar.getProgress();
                mediaPlayer.seekTo(viTri);
                demthoigian.setText(layThoiGian(mediaPlayer.getCurrentPosition()));
                return false;
            }
        });
        thoigan.setText(layThoiGian(mediaPlayer.getDuration()));
    }
    public void lammoi(){
        Glide.with(Bai8Audio.this).load(arrayList.get(so).getHinhanh()).into(hinhbaihat);
        tenbaihat.setText(arrayList.get(so).getTenbaihat());
        tencasi.setText(arrayList.get(so).getTacgia());
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(
                new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
        );
        try {
            mediaPlayer.setDataSource(arrayList.get(so).getLink());
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        hinhbaihat.setAnimation(null);
    }
    private void updateSeekbar() {
        if (mediaPlayer.isPlaying()) {
            seekBar.setProgress((int) (((float) mediaPlayer.getCurrentPosition() / mediaPlayer.getDuration()) * 100));
            seekBar.postDelayed(update, 1000);
        }
    }
    private Runnable update = new Runnable() {
        @Override
        public void run() {
            updateSeekbar();
            long thoiGianHienTai = mediaPlayer.getCurrentPosition();
            demthoigian.setText(layThoiGian(thoiGianHienTai));
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    if (check==true){
                        so++;
                    }
                    if(so > arrayList.size() -1){
                        so =0;
                    }
                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                        seekBar.setProgress(0);
                    }
                    lammoi();
                    mediaPlayer.start();
                    hinhbaihat.startAnimation(animation);
                    play.setVisibility(View.GONE);
                    pause.setVisibility(View.VISIBLE);

                }
            });
        }
    };
    private void anhxa() {
        hinhbaihat=findViewById(R.id.hinh_ambum);
        tenbaihat=findViewById(R.id.tenbaihat);
        tencasi=findViewById(R.id.tencasi);
        demthoigian=findViewById(R.id.demthoigian);
        thoigan=findViewById(R.id.thoigan);
        seekBar=findViewById(R.id.seekBar);
        lailai=findViewById(R.id.luilai);
        pause=findViewById(R.id.pause);
        play=findViewById(R.id.play);
        chuyenbaitiep=findViewById(R.id.chuyenbaitiep);
        laplai=findViewById(R.id.laplai);
        laplai1=findViewById(R.id.laplai1);
    }
    private String layThoiGian(long miliGiay) {
        String thoiGian = "";
        String stringGiay = "";
        int gio = (int) (miliGiay / (1000 * 60 * 60));
        int phut = (int) (miliGiay % (1000 * 60 * 60)) / (1000 * 60);
        int giay = (int) ((miliGiay % (1000 * 60 * 60)) % (1000 * 60) / 1000);
        if (gio > 0) {
            thoiGian = gio + ":";
        }
        if (giay < 10) {
            stringGiay = "0" + giay;
        } else {
            stringGiay = giay + "";
        }
        thoiGian = thoiGian + phut + ":" + stringGiay;
        return thoiGian;
    }
}