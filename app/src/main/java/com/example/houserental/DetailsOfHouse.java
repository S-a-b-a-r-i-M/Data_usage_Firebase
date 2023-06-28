package com.example.houserental;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailsOfHouse extends AppCompatActivity {

    ArrayList<House> houseList;
    ImageView house_img;
    TextView city_name,landmark_name,street_name,district_name,pincode,
            available_to,rent_amount,advance_amount,owner_name,contact_num,
            type,tv_property_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_house);

        house_img=findViewById(R.id.house_img);
        city_name=findViewById(R.id.tv1_city_name);
        landmark_name=findViewById(R.id.tv2_landmark_name);
        street_name=findViewById(R.id.tv3_street_name);
        district_name=findViewById(R.id.tv4_district_name);
        pincode=findViewById(R.id.tv5_pincode);
        available_to=findViewById(R.id.tv_availabe_to);
        rent_amount=findViewById(R.id.tv1_rent_amount);
        advance_amount=findViewById(R.id.tv2_advance_amount);
        owner_name=findViewById(R.id.tv3_owner_name);
        contact_num=findViewById(R.id.tv6_number);
        type=findViewById(R.id.tv5_flat_or_apartment);

        Intent intent=getIntent();
        int id=intent.getIntExtra("id",-1);

        houseList=MyApplication.getHouseList();
        House house=null;

        if(id>=0)
        {
            for(House h : houseList)
            {
                if(id==h.getId())
                {
                    house=h;
                    break;
                }
            }
        }
        else
            Toast.makeText(getApplicationContext(),"id not matched",Toast.LENGTH_LONG).show();

        //ASSINGN THE DETAILS

        Glide.with(getApplicationContext())
             .load(house.getImg_url())
             .into(house_img);
        city_name.setText(house.getCity());
        landmark_name.setText(house.getLandmark());
        district_name.setText(house.getDistrict());
        pincode.setText(Integer.toString(house.getPincode()));
        street_name.setText(house.getStreet());
        available_to.setText(house.getAvailableTo());
        rent_amount.setText(Integer.toString(house.getRent()));
        advance_amount.setText(Integer.toString(house.getAdvance()));
        owner_name.setText(house.getHouseName());
        contact_num.setText(house.getPhone_num());
        type.setText("Not Assigned");

    }
}