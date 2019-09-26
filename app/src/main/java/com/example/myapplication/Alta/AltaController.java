package com.example.myapplication.Alta;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

public class AltaController {
    private AltaModel model;
    private AltaView view;

    public AltaController(AltaModel model){
        this.model = model;
    }

    public void setView(AltaView view){
        this.view = view;
    }

    public void agregarPersona(){
        this.model.p.setApellido(this.view.getApellidoTxt().getText() + "");
        this.model.p.setNombre(this.view.getNombreTxt().getText() + "");

        Log.d("Nueva persona", this.model.p.getApellido() + ", " + this.model.p.getNombre());

        // me comunico con el atributo estatico del main activity


        Intent i = new Intent();
        i.putExtra("nombre", this.model.p.getNombre());
        i.putExtra("apellido", this.model.p.getApellido());

        this.view.getAltaActivity().setResult(Activity.RESULT_OK, i);
        this.view.getAltaActivity().finish();
    }
}
