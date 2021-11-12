package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FullScreen extends AppCompatActivity {

    int position;
    ViewPager viewPager;
    ImageView imageV;
    String imageLink;
    private List<String> images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        imageV = findViewById(R.id.image_full);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            position = bundle.getInt("pos");
            imageLink = bundle.getString("image");
        }
        //System.out.println("path la " +imageLink);
        images = ImageGallery.listOfImage(this);
        imageV.setImageURI(Uri.parse(imageLink));
        //Toast.makeText(this, ""+ images.size(), Toast.LENGTH_SHORT).show();

        viewPager = findViewById(R.id.viewfull);
        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,images);
        viewPager.setAdapter(swipeAdapter);

    }
}