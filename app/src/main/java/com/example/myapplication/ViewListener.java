package com.example.myapplication;

import android.util.Log;
import android.view.View;

public class ViewListener implements View.OnClickListener {
    private MyViewHolder holder;
    private MainActivity ac;

    public ViewListener(MyViewHolder holder, MainActivity ac){
        this.holder = holder;
        this.ac = ac;
    }

    @Override
    public void onClick(View view) {
        this.ac.onHolderItemClick(this.holder.position);
    }
}
