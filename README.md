# ViewPagerGuideDotsDemo
用Viewpager作为引导页时，往往需要添加小圆点或者小方块来做提示当前引导页页数和进度。
使用这个控件可以方便设置这些小圆点或者小小方块样式：



## 效果图  Preview
##### 1.默认 default
（三个小方块是png图片自带的，对比四个小方块是代码绘制）
```
ViewPagerGuideDots guideDots = (ViewPagerGuideDots)findViewById(R.id.guideDots);
        ViewPager  viewPager = (ViewPager) findViewById(R.id.vp);
        viewPager.setAdapter(getAdapter());
        guideDots.setViewPager(viewPager);
```
![gif](https://github.com/tmac1999/ViewPagerGuideDotsDemo/blob/master/images/countdownviewdemo.gif)

##### 2.圆形
setViewShape(ViewPagerGuideDots.ViewShape.Circle);
```
ViewPagerGuideDots guideDots = (ViewPagerGuideDots)findViewById(R.id.guideDots);
        guideDots.setViewShape(ViewPagerGuideDots.ViewShape.Circle);
        ViewPager  viewPager = (ViewPager) findViewById(R.id.vp);
        viewPager.setAdapter(getAdapter());
        guideDots.setViewPager(viewPager);
```
![png](https://github.com/tmac1999/ViewPagerGuideDotsDemo/blob/master/images/circle.png)
##### 3.不使用滑动渐变动画
```
guideDots.setMotionType(ViewPagerGuideDots.MotionType.Sudden);
```
效果自行脑补...


###### That's all.

---
# ViewPagerGuideDotsDemo
When  using a viewpager for splash page.You always need to add some small circles or rectangles to imply current selected pager and total pager count.
Try this custom view so you could conveniently settle this things:
```
ViewPagerGuideDots guideDots = (ViewPagerGuideDots)findViewById(R.id.guideDots);
        ViewPager  viewPager = (ViewPager) findViewById(R.id.vp);
        viewPager.setAdapter(getAdapter());
        guideDots.setViewPager(viewPager);
```
easily to make introduction dots(or rectangles) above the viewpager.





