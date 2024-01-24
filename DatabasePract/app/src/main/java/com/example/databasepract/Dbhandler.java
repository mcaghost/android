package com.example.databasepract;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Dbhandler extends SQLiteOpenHelper {
    private static final String dbname="my_db";
    public static final int version = 1;
    public Dbhandler(Context context){
        super(context,dbname,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "create table students(_id INTEGER PRIMARY KEY AUTOINCREMENT,"+"name TEXT,rollno TEXT)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS students");
    }

    public void addStudent(String name, String rollNo){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("rollno",rollNo);
        db.insert("students",null,values);
        db.close();
    }

    public ArrayList<StudentModel> readStudent(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT name, rollno form students",null);

        ArrayList<StudentModel> studentModelArrayList=new ArrayList<StudentModel>();

        if(cursor.moveToFirst()){
            do{
                studentModelArrayList.add(new StudentModel(cursor.getString(0),cursor.getString(1)));
            }while (cursor.moveToNext());
        }

        cursor.close();
        return studentModelArrayList;
    }
}
