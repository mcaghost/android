package com.example.multy_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    public ListView l1;

    String[] arr1 ={".Net Technologies","Android Developer","Web Technologies","Cloud Computing","Data Structures","Information Security","Computer Networks","Linux","Java"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l1=findViewById(R.id.listview1);
        myadapter ma=new myadapter(this,R.layout.mylayout,arr1);
        l1.setAdapter(ma);


    }
}