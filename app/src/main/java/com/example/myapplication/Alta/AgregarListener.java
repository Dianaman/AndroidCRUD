package com.example.myapplication.Alta;

import android.view.View;

public class AgregarListener implements View.OnClickListener {
    private AltaController controller;

    public AgregarListener(AltaController controller){
        this.controller = controller;
    }

    @Override
    public void onClick(View view) {
        this.controller.agregarPersona();
    }
}
