package com.example.fragment;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;


public class ImageGallery {
    //@RequiresApi(api = Build.VERSION_CODES.O)
    public  static ArrayList<String> listOfImage(Context context)
    {
        Uri uri;
        Cursor cursor;
        int colum_index_data,colum_index_folder_name;
        ArrayList<String> listOfAllImages = new ArrayList<>();
        String ablosutePathofImage;
        uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {MediaStore.MediaColumns.DATA,
        MediaStore.Images.Media.BUCKET_DISPLAY_NAME};

        String orderBy = MediaStore.Video.Media.DATE_TAKEN;
        cursor = context.getContentResolver().query(uri,projection,null,
                null,orderBy + "");

        colum_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);

        //colum_index_folder_name = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);
        while(cursor.moveToNext())
        {
            ablosutePathofImage = cursor.getString(colum_index_data);

            listOfAllImages.add(ablosutePathofImage);
        }

        return listOfAllImages;
    }
}
