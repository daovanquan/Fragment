package com.example.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private Context context;
    private List<String> images;
    protected PhotoListener photoListener;

    public GalleryAdapter(Context context, List<String> images, PhotoListener photoListener) {
        this.context = context;
        this.images = images;
        this.photoListener = photoListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =  LayoutInflater.from(context).inflate(R.layout.gallery_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String image = images.get(position);
        if(image==null)return;
        // load anh
        Glide.with(context).load(image).into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                photoListener.onPhotoClick(position);

            }
        });


    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imagegallery);
        }
    }

    //interface
    public interface PhotoListener{
        void onPhotoClick(int position);

    }
}
