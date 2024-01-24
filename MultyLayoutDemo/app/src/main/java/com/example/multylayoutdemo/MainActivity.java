package com.example.multylayoutdemo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.multylayoutdemo.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_name,et_email,et_dob;

    RadioGroup rg_gender;

    RadioButton radioGenderButton;

    Button submit_bt;

    CheckBox ck1,ck2,ck3;

    String nameStr, emailStr,dobStr,genderStr,techStr = " ";

    private int mDay,mMonth,mYear;





    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        et_name=findViewById(R.id.et_name);
        et_email=findViewById(R.id.et_email);
        et_dob=findViewById(R.id.et_dob);
        rg_gender=findViewById(R.id.rg_gender);
        submit_bt= findViewById(R.id.submit_btn);
        ck1=findViewById(R.id.ck1);
        ck2=findViewById(R.id.ck2);
        ck3=findViewById(R.id.ck3);

        ck1.setOnClickListener(this);
        ck2.setOnClickListener(this);
        ck3.setOnClickListener(this);
        submit_bt.setOnClickListener(this);
        et_dob.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            Toast.makeText(getApplicationContext(),"Back",Toast.LENGTH_SHORT).show();
            finish();
        }

        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(),"Setting "+"Selected",Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id==R.id.submit_btn){
            nameStr = et_name.getText().toString();
            emailStr= et_email.getText().toString();
            dobStr = et_dob.getText().toString();
            int selectedId = rg_gender.getCheckedRadioButtonId();
            radioGenderButton=findViewById(selectedId);
            genderStr=radioGenderButton.getText().toString();
            Toast.makeText(this,"Name: "+nameStr+" Email: "+emailStr+"Gender: "+genderStr+"Tech: "+techStr+"DOB:"+dobStr,Toast.LENGTH_LONG);

            Intent i = new Intent(MainActivity.this,OurResult.class);

            i.putExtra("name",nameStr);
            i.putExtra("email",emailStr);
            i.putExtra("gender",genderStr);
            i.putExtra("tech",techStr);
            i.putExtra("dob",dobStr);

            startActivity(i);
        } else if (id == R.id.ck1) {
            if (ck1.isChecked()){
                techStr+="PHP";
            }
            else {
                techStr=techStr.replace("PHP"," ");
            }
        } else if (id == R.id.ck2) {
            if (ck2.isChecked()){
                techStr+="Android";
            }
            else {
                techStr=techStr.replace("Android"," ");
            }
        } else if (id == R.id.ck3) {
            if (ck3.isChecked()){
                techStr+="IOS";
            }
            else {
                techStr=techStr.replace("IOS"," ");
            }
        } else if (id == R.id.et_dob) {
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

            int mYear = calendar.get(Calendar.YEAR);
            int mMonth= calendar.get(Calendar.MONTH);
            int mDay = calendar.get(Calendar.DAY_OF_WEEK);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,(datePicker, i, i1, i2) -> et_dob.setText(i2+"-"+(i1+1)+"-"+i),mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }
}