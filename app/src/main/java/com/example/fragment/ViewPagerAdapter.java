package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0 :
                return new Picture();
            case 1 :
                return new Album();
            case 2 :
                return new Story();
            case 3 :
                return new Share();
            default:
                return new Picture();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
