package com.example.databasepract;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_name, et_rollno;

    private Button addData, viewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name=findViewById(R.id.txtName);
        et_rollno=findViewById(R.id.txtRollNo);
        addData=findViewById(R.id.btnInsert);
        viewData=findViewById(R.id.btnDisplay);

        Dbhandler h1 = new Dbhandler(this);

        addData.setOnClickListener(v ->{
            String stdName = et_name.getText().toString();
            String stdRollNo = et_rollno.getText().toString();

            if(stdName.isEmpty() || stdRollNo.isEmpty()){
                Toast.makeText(MainActivity.this,"Please enter all dtls", Toast.LENGTH_SHORT).show();
                return;
            }

            h1.addStudent(stdName, stdRollNo);

            Toast.makeText(MainActivity.this,"Student has been added",Toast.LENGTH_SHORT).show();
            et_name.setText("");
            et_rollno.setText("");

        });

        viewData.setOnClickListener(v->{
            Intent i = new Intent(MainActivity.this,ViewStudent.class);
            startActivity(i);
        });


    }
}