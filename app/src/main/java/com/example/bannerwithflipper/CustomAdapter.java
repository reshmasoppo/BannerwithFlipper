package com.example.bannerwithflipper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

public class CustomAdapter extends PagerAdapter {
    private Context context;
    List<Slider> slidelist;
    LayoutInflater inflater;

    public CustomAdapter(List<Slider> slidelist, Context context) {
        this.context = context;
        this.slidelist = slidelist;
    }

    @Override
    public int getCount() {
        return slidelist.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }


    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Slider slide = slidelist.get(position);
        View itemview = inflater.inflate(R.layout.singleitem, container, false);
        ImageView img = (ImageView) itemview.findViewById(R.id.imageView);
        img.setImageResource(slide.getImgid());
        container.addView(itemview);
        return itemview;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((ConstraintLayout)object);
    }


}
