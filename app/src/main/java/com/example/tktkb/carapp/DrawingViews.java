package com.example.tktkb.carapp;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawingViews extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int width=20;
    Car redCar = new Car(0,0,Color.RED,5);
    Car blueCar = new Car(0,10,Color.BLUE,10);
    Car greenCar = new Car(0,20,Color.GREEN,11);
    Car blackCar =new Car(0,30,Color.BLACK,14);
    Car yellowCar= new Car(0, 40,Color.YELLOW,20);
    Car[] cars = new Car[]{redCar,blueCar,greenCar,blackCar,yellowCar};

    public DrawingViews(Context context) {
        super(context);
        init();
    }

    public DrawingViews(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawingViews(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < cars.length ; i++) {
            canvas.drawRect(cars[i].x, cars[i].y, cars[i].x+width,cars[i].y+width, paint);
        }
        moving();
    }
    public void moving(){
        for (int i = 0; i <cars.length ; i++) {
            cars[i].y+=2;
        }
        invalidate();
    }
}