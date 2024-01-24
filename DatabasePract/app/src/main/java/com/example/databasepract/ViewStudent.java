package com.example.databasepract;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewStudent extends AppCompatActivity {
    ArrayList<StudentModel> courseModelArrayList;
    Dbhandler dbhandler;

    StudentRvAdapter courseRVAdapter;
    RecyclerView studentRv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students);
        courseModelArrayList = new ArrayList<>();
        dbhandler=new Dbhandler(ViewStudent.this);

        courseModelArrayList = dbhandler.readStudent();
        courseRVAdapter = new StudentRvAdapter(courseModelArrayList, ViewStudent.this);
        studentRv=findViewById(R.id.idRVStudents);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(ViewStudent.this, RecyclerView.VERTICAL,false);
        studentRv.setLayoutManager(linearLayoutManager);
        studentRv.setAdapter(courseRVAdapter);
    }
}
