package com.example.databasepract;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentRvAdapter extends RecyclerView.Adapter<StudentRVAdapter.ViewHolder>{
    ArrayList<StudentModel> studentModelArrayList;
    Context context;

    public StudentRvAdapter(ArrayList<StudentModel> studentModelArrayList, Context context){
        this.studentModelArrayList=studentModelArrayList;
        this.context=context;
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView studentNameTV, studntNumTv;
        public ViewHolder(@NonNull View itemView){
            super();
            studentNameTV=itemView.findViewById(R.id.txtName);
            studntNumTv=itemView.findViewById(R.id.txtRollNo);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.students_rv_item,parent,false);
        return new ViewHolder(view);
        );

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StudentModel modal = studentModelArrayList.get(position);
        holder.studentNameTV.setText(modal.getStudentName());
        holder.studntNumTv.setText(modal.getStudentName());
    }
    @Override
    public int getItemCount() {
        return studentModelArrayList.size();
    }

}
