package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Alta.Alta;
import com.example.myapplication.Modificacion.Modificacion;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyAdapter myAdapter;
    List<Persona> personas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Personas");

        this.personas = new ArrayList<Persona>();

        RecyclerView rv = (RecyclerView) this.findViewById(R.id.rvPersonas);
        this.myAdapter = new MyAdapter(this.personas, this);
        rv.setAdapter(this.myAdapter);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mas){
            Intent i = new Intent(this, Alta.class);
            startActivityForResult(i, 2);
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.myAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Bundle extras = data.getExtras();

            String nombre = extras.getString("nombre");
            String apellido = extras.getString("apellido");
            Persona nuevaPersona = new Persona(nombre, apellido);

            if(requestCode == 1){
                Log.d("result posicion", extras.getString("posicion"));
                int posicion = Integer.parseInt(extras.getString("posicion"));

                this.personas.set(posicion, nuevaPersona);
            }
            else if(requestCode == 2){
                this.personas.add(nuevaPersona);
            }
        }
    }

    public void onHolderItemClick(int posicion){
        Persona p = this.personas.get(posicion);
        String nombre = p.getNombre();
        String apellido = p.getApellido();

        Log.d("itemCLick posicion", posicion + "");
        Log.d("itemCLick nombre", nombre);
        Log.d("itemCLick apellido", apellido);

        Intent i = new Intent(this, Modificacion.class);
        i.putExtra("nombre", nombre);
        i.putExtra("apellido", apellido);
        i.putExtra("posicion", posicion + "");

        startActivityForResult(i, 1);
    }
}
