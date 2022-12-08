package com.example.myapplication;
import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@androidx.room.Database(entities = {Producto.class, Categoria.class, Usuario.class, Registro.class, Direcciones.class}, version = 1)
public abstract class ProductoDB extends RoomDatabase {

    private static String NAME = "ECommerce";
    private static volatile ProductoDB INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static ProductoDB getInstance(Context context){
        if(INSTANCE == null){
            synchronized (ProductoDB.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ProductoDB.class, NAME)
                        .allowMainThreadQueries()
                        .build();
            }
        }

        return INSTANCE;
    }

    public abstract Productodao Dao ();
    public abstract Categoriadao CDao();
    public abstract Usuariodao UDao();
    public abstract Registrodao RDao();
    public abstract Direcciondao DrDao();
}
