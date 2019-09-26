package com.example.myapplication.Modificacion;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

public class ModificacionController {
    public ModificacionView view;
    public ModificacionModel model;

    public ModificacionController(ModificacionModel model){
        this.model = model;
    }

    public void setView(ModificacionView view){
        this.view = view;
    }

    public void modificarPersona(){
        this.model.setPersona(this.view.getNombreTxt(), this.view.getApellidoTxt());

        Intent i = new Intent();
        Log.d("posicion", this.model.getPosicion() + "");
        Log.d("nombre", this.model.getPersona().getNombre());
        Log.d("apellido", this.model.getPersona().getApellido());

        i.putExtra("posicion", this.model.getPosicion() + "");
        i.putExtra("nombre", this.model.getPersona().getNombre());
        i.putExtra("apellido", this.model.getPersona().getApellido());

        this.view.activity.setResult(Activity.RESULT_OK, i);
        this.view.activity.finish();
    }


}
