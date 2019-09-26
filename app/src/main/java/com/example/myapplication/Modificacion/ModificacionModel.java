package com.example.myapplication.Modificacion;

import com.example.myapplication.Persona;

public class ModificacionModel {
    private Persona p;
    private int posicion;

    public int getPosicion() {
        return posicion;
    }

    public Persona getPersona() {
        return this.p;
    }

    public void setPersona(String nombre, String apellido) {
        this.p.setNombre(nombre);
        this.p.setApellido(apellido);
    }

    public ModificacionModel(String apellido, String nombre, int posicion){
        this.p = new Persona();
        this.p.setNombre(apellido);
        this.p.setApellido(nombre);

        this.posicion = posicion;
    }
}
