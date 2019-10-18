package com.example.bannerwithflipper;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

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
        pager = findViewById(R.id.viewpager_id);
        prepareSlide();
        adapter = new CustomAdapter(slidelist, this);
        pager.setAdapter(adapter);
        /*After setting the adapter use the timer */
        createSlideshow();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void prepareSlide() {
        int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};

        for (int count = 0; count < images.length; count++) {
            slidelist.add(new Slider(images[count]));
        }
    }

    private void createSlideshow() {
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (current_position == Integer.MAX_VALUE)
                    current_position = 0;
                pager.setCurrentItem(current_position++, true);

            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 250, 2500);
    }
}