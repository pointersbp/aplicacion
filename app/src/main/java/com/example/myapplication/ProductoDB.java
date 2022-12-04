package com.example.myapplication;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {producto.class, Categoria.class}, version = 1)
public abstract class ProductoDB extends RoomDatabase {

    public abstract Productodao Dao ();
    public abstract Categoriadao CDao();
}
