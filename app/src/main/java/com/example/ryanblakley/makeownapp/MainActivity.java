package com.example.ryanblakley.makeownapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView logo = findViewById(R.id.logo);
        final TextView title = findViewById(R.id.title);


        final Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);

        logo.startAnimation(fadeIn);
        title.startAnimation(fadeIn);

        final Intent intent = new Intent(this, NavigationActivity.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(intent);
                }
            }
        };

        timer.start();
    }
}
