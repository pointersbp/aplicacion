package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Producto")
public class Producto {
    @PrimaryKey
    @NonNull
    private String uuid;
    private String nombre;
    private String descripcion;
    private float precio;
    private int id;


    private int CategoriaID;
    public String getNombre() {
        return nombre;
    }

    public Producto(String uuid, String nombre, String descripcion, float precio){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.uuid = uuid;
        this.CategoriaID = CategoriaID;
    }
    public Producto(int id) {
        this.id = id;
    }

    public int getCategoriaID() {
        return CategoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        CategoriaID = categoriaID;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @NonNull
    public String getUuid() {
        return uuid;
    }

    public void setUuid(@NonNull String uuid) {
        this.uuid = uuid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




}
