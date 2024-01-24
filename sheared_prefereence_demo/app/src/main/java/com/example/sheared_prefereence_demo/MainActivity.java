package com.example.sheared_prefereence_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String savePref = "mypref";

    public static final String userNameSP = "UsrNm";
    public static final String userPassSP = "UsrPass";

    SharedPreferences sharedPreferences;
    private EditText txtUsrNm,txtPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsrNm=findViewById(R.id.editTextText);
        txtPass=findViewById(R.id.editTextText2);


        Button submitbtn = findViewById(R.id.button);

        submitbtn.setOnClickListener(v ->{
            CheckBox checkBox = findViewById(R.id.checkBox);

            if(checkBox.isChecked()){
                saveShearedPref(v);
            }

            Intent intent = new Intent(MainActivity.this,FileHandling.class);
            MainActivity.this.startActivity(intent);
        });
    }
    public void saveShearedPref(View view){
        String nm = txtUsrNm.getText().toString();
        String pass=txtPass.getText().toString();

        sharedPreferences=getSharedPreferences(savePref,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(userNameSP,nm);
        editor.putString(userPassSP,pass);
        editor.apply();

    }


    @Override

    protected void onResume(){
        super.onResume();
        sharedPreferences = getSharedPreferences(savePref,MODE_PRIVATE);
        String preString = sharedPreferences.getString(userPassSP,"");
        String prefString1 = sharedPreferences.getString(userPassSP,"");

        txtUsrNm.setText(preString);
        txtPass.setText(prefString1);

    }

    protected void onDestroy(){
        super.onDestroy();
        sharedPreferences=getSharedPreferences(savePref,MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.clear();
        editor.apply();
        finish();
    }

}