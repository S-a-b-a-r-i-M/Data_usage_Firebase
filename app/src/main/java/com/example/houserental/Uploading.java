package com.example.houserental;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Uploading extends AppCompatActivity {

   // RadioButton rbtn_owner,rbtn_tenant,rbtn_individual,rbtn_flat;
    Button btn_upload;
    EditText house_name,rent,advance,street,landmark,city,pin,dist,url,description,phone_num;
    CheckBox cbox_bachelor,cbox_family;
    ArrayList<House> houseList;
    MyApplication myApplication= (MyApplication) this.getApplication();
    int id;
    String category="";

    @SuppressLint({"MissingInflatedId", "SuspiciousIndentation"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploading);

        btn_upload=findViewById(R.id.btn_upload);
        //RADIO BUTTON
        /*rbtn_owner=findViewById(R.id.rbtn_owner);
        rbtn_tenant=findViewById(R.id.rbtn_tenant);
        rbtn_individual=findViewById(R.id.individual);
        rbtn_flat=findViewById(R.id.flat);*/
        //EDIT TEXT
        house_name=findViewById(R.id.et1_house_name);
        rent=findViewById(R.id.et2_rent);
        advance=findViewById(R.id.et3_advance);
        phone_num=findViewById(R.id.phone_number);
        street=findViewById(R.id.et4_street);
        city=findViewById(R.id.et5_city);
        pin=findViewById(R.id.et6_pin);
        dist=findViewById(R.id.et7_dist);
        url=findViewById(R.id.et8_img_url);
        landmark=findViewById(R.id.et9_landmark);
        description=findViewById(R.id.description);
        //CHECK BOX
        cbox_bachelor=findViewById(R.id.cbox_bachelor);
        cbox_family=findViewById(R.id.cbox_family);

        houseList=myApplication.getHouseList();
        id=myApplication.getNextId();


        if(cbox_bachelor.isChecked() && cbox_family.isChecked())
            category+="Bachelor and Family is allowed";
        else if(cbox_family.isChecked())
            category+="only Family is allowed";
        else if(cbox_bachelor.isChecked())
            category+="only Bachelors is allowed";
        else
            category+="Bachelor and Family is allowed";

            btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //CREATE A NEW HOUSE LIST
               House newHouse=new House(id,house_name.getText().toString(),phone_num.toString(),street.getText().toString(),city.getText().toString(),landmark.getText().toString(),dist.getText().toString(),category,description.getText().toString(),
                                        url.getText().toString(),Integer.parseInt(rent.getText().toString()),Integer.parseInt(advance.getText().toString()),Integer.parseInt(pin.getText().toString()));
                houseList.add(newHouse);
                myApplication.setNextId(id++);//INCREMENT THE NEXT ID FOR THE NEXT ITEM

                Toast.makeText(getApplicationContext(),"New House LIst is Created Successfully",Toast.LENGTH_LONG).show();
                //GO TO THE MAIN
                Intent intent=new Intent(Uploading.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),Integer.toString(houseList.size()),Toast.LENGTH_LONG).show();
            }
        });
    }
}