# ViewPagerGuideDotsDemo
用Viewpager作为引导页时，往往需要添加小圆点或者小方块来做提示当前引导页页数和进度。
使用这个控件可以方便设置这些小圆点或者小小方块样式：
ViewPagerGuideDots guideDots = (ViewPagerGuideDots)findViewById(R.id.guideDots);
        ViewPager  viewPager = (ViewPager) findViewById(R.id.vp);
        viewPager.setAdapter(getAdapter());
        guideDots.setViewPager(viewPager);
           


## 效果图  Preview



![](https://github.com/tmac1999/ViewPagerGuideDotsDemo/tree/master/images/countdownviewdemo.gif)

### setViewShape(ViewPagerGuideDots.ViewShape.Circle);
ViewPagerGuideDots guideDots = (ViewPagerGuideDots)findViewById(R.id.guideDots);
        guideDots.setViewShape(ViewPagerGuideDots.ViewShape.Circle);
        ViewPager  viewPager = (ViewPager) findViewById(R.id.vp);
        viewPager.setAdapter(getAdapter());
        guideDots.setViewPager(viewPager);

![](https://github.com/tmac1999/ViewPagerGuideDotsDemo/tree/master/images/circle.png)
# ViewPagerGuideDotsDemo
When  using a viewpager for splash page.You always need to add some small circles or rectangles to imply current selected pager and total pager count.
Try this custom view so you could conveniently settle this things:
ViewPagerGuideDots guideDots = (ViewPagerGuideDots)findViewById(R.id.guideDots);
        ViewPager  viewPager = (ViewPager) findViewById(R.id.vp);
        viewPager.setAdapter(getAdapter());
        guideDots.setViewPager(viewPager);

easily to make introduction dots(or rectangles) above the viewpager.


update 4.6


