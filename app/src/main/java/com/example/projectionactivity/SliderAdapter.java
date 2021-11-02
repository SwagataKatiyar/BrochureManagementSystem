package com.example.projectionactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.zip.Inflater;


public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context=context;
    }

    public int[] slideImages={R.drawable.printing, R.drawable.promoicon,R.drawable.ware,R.drawable.distributions,R.drawable.gmail,R.drawable.solution};

    public String[] slide_headings={"Printing","Promo","WareHousing","Distribution","Mailing","IT Solutions"};

    public String[] slide_D={" Also it's not just the Printer Device which is affected Devices and Printers when I saw the little clock icon being displayed beside that before it disappeared",
        " Also it's not just the Printer Device which is affected Devices and Printers when I saw the little clock icon being displayed beside that before it disappeared",
        " Also it's not just the Printer Device which is affected Devices and Printers when I saw the little clock icon being displayed beside that before it disappeared",
        " Also it's not just the Printer Device which is affected Devices and Printers when I saw the little clock icon being displayed beside that before it disappeared",
        " Also it's not just the Printer Device which is affected Devices and Printers when I saw the little clock icon being displayed beside that before it disappeared",
        " Also it's not just the Printer Device which is affected Devices and Printers "};

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.slide_layout, container,false);
      ImageView  imageView=(ImageView)view.findViewById(R.id.imageView);
        TextView textView=(TextView)view.findViewById(R.id.tv);
        TextView textView1=(TextView)view.findViewById(R.id.tv1);

        imageView.setImageResource(slideImages[position]);
        textView.setText(slide_headings[position]);
        textView1.setText(slide_D[position]);
        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
container.removeView((RelativeLayout)object);
    }
}

