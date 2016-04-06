package com.example.lenovo.scviewdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by zhengpeng on 2016/3/17.
 */
public class SplashCountView extends View {
    Paint paintNormal;
    Paint paintSelected;
    private float selectedLeftScale;
    ArrayList<Rect> rects;
    ArrayList<Circle> circles;

    private int count = 3;//splash引导页数量
    private int currentPosition = 0;
    private int layoutLeft = 350;//px 引导方块的左边距
    private int layoutTop = 1400;//引导方块的上边距
    private int width = 50; //方块宽
    private int height = 20;//方块高
    private int margin = 50;//方块之间间距
    private int radius = 15;

    private String normalColor = "gray";
    private String selectedColor = "red";

    public enum ViewShape {
        Rect, Circle
    }

    public enum MotionType {
        Gradual, Sudden
    }

    private ViewShape defaultViewShape = ViewShape.Rect;
    private MotionType defaultMotionType = MotionType.Gradual;
    private ViewShape viewShape = defaultViewShape;
    private MotionType motionType = defaultMotionType;

    public void setViewShape(ViewShape viewShape) {
        this.viewShape = viewShape;
    }

    public void setMotionType(MotionType motionType) {
        this.motionType = motionType;
    }
    public void setShapeAndType(ViewShape viewShape,MotionType motionType) {
        this.viewShape = viewShape;
        this.motionType = motionType;
    }
    public SplashCountView(Context context) {
        super(context);
    }

    public SplashCountView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paintNormal = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintNormal.setColor(Color.parseColor(normalColor));
        paintSelected = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintSelected.setColor(Color.parseColor(selectedColor));
    }

    public SplashCountView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
        count = viewPager.getAdapter().getCount();
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private int oldPositionOffsetPixels;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.i("onPageScrolled", "position" + position + "positionOffset" + positionOffset + "positionOffsetPixels" + positionOffsetPixels+"delta="+delta);
//
//                if (oldPositionOffsetPixels > 0) {
//                    //第二次调用onPageScrolled，说明可以计算delta了 向左滑 positionOffsetPixels逐渐增大，delta为正数。
//                    delta = positionOffsetPixels - oldPositionOffsetPixels;
//                }
//                oldPositionOffsetPixels = positionOffsetPixels;
                if (motionType == MotionType.Gradual) {
                    selectedLeftScale = position + positionOffset ;
                    invalidate();
                }
            }

            @Override
            public void onPageSelected(int position) {
                if (motionType == MotionType.Sudden) {
                    selectedLeftScale = position;
                    invalidate();
                }
                Log.i("onPageSelected", "position" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        switch (viewShape){
            case Circle:
                initCircle(count);
                break;
            case Rect:
                initRect(count);
                break;

        }
    }

    private void initCircle(int count) {
        circles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Circle c = new Circle(layoutLeft + i * (radius*2 + margin), layoutTop, radius);
            circles.add(c);
        }

    }
    private void initRect(int count) {
        rects = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Rect rect = new Rect(layoutLeft + i * (width + margin), layoutTop, layoutLeft + width + i * (width + margin), layoutTop + height);
            rects.add(rect);
        }
    }

    int pagerWidth = -1;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        pagerWidth = getMeasuredWidth();
        int viewPagerMeasuredWidth = viewPager.getMeasuredWidth();
        int child0vidth = viewPager.getChildAt(0).getMeasuredWidth();
        int child1vidth = viewPager.getChildAt(1).getMeasuredWidth();

        Log.i("", "onSizeChanged" + pagerWidth+"viewPagerMeasuredWidth"+viewPagerMeasuredWidth+"child0vidth"+child0vidth+"child1vidth"+child1vidth);
    }



    private void update(int position) {
        currentPosition = position;
        Log.i("update", "position=" + position);
        invalidate();
    }

    private ViewPager viewPager;
    Rect selectedRect = new Rect(layoutLeft, layoutTop, layoutLeft + width, layoutTop + height);
    Circle selectedCircle = new Circle(layoutLeft, layoutTop,radius);
    @Override
    protected void onDraw(Canvas canvas) {
        switch (viewShape){
            case Circle:
                selectedCircle.circleX = layoutLeft+ (int)(selectedLeftScale*(radius*2+margin));
                for (int i = 0; i < circles.size(); i++) {
                    Circle circle = circles.get(i);
                    canvas.drawCircle(circle.circleX, circle.circleY, radius, paintNormal);
                }
                canvas.drawCircle(selectedCircle.circleX,selectedCircle.circleY, radius,paintSelected);
                break;
            case Rect:
                selectedRect.left = layoutLeft + (int)(selectedLeftScale*(width+margin));
                selectedRect.right = layoutLeft + (int)(selectedLeftScale*(width+margin) + width);
                for (int i = 0; i < rects.size(); i++) {
                    canvas.drawRect(rects.get(i), paintNormal);
                }

                canvas.drawRect(selectedRect, paintSelected);
                break;
        }

        super.onDraw(canvas);
    }
    class Circle {
        int circleX;
        int circleY;
        int radius;

        public Circle(int circleX, int circleY, int radius) {
            this.circleX = circleX;
            this.circleY = circleY;
            this.radius = radius;
        }
    }
}
