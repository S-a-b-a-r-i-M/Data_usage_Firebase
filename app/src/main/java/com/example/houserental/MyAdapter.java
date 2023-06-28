package com.example.houserental;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<House> houseList;

    public MyAdapter(Context context, List<House> houseList) {
        this.context = context;
        this.houseList = houseList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.view_of_1house,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_houseName.setText(houseList.get(position).getHouseName());
        holder.tv_city.setText(houseList.get(position).getCity());
        Glide.with(context).load(houseList.get(position).getImg_url()).into(holder.img);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CLICK TO SEE FULL DETAIL ABOUT A HOUSE
                Intent intent=new Intent(context,DetailsOfHouse.class);
                //PASSING ID OF A PARTICULAR HOUSE
                intent.putExtra("id",houseList.get(holder.getAdapterPosition()).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return houseList.size();
    }
}
