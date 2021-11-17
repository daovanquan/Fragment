package com.example.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class Picture extends Fragment {

    RecyclerView recyclerView;
    GalleryAdapter galleryAdapter;
    private List<String> images;

    private View mview;
    private MainActivity mMainActivity;
    private static final int MY_READ_PERMISSION_CODE = 101;

    public Picture() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mview = inflater.inflate(R.layout.fragment_picture, container, false);

        mMainActivity = (MainActivity) getActivity();

        //gallery_number = mview.findViewById(R.id.gallery_number);
        recyclerView = mview.findViewById(R.id.recycleview_gallery_images);

        if(ContextCompat.checkSelfPermission(mMainActivity,
                Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(mMainActivity,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},MY_READ_PERMISSION_CODE);
        }else{
            loadImage();
        }
        return mview;
    }

    private void loadImage()
    {
        mMainActivity = (MainActivity) getActivity();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(mMainActivity,4));
        images = ImageGallery.listOfImage(mMainActivity);
        galleryAdapter = new GalleryAdapter(mMainActivity, images, new GalleryAdapter.PhotoListener() {
            @Override
            public void onPhotoClick(int position) {
                //Toast.makeText(mMainActivity, ""+position, Toast.LENGTH_SHORT).show();
                Toast.makeText(mMainActivity, "" + String.valueOf(images.get(position)), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mMainActivity,FullScreen.class);
                intent.putExtra("pos",position);
                intent.putExtra("image",String.valueOf(images.get(position)));
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(galleryAdapter);

       // gallery_number.setText("Photos (" + images.size() +")");
    }
}