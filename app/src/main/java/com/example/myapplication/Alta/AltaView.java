package com.example.myapplication.Alta;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

public class AltaView {
    private AltaModel model;
    private Button btnOk;
    private Alta altaActivity;
    private EditText nombreTxt;
    private EditText apellidoTxt;

    public AltaView(AltaModel model, View.OnClickListener listener, Alta altaActivity){
        this.model = model;
        this.altaActivity = altaActivity;

        this.btnOk = this.altaActivity.findViewById(R.id.btnAgregar);
        this.btnOk.setOnClickListener(listener);

        this.nombreTxt = this.altaActivity.findViewById(R.id.nuevoNombre);

        this.apellidoTxt = this.altaActivity.findViewById(R.id.nuevoApellido);
    }

    public Alta getAltaActivity() {
        return altaActivity;
    }

    public EditText getNombreTxt() {
        return nombreTxt;
    }

    public EditText getApellidoTxt() {
        return apellidoTxt;
    }
}
