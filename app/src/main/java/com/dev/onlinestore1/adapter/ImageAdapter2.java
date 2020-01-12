package com.dev.onlinestore1.adapter;


import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.onlinestore1.fragment.Fragment_Cart;
import com.dev.onlinestore1.fragment.Fragment_Home;
import com.dev.onlinestore1.hodel.ImageViewHodel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ImageAdapter2 extends RecyclerView.Adapter<ImageViewHodel> {

     private Fragment_Cart context;
     private ArrayList<String> uri;
     private int i;

    public ImageAdapter2(Fragment_Cart context, ArrayList<String> uri, int i) {
        this.context = context;
        this.uri = uri;
        this.i = i;
    }

    @NonNull
    @Override
    public ImageViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(i,parent,false);
        return new ImageViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHodel holder, final int position) {
        Picasso.get().load(uri.get(position)).resize(1080,1920).centerCrop(Gravity.TOP).into(holder.img);


    }

    @Override
    public int getItemCount() {
        return uri.size();
    }
}
