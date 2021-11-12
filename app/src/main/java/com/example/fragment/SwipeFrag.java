package com.example.fragment;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class SwipeFrag extends Fragment {

    private ImageView imageView;
    private ArrayList<String> images;
    MainActivity mainActivity;
    private View mview;
    String path;
    public SwipeFrag(String path) {
        // Required empty public constructor
        this.path = path;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mview = inflater.inflate(R.layout.fragment_swipe, container, false);
       // mainActivity = (MainActivity) getActivity();
        //images = ImageGallery.listOfImage(mainActivity);
        //System.out.println("Swipe Frag co path la " + path);
        imageView = (ImageView) mview.findViewById(R.id.img_full);
        if(path!=null) {
            System.out.println("Swipe Frag co path la " + path);
            imageView.setImageBitmap(BitmapFactory.decodeFile(path));
            Glide.with(this).load(path).into(imageView);
            //imageView.setImageURI(Uri.parse(path));
        }
        return mview;
    }
}