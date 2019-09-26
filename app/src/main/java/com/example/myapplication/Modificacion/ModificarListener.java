package com.example.myapplication.Modificacion;

import android.view.View;

public class ModificarListener implements View.OnClickListener {
    public ModificacionController controller;

    public ModificarListener(ModificacionController controller){
        this.controller = controller;
    }

    @Override
    public void onClick(View view) {
        this.controller.modificarPersona();
    }
}
