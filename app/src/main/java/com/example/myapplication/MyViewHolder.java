package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public View v;

    public TextView tvApellido;
    public TextView tvNombre;
    public int position;

    public MyViewHolder(View v, MainActivity mainActivity){
        super(v);
        this.v = v;

        ViewListener vListener = new ViewListener(this, mainActivity);
        this.v.setOnClickListener(vListener);

        this.tvApellido = v.findViewById(R.id.apellido);
        this.tvNombre = v.findViewById(R.id.nombre);
    }
}
