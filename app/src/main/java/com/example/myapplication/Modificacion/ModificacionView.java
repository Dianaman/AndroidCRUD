package com.example.myapplication.Modificacion;

import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

public class ModificacionView {
    public ModificacionController controller;
    public ModificacionModel model;
    public Modificacion activity;

    public Button btnOk;
    private EditText nombreTxt;
    private EditText apellidoTxt;

    public String getApellidoTxt() {
        return this.apellidoTxt.getText() + "";
    }

    public String getNombreTxt() {
        return this.nombreTxt.getText() + "";
    }

    public ModificacionView(ModificacionModel model, ModificarListener listener, Modificacion activity){
        this.model = model;
        this.activity = activity;

        btnOk = (Button) activity.findViewById(R.id.btnAgregar);
        btnOk.setOnClickListener(listener);

        this.nombreTxt = (EditText) activity.findViewById(R.id.nuevoNombre);
        this.apellidoTxt = (EditText) activity.findViewById(R.id.nuevoApellido);

        this.nombreTxt.setText(this.model.getPersona().getNombre());
        this.apellidoTxt.setText(this.model.getPersona().getApellido());
    }
}
