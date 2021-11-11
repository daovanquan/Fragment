package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private ViewPager mViewPager;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nagvigation);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position)
                {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.menu_picture).setChecked(true);
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.menu_album).setChecked(true);
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.menu_story).setChecked(true);
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.menu_share).setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.menu_picture:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.menu_album:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.menu_story:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.menu_share:
                        mViewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
    }
}