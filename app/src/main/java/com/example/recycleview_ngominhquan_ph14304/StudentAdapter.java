package com.example.recycleview_ngominhquan_ph14304;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentHolder> {
    private Context context;
    private List<Student> studentList;
    AlertDialog alertDialog;
    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        return new StudentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
        final Student student = studentList.get(position);
        holder.tvIDR.setText(student.getId());
        holder.tvNameR.setText(student.getName());
        holder.tvNumberR.setText(String.valueOf(student.getNumber()));

        holder.btnDelR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentSQLite studentSQLite = new StudentSQLite(context);
                StudentDAO studentDAO = new StudentDAO(studentSQLite);
                studentDAO.deleteSTD(student);
                studentList.remove(position);
                notifyDataSetChanged();
                notifyItemRemoved(position);
            }
        });

        holder.btnUpdateR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtIdDL;
                EditText edtNameDL;
                EditText edtNumberDL;
                Button btnOK;
                Button btnCancel;

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View alert = LayoutInflater.from(context).inflate(R.layout.mydialog,null);
                builder.setView(alert);

                edtIdDL = (EditText) alert.findViewById(R.id.edtIdDL);
                edtNameDL = (EditText) alert.findViewById(R.id.edtNameDL);
                edtNumberDL = (EditText) alert.findViewById(R.id.edtNumberDL);
                btnOK = (Button) alert.findViewById(R.id.btnOK);
                btnCancel = (Button) alert.findViewById(R.id.btnCancel);

                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        StudentSQLite studentSQLite = new StudentSQLite(context);
                        StudentDAO studentDAO = new StudentDAO(studentSQLite);

                        student.setId(edtIdDL.getText().toString());
                        student.setName(edtNameDL.getText().toString());
                        student.setNumber(Integer.parseInt(edtNumberDL.getText().toString()));

                        studentDAO.updateSTD(student);
                        notifyItemChanged(position);
                        edtIdDL.setText("");
                        edtNameDL.setText("");
                        edtNumberDL.setText("");
                        alertDialog.dismiss();
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Cancel clicked!", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                });
                builder.create();
                alertDialog = builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
}
