package com.example.projectionactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = (ImageView)findViewById(R.id.image);

        Animation animation= AnimationUtils.loadAnimation(this,R.anim.mytransition);
        view.startAnimation(animation);

        final Intent intent = new Intent(this, Main5Activity.class);
        Thread timer= new Thread() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(intent);
                    finish();
                }

            }
        };
        timer.start();


    }
}
