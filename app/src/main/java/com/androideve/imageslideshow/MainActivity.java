package com.androideve.imageslideshow;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AutoScrollViewPager viewPager;
    CirclePageIndicator circlePageIndicator;
    RelativeLayout viewpagerLayout;
    ArrayList<String> list = new ArrayList<>();
    int banner_pos = 0;

    private Handler handler;
    private Runnable runnable;
    SliderViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.clear();

        viewPager = (AutoScrollViewPager) findViewById(R.id.pager);
        viewPager.startAutoScroll();
        viewpagerLayout = (RelativeLayout) findViewById(R.id.viewpagerLayout);
        this.viewPager.setOffscreenPageLimit(3);
        this.circlePageIndicator = ((CirclePageIndicator)findViewById(R.id.circlePageIndicator));
        this.circlePageIndicator.setRadius(7.0F);
        this.circlePageIndicator.setStrokeWidth(2.0f);
        this.circlePageIndicator.setStrokeColor(R.color.appWhite);
        this.circlePageIndicator.setFillColor(R.color.colorPrimary);

        handler = new Handler();

        for(int i=0;i<9;i++){

            list.add("img"+(i+1));
        }


        initSliderViewPager();
    }

    private void initSliderViewPager() {

        if (handler != null) {
            if (runnable != null)
                handler.removeCallbacks(runnable);
        }


        if ((this.list == null) || (this.list.size() <= 0)) {
            this.viewpagerLayout.setVisibility(View.GONE);
        } else {
            if (this.list != null) {
                if (this.adapter == null) {
                    this.adapter = new SliderViewPagerAdapter(MainActivity.this, this.list);
                    this.viewPager.setAdapter(this.adapter);

                    if ((this.viewPager != null) && (this.adapter != null)) {
                        this.circlePageIndicator.setViewPager(this.viewPager);
                        this.viewpagerLayout.setVisibility(View.VISIBLE);
                    }


                    runnable = new Runnable() {
                        public void run() {
                            if (banner_pos > list.size() - 1) {
                                banner_pos = 0;
                            }

                            MainActivity.this.viewPager.setCurrentItem(banner_pos, true);

                            banner_pos = banner_pos + 1;

                            handler.postDelayed(runnable, 3000);
                        }
                    };

                    handler.postDelayed(runnable, 5000);

                }
            }
        }
    }

}
