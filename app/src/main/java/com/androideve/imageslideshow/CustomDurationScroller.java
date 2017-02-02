package com.androideve.imageslideshow;

/**
 * Created by bytesbrick on 1/2/17.
 */

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;


public class CustomDurationScroller extends Scroller {

    private int scrollFactor = 5000;

    public CustomDurationScroller(Context context) {
        super(context);
    }

    public CustomDurationScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }


    public void setScrollDurationFactor(int scrollFactor) {
        this.scrollFactor = scrollFactor;
    }


    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, scrollFactor);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, scrollFactor);
    }


}

