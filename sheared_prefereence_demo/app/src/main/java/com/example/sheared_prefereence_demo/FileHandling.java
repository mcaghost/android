package com.example.sheared_prefereence_demo;

import static com.example.sheared_prefereence_demo.MainActivity.savePref;
import static com.example.sheared_prefereence_demo.MainActivity.userNameSP;
import static com.example.sheared_prefereence_demo.MainActivity.userPassSP;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FileHandling extends AppCompatActivity{
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_handaling);

        getSharedRef();

        Button btnClear = findViewById(R.id.button2);
        btnClear.setOnClickListener(view -> clearSharedRef());

    }
    private void clearSharedRef(){
        sharedPreferences=getSharedPreferences(savePref,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit().clear();
        editor.apply();
        editor.clear();
        Toast.makeText(this,"Shared Preference is deleted sucessfully",Toast.LENGTH_SHORT).show();
        getSharedRef();
    }

    public void getSharedRef(){
        TextView txtVwInfo = findViewById(R.id.txtVwInfo);
        sharedPreferences= getSharedPreferences(savePref,MODE_PRIVATE);
        String name =sharedPreferences.getString(userNameSP,"No User Name");
        String password = sharedPreferences.getString(userPassSP,"and password");
        txtVwInfo.setText(name+""+password);
    }
}
