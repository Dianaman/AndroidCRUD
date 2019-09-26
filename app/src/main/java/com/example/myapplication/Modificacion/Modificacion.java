package com.example.myapplication.Modificacion;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Modificacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificacion);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Modificación");
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        Bundle extras = i.getExtras();
        String nombre = extras.getString("nombre");
        String apellido = extras.getString("apellido");

        Log.d("createMod nombre", nombre);
        Log.d("createMod apellido", apellido);
        Log.d("createMod posicion", extras.getString("posicion"));

        int posicion = Integer.parseInt(extras.getString("posicion"));

        ModificacionModel model = new ModificacionModel(apellido, nombre, posicion);
        ModificacionController controller = new ModificacionController(model);
        ModificarListener listener = new ModificarListener(controller);
        ModificacionView view = new ModificacionView(model, listener, this);
        controller.setView(view);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(android.R.id.home == item.getItemId()){
            this.setResult(RESULT_CANCELED);
            super.finish();
        }

        return true;
    }
}
