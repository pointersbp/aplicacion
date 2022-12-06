package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Producto")
public class Producto {
    @PrimaryKey
    @NonNull
    private String uuid;
    private String articulo;
    private  String descripcion;
    private Integer precio;


    private int CategoriaID;
    public String getArticulo() {
        return articulo;
    }

    public Producto(String uuid, String articulo, String descripcion, Integer precio){
        this.articulo = articulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.uuid = uuid;
        this.CategoriaID = CategoriaID;
    }

    public int getCategoriaID() {
        return CategoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        CategoriaID = categoriaID;
    }
    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @NonNull
    public String getUuid() {
        return uuid;
    }

    public void setUuid(@NonNull String uuid) {
        this.uuid = uuid;
    }




}
