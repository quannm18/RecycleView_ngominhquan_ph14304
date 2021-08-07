package com.example.recycleview_ngominhquan_ph14304;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import static com.example.recycleview_ngominhquan_ph14304.StudentSQLite.ID;
import static com.example.recycleview_ngominhquan_ph14304.StudentSQLite.NAME;
import static com.example.recycleview_ngominhquan_ph14304.StudentSQLite.NUMBER;
import static com.example.recycleview_ngominhquan_ph14304.StudentSQLite.TABLE_NAME;

public class StudentDAO {
    private StudentSQLite studentSQLite;

    public StudentDAO(StudentSQLite studentSQLite) {
        this.studentSQLite = studentSQLite;
    }
    public long insertSTD(Student student){
        SQLiteDatabase sqLiteDatabase = studentSQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,student.getId());
        contentValues.put(NAME,student.getName());
        contentValues.put(NUMBER,student.getNumber());
        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return result;
    }
    public long updateSTD(Student student){
        SQLiteDatabase sqLiteDatabase = studentSQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,student.getId());
        contentValues.put(NAME,student.getName());
        contentValues.put(NUMBER,student.getNumber());
        long result = sqLiteDatabase.update(TABLE_NAME,contentValues,ID+"=?",new String[]{student.getId()});
        return result;
    }
    public long deleteSTD(Student student){
        SQLiteDatabase sqLiteDatabase = studentSQLite.getWritableDatabase();
        long result = sqLiteDatabase.delete(TABLE_NAME,ID+"=?",new String[]{student.getId()});
        return result;
    }
    public List<Student> getAllStudent(){
        SQLiteDatabase sqLiteDatabase = studentSQLite.getReadableDatabase();
        List<Student> studentList = new ArrayList<>();
        String SELECT_ALL = "SELECT * FROM "+TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                String id = cursor.getString(cursor.getColumnIndex(ID));
                String name = cursor.getString(cursor.getColumnIndex(NAME));
                int number = cursor.getInt(cursor.getColumnIndex(NUMBER));
                Student student = new Student(id,name,number);
                studentList.add(student);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return studentList;
    }
}
