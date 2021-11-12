package com.example.fragment;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SwipeAdapter extends FragmentStatePagerAdapter {

    private List<String> images;
    MainActivity mainActivity;
   // String path;
    public SwipeAdapter(@NonNull FragmentManager fm, int behavior,List<String> images) {
        super(fm, behavior);
        this.images = images;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        //System.out.println("Duong dan la" + String.valueOf(images.get(position)));

        return new SwipeFrag(String.valueOf(images.get(position)));
    }

    @Override
    public int getCount() {

        //System.out.println("Kich co " + images.size());
        return images.size();
    }
}
