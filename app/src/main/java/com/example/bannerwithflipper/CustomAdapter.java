package com.example.bannerwithflipper;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class CustomAdapter extends PagerAdapter {

    private Context context;
    private List<Slider> slidelist;
    private int custom_pos = 0;
    LayoutInflater inflater;

    public CustomAdapter(List<Slider> slidelist, Context context) {
        this.context = context;
        this.slidelist = slidelist;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        int count = slidelist.size();
        if (count > 1) {
            count = Integer.MAX_VALUE;
        }
        return count;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        if (custom_pos > 3)
            custom_pos = 0;

        Slider slide = slidelist.get(custom_pos);

        custom_pos++;
        View itemview = inflater.inflate(R.layout.singleitem, container, false);
        ImageView img = (ImageView) itemview.findViewById(R.id.imageView);
        img.setImageResource(slide.getImgid());
        container.addView(itemview);
        return itemview;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        Log.e("destroyItem", "Callled");
        container.removeView((ViewGroup) object);
    }


}
