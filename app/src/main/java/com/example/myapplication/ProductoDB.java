package com.example.myapplication;
import androidx.room.RoomDatabase;


@androidx.room.Database(entities = {Producto.class, Categoria.class, Usuario.class, Registro.class, Direcciones.class}, version = 1)
public abstract class ProductoDB extends RoomDatabase {

    public abstract Productodao Dao ();
    public abstract Categoriadao CDao();
    public abstract Usuariodao UDao();
    public abstract Registrodao RDao();
    public abstract Direcciondao DrDao();
}
