package com.example.multy_layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.NonUiContext;
import androidx.annotation.Nullable;

public class myadapter extends ArrayAdapter<String>{

    private final String[] arr;

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.mylayout,parent,false);
        TextView t=convertView.findViewById(R.id.textview);
        t.setText(getItem(position));
        return convertView;
    }

    public String getItem(int posssition){
        return arr[posssition];
    }

    public myadapter(@NonNull Context context,int resource,@NonNull String[] arr){
        super(context,resource,arr);
        this.arr=arr;
    }



}
