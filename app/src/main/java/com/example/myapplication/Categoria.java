package com.example.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Categoria")
public class Categoria {
    @PrimaryKey
    private String Nombre;
    private int ID;

    public Categoria(String nombre, int ID) {
        Nombre = nombre;
        this.ID = ID;
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
}
