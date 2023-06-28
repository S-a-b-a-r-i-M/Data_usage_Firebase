package com.example.houserental;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    RecyclerView rv;

    ArrayList<House> houseList=new ArrayList<>();//CREATING A LIST TO STORE LIST OF HOUSES
    MyApplication myApplication=(MyApplication) this.getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=findViewById(R.id.rv);

        houseList=myApplication.getHouseList();//GET THE HOUSE LIST FROM MYAPPLICATION

        rv.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter=new MyAdapter(this,houseList);
        rv.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mnu1:
                intent=new Intent(MainActivity.this,Uploading.class);
                startActivity(intent);
                return true;

            case R.id.mnu2:
                FirebaseAuth.getInstance().signOut();
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);

        return true;
    }
}