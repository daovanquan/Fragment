package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class FullScreen extends AppCompatActivity {

    //int position;
    //ViewPager viewPager;
    ImageView imageV;
    String imageLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        imageV = findViewById(R.id.image_full);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            //position = bundle.getInt("image");
            imageLink = bundle.getString("image");
        }

        imageV.setImageURI(Uri.parse(imageLink));

    }
}