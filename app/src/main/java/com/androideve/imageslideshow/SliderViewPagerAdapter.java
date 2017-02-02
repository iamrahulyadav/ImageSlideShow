package com.androideve.imageslideshow;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

public class SliderViewPagerAdapter extends PagerAdapter implements View.OnClickListener {
    Context context;
    List<String> list;
    LayoutInflater inflater;


    public SliderViewPagerAdapter(Context paramContext, List<String> paramArrayList) {
        this.context = paramContext;
        this.list = paramArrayList;
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
        ((ViewPager) paramViewGroup).removeView((LinearLayout) paramObject);

    }


    public int getCount() {
        return this.list.size();
    }

    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
        this.inflater = ((LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        View localView = this.inflater.inflate(R.layout.image_viewpager_item, paramViewGroup, false);
        ImageView localImageView = (ImageView) localView.findViewById(R.id.image);

        localImageView.setTag(paramInt);
        ((ViewPager) paramViewGroup).addView(localView);

        if(list.get(paramInt).equalsIgnoreCase("img1")){

            localImageView.setImageResource(R.drawable.img1);
        }
        else if(list.get(paramInt).equalsIgnoreCase("img2")){

            localImageView.setImageResource(R.drawable.img2);
        }
        else if(list.get(paramInt).equalsIgnoreCase("img3")){

            localImageView.setImageResource(R.drawable.img3);
        }
        else if(list.get(paramInt).equalsIgnoreCase("img4")){

            localImageView.setImageResource(R.drawable.img4);
        }
        else if(list.get(paramInt).equalsIgnoreCase("img5")){

            localImageView.setImageResource(R.drawable.img5);
        }

        else if(list.get(paramInt).equalsIgnoreCase("img6")){

            localImageView.setImageResource(R.drawable.img6);
        }
        else if(list.get(paramInt).equalsIgnoreCase("img7")){

            localImageView.setImageResource(R.drawable.img7);
        }
        else if(list.get(paramInt).equalsIgnoreCase("img8")){

            localImageView.setImageResource(R.drawable.img8);
        }
        else if(list.get(paramInt).equalsIgnoreCase("img9")){

            localImageView.setImageResource(R.drawable.img9);
        }

        localImageView.setOnClickListener(this);

        return localView;


    }

    @Override
    public void onClick(View view) {

        int position = (Integer) view.getTag();

        Toast.makeText(context,"Clicked on image"+position,Toast.LENGTH_LONG).show();
    }

    public boolean isViewFromObject(View paramView, Object paramObject) {
        boolean bool;
        if (paramView != (LinearLayout) paramObject)
            bool = false;
        else
            bool = true;
        return bool;
        //return view.equals(object);
    }

}