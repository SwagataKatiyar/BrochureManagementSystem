package com.example.projectionactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity {
    private ViewPager mSlideViewLayout;
    private TextView[] mDots;
    private LinearLayout mDotsLayout;
    private Button previous;
    private Button next;
    private int CurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        previous=(Button)findViewById(R.id.button2);
        next=(Button)findViewById(R.id.button1);
        mSlideViewLayout= (ViewPager)findViewById(R.id.slideViewPager);
        mDotsLayout=(LinearLayout)findViewById(R.id.dotsLayout);
        SliderAdapter sliderAdapter = new SliderAdapter(this);
        mSlideViewLayout.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        mSlideViewLayout.addOnPageChangeListener(viewListener);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewLayout.setCurrentItem(CurrentPage+1);
                if(CurrentPage==5){
                    Intent intent = new Intent(Main5Activity.this, Main2Activity.class);
                    startActivity(intent);
                }

            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewLayout.setCurrentItem(CurrentPage-1);
            }
        });



    }

    public void addDotsIndicator(int position){

        mDots= new TextView[6];
        mDotsLayout.removeAllViews();
        for( int i=0; i<mDots.length;i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.transparent));
            mDotsLayout.addView(mDots[i]);

        }

        if(mDots.length>0){

            mDots[position].setTextColor((getResources().getColor(R.color.White)));
        }
    }
ViewPager.OnPageChangeListener viewListener= new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
    addDotsIndicator(i);
    CurrentPage=i;

    if(i==0)
    {
        next.setEnabled(true);
        previous.setEnabled(false);
        previous.setText("");
        next.setText("Next");
        previous.setVisibility(View.INVISIBLE);


    }

        else if(i==mDots.length-1)
        {

            next.setEnabled(true);
            previous.setText("Previous");
            next.setText("Get Started");
            previous.setVisibility(View.VISIBLE);
            previous.setEnabled(true);

        }

    else  {

        next.setEnabled(true);
        previous.setText("Previous");
        next.setText("Next");
        previous.setVisibility(View.VISIBLE);
        previous.setEnabled(true);

    }



    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
};
}


