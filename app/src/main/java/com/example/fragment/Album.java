package com.example.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Album extends Fragment {

    private View mview;
    MainActivity mainActivity;
    TextView gallery;
    RecyclerView albumRecyle;
    private List<imageFolder> images;
    private static final int MY_READ_PERMISSION_CODE = 101;

    public Album() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mview = inflater.inflate(R.layout.fragment_album, container, false);

        mainActivity = (MainActivity) getActivity();
        gallery = mview.findViewById(R.id.folderName);
        albumRecyle = mview.findViewById(R.id.recycleview_album);

        if(ContextCompat.checkSelfPermission(mainActivity,
                Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(mainActivity,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},MY_READ_PERMISSION_CODE);
        }

        //albumRecyle.addItemDecoration(new MarginDecoration(mainActivity));
        albumRecyle.hasFixedSize();
        ArrayList<imageFolder> folds = ImageGallery.getPicturePaths(mainActivity);
        if(folds.isEmpty()){
            gallery.setVisibility(View.VISIBLE);
        }else{
            RecyclerView.Adapter folderAdapter = new AlbumAdapter(folds, mainActivity, new AlbumAdapter.itemClickListener() {
                @Override
                public void onPicClicked(PicHolder holder, int position, ArrayList<pictureFacer> pics) {

                }
                @Override
                public void onPicClicked(String pictureFolderPath, String folderName) {
                    Intent move = new Intent(mainActivity,ImageAlbum.class);
                    move.putExtra("folderPath",pictureFolderPath);
                    move.putExtra("folderName",folderName);

                    //move.putExtra("recyclerItemSize",getCardsOptimalWidth(4));
                    startActivity(move);
                }
            });
            albumRecyle.setAdapter(folderAdapter);
        }

        return mview;
    }
}