package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<Persona> personas;
    private MainActivity activity;

    public MyAdapter(List<Persona> personas, MainActivity activity){
        this.personas = personas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v, this.activity);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Persona p = this.personas.get(position);
        holder.tvApellido.setText(p.getApellido());
        holder.tvNombre.setText(p.getNombre());
        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return this.personas.size();
    }
}
