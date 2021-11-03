package com.example.baitap2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class cutsview extends View {
    public cutsview(Context context) {
        super(context);
        init(null);
    }
    public cutsview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public cutsview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public cutsview(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet set){

    }

    @Override
    protected void onDraw(Canvas canvas) {
       canvas.drawColor(Color.WHITE);
       Paint p=new Paint();
        p.setAntiAlias(true);
        p.setColor(Color.BLUE);
        p.setTextSize(60);


        canvas.drawRect(200,100,400,260, p);
        canvas.drawText("Hình chữ nhật",100,350,p);
        canvas.drawRect(200,500,300,600, p);
        canvas.drawText("Hình vuông",100,700,p);

//        canvas.drawRect(900,1600,200,200, p);
//        canvas.drawText("Hình vuông",600,1000,p);

        canvas.drawCircle(200, 900, 100, p);
        canvas.drawText("Tam giác",100,1100,p);

    }

}
