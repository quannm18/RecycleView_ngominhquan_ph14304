package com.example.recycleview_ngominhquan_ph14304;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentHolder extends RecyclerView.ViewHolder {
    public ImageView imvRow;
    public TextView tvIDR;
    public TextView tvNameR;
    public TextView tvNumberR;
    public Button btnDelR;
    public Button btnUpdateR;
    public Student student;
    public StudentHolder(@NonNull View itemView) {
        super(itemView);

        imvRow = (ImageView) itemView.findViewById(R.id.imvRow);
        tvIDR = (TextView) itemView.findViewById(R.id.tvIDR);
        tvNameR = (TextView) itemView.findViewById(R.id.tvNameR);
        tvNumberR = (TextView) itemView.findViewById(R.id.tvNumberR);
        btnDelR = (Button) itemView.findViewById(R.id.btnDelR);
        btnUpdateR = (Button) itemView.findViewById(R.id.btnUpdateR);

    }
}
