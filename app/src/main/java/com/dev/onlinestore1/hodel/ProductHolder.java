package com.dev.onlinestore1.hodel;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dev.onlinestore1.R;


public class ProductHolder extends RecyclerView.ViewHolder {
    public ImageView imgProduct;
    public TextView tvNameproduct;
    public TextView tvPrice;



    public ProductHolder(View itemView) {
        super(itemView);
        imgProduct =  itemView.findViewById(R.id.btn_product);
        tvNameproduct =  itemView.findViewById(R.id.tvNameproduct);
        tvPrice =  itemView.findViewById(R.id.tvPrice);
    }
}
