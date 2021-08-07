package com.example.recycleview_ngominhquan_ph14304;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

//TEST

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvMain;
    private List<Student> studentList;
    private StudentAdapter studentAdapter;
    private LinearLayoutManager linearLayoutManager;
    private StudentSQLite studentSQLite;
    private StudentDAO studentDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvMain = findViewById(R.id.rvMain);
        studentSQLite = new StudentSQLite(this);
        studentDAO = new StudentDAO(studentSQLite);
        addStd();
        studentList  = studentDAO.getAllStudent();
        studentAdapter = new StudentAdapter(this,studentList);
        linearLayoutManager = new LinearLayoutManager(this);
        rcvMain.setAdapter(studentAdapter);
        rcvMain.setLayoutManager(linearLayoutManager);

    }
    void addStd(){
        studentDAO.insertSTD(new Student("PH14304","Ngo Minh Quan",1));
        studentDAO.insertSTD(new Student("PH14305","Nguyen Van Tuan",2));
        studentDAO.insertSTD(new Student("PH14306","Tran Thi Thuy",3));
        studentDAO.insertSTD(new Student("PH14307","Hoang Thi Xuan",4));
        studentDAO.insertSTD(new Student("PH14308","Nguyen Van Tuan",5));
        studentDAO.insertSTD(new Student("PH14309","Hoang Quoc Tuan",6));
        studentDAO.insertSTD(new Student("PH14310","Dinh Thi Hien",7));
        studentDAO.insertSTD(new Student("PH14311","Vang Thi Sang",8));
        studentDAO.insertSTD(new Student("PH14312","To Dac Lac",9));
        studentDAO.insertSTD(new Student("PH14313","Ta Van Tan",10));
        studentDAO.insertSTD(new Student("PH14314","Ta Van Nam",11));
        studentDAO.insertSTD(new Student("PH14315","Hoang A Be Kia",12));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        studentList = new ArrayList<>();
        studentList = studentDAO.getAllStudent();
        studentAdapter = new StudentAdapter(this,studentList);
        linearLayoutManager = new LinearLayoutManager(this);
        rcvMain.setAdapter(studentAdapter);
        rcvMain.setLayoutManager(linearLayoutManager);
    }
}
