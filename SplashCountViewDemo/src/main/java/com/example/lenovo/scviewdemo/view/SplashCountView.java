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
 * Created by Lenovo on 2016/3/17.
 */
public class SplashCountView extends View {
    Paint paint;
    Paint paintCurrent;
    public SplashCountView(Context context) {
        super(context);
    }
    public SplashCountView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("gray"));
        paintCurrent = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintCurrent.setColor(Color.parseColor("red"));
    }
    public SplashCountView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private int count = 3;//splash引导页数量
    private int currentPosition = 0;
    private int layoutLeft = 350;//px
    private int layoutTop = 1400;
    private int width = 50;
    private int height = 20;
    private int margin = 50;

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
        count = viewPager.getAdapter().getCount();
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // update(position);
               // Log.i("onPageScrolled", "position" + position + "positionOffset" + positionOffset + "positionOffsetPixels" + positionOffsetPixels);
                //updateOffset(positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                update(position);
                Log.i("onPageSelected", "position" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        initRect(count);
    }
    int offset;
    private void updateOffset(int positionOffsetPixels) {
        offset = width*positionOffsetPixels/pagerWidth;
        Log.i("updateOffset", "offset" + offset+"pagerWidth"+pagerWidth);
        //在当前的矩形上再绘制一个offset矩形
        invalidate();
    }

    ArrayList<Rect> rects;
    int pagerWidth = 1080;
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        pagerWidth = getMeasuredWidth();
    }

    private void initRect(int count) {
        rects = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Rect rect = new Rect(layoutLeft + i * (width + margin), layoutTop, layoutLeft + width + i * (width + margin), layoutTop + height);
            rects.add(rect);
        }

    }

    private void update(int position) {
        currentPosition = position;
        Log.i("update","position="+position);
        invalidate();
    }

    private ViewPager viewPager;
    Rect currentRect;
    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < rects.size(); i++) {
            if (i == currentPosition) {
                currentRect = rects.get(i);
                canvas.drawRect(currentRect, paintCurrent);

            } else {
                canvas.drawRect(rects.get(i), paint);
            }

        }
       // currentRect.right = currentRect.left+offset;
       // canvas.drawRect(currentRect, paint);

        super.onDraw(canvas);
    }

}
