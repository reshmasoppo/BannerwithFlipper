package com.example.bannerwithflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipper = findViewById(R.id.view_flipper);

        int[] images = {R.drawable.img1};

        for (int i = 0; i < images.length; i++) {
            flipperimages(images[i]);
        }
    }


    private void flipperimages(int i) {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);
        flipper.addView(view);
        flipper.setFlipInterval(2000);
        flipper.setAutoStart(true);
        flipper.stopFlipping();
        // flipper.setInAnimation(this, android.R.anim.slide_in_left);
        //flipper.setOutAnimation(this, android.R.anim.slide_out_right);
        flipper.setInAnimation(this, R.anim.slide_in_left11);
        flipper.setOutAnimation(this, R.anim.slide_in_right1);
    }
}
