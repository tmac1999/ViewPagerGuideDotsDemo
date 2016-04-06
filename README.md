# SplashCountViewDemo
用Viewpager作为引导页时，往往需要添加小圆点或者小方块来做提示当前引导页页数和进度。
使用这个控件可以方便设置这些小圆点或者小小方块样式：
SplashCountView scView = (SplashCountView)findViewById(R.id.scView);
ViewPager  viewPager = (ViewPager) findViewById(R.id.vp);
           viewPager.setAdapter(getAdapter());
           scView.setViewPager(viewPager);
------------------------------------------------------------------
When  using a viewpager for splash page.You always need to add some small circles or rectangles to imply current selected pager and total pager count.
Try this custom view so you could conveniently settle this things:
SplashCountView scView = (SplashCountView)findViewById(R.id.scView);
ViewPager  viewPager = (ViewPager) findViewById(R.id.vp);
           viewPager.setAdapter(getAdapter());
           scView.setViewPager(viewPager);

easily to make introduction dots(or rectangles) above the viewpager.


update 4.6


