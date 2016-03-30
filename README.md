# SplashCountViewDemo
When you using a viewpager in splash page.
try this :
SplashCountView scView = (SplashCountView)findViewById(R.id.scView);
ViewPager  viewPager = (ViewPager) findViewById(R.id.vp);
           viewPager.setAdapter(getAdapter());
           scView.setViewPager(viewPager);

easily to make introduction dots(or recktangles) above the viewpager.
