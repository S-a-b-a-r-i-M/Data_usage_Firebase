package com.example.houserental;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView img;
    TextView tv_houseName,tv_city;
    RelativeLayout parentLayout;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        img=itemView.findViewById(R.id.img);
        tv_houseName=itemView.findViewById(R.id.tv_houseName);
        tv_city=itemView.findViewById(R.id.tv_city);
        parentLayout=itemView.findViewById(R.id.view_of_1house);
    }
}
