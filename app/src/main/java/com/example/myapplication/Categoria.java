package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Categoria")
public class Categoria {
    @NonNull
    @PrimaryKey
    private String Nombre;
    private int ID;
    private String Descripcion;

    public Categoria(String Nombre, int ID) {
        this.Nombre = Nombre;
        this.ID = ID;
    }

    public Categoria(String descripcion) {
        Descripcion = descripcion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
