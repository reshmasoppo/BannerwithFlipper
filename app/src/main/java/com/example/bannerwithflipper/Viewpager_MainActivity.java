package com.example.bannerwithflipper;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Viewpager_MainActivity extends AppCompatActivity {

    List<Slider> slidelist = new ArrayList<>();
    private Timer timer;
    private int current_position = 0;

    ViewPager pager;
    CustomAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_main);
        prepareslide();
        adapter = new CustomAdapter(slidelist, this);
        pager =findViewById(R.id.viewpager_id);
        pager.setAdapter(adapter);
        /*After setting the adapter use the timer */
       createslideshow();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void prepareslide()
    {
        int[] images = {R.drawable.img1};

        for (int count=0; count<images.length; count++) {
            slidelist.add(new Slider(images[count]));
        }
    }

public void createslideshow()
{

    if(slidelist.size()> 1)
    {

        final Handler handler = new Handler();
         final Runnable runnable = new Runnable() {
            @Override
            public void run() {

                if (current_position != slidelist.size()) {
                    pager.setCurrentItem(current_position++, true);
                }
                else
                {
                    current_position=0;
                    pager.setCurrentItem(0,true);
                }
            }
        };
         timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 300, 2500);

    }
}}