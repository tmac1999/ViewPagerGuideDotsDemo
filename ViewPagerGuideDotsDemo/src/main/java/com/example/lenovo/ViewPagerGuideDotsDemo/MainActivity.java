package com.example.lenovo.ViewPagerGuideDotsDemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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
        ViewPager  viewPager = (ViewPager) findViewById(R.id.vp);
        viewPager.setAdapter(getAdapter());
        guideDots.setViewPager(viewPager);
    }

    @Override
    protected void onStop() {
        super.onStop();

        Notification notification = null;
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("点击打开应用");
        builder.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT));
        notification = builder.build();
        nm.notify(11, notification);
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

    LinearLayout ll_guide_points;
    ImageView redPoint;
    private void init() {
        ll_guide_points = (LinearLayout) findViewById(R.id.ll_guide_points);
        redPoint = (ImageView) findViewById(R.id.iv_guide_redPoint);
        // 初始化数据
        initData();
        // 设置数据适配器
        // 监听ViewPager的滑动事件
    }

    private void initData() {
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(this);

            ImageView point = new ImageView(this);
            point.setBackgroundResource(R.drawable.guide_point_normal);
            int pointDp2Px = CommonUtils.dp2px(this, 10);// dp转px
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(pointDp2Px, pointDp2Px);
            if (i != 0) {
                params.leftMargin = pointDp2Px;
            }
            point.setLayoutParams(params);
            ll_guide_points.addView(point);
        }
    }
}