package com.example.lenovo.ViewPagerGuideDotsDemo;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lenovo.ViewPagerGuideDotsDemo.view.ViewPagerGuideDots;

public class MainActivity extends AppCompatActivity {
    private int[] startPics =new int[]{R.mipmap.start_1,R.mipmap.start_2,R.mipmap.start_3,R.mipmap.start_4};
    private NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        ViewPagerGuideDots guideDots = (ViewPagerGuideDots)findViewById(R.id.guideDots);
        guideDots.setViewShape(ViewPagerGuideDots.ViewShape.Circle);
        ViewPager  viewPager = (ViewPager) findViewById(R.id.vp);
        viewPager.setAdapter(getAdapter());
        guideDots.setViewPager(viewPager);
    }

    @NonNull
    private PagerAdapter getAdapter() {
        //FragmentPagerAdapter
        return new PagerAdapter() {
            @Override
            public int getCount() {
                return startPics.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
//                View view = View.inflate(MainActivity.this,R.layout.item_viewpager,null);
//                ImageView iv = (ImageView)view.findViewById(R.id.iv_start);

                ImageView iv = new ImageView(MainActivity.this);
                iv.setBackgroundResource(startPics[position]);

                container.addView(iv);
                return iv;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View)object);
            }
        };
    }


}
