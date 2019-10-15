package com.example.bannerwithflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipper=(ViewFlipper) findViewById(R.id.view_flipper);
        int[] images={R.drawable.img2,R.drawable.img3};

        for(int i=0;i<images.length;i++)
        { flipimages(images[i]);
        }

    }

    private void flipimages(int i) {
        ImageView view= new ImageView(this);
        view.setBackgroundResource(i);
        flipper.addView(view);
        flipper.setFlipInterval(4000);
        flipper.setAutoStart(true);
        flipper.setInAnimation(this,android.R.anim.slide_in_left);
        flipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }
}
