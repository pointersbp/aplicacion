package com.example.myapplication;
import android.annotation.SuppressLint;
import android.content.Context;
import androidx.room.Room;

import java.util.List;

public class Repositorio {
    @SuppressLint("StaticFieldLeak")
    private static Repositorio repository;

    private Productodao productDao;
    private Categoriadao categoriadao;
    private Usuariodao usuariodao;
    private Registrodao registrodao;
    private Direcciondao direcciondao;

    private Repositorio(Context context){
        Context appContext = context.getApplicationContext();
        ProductoDB database = Room.databaseBuilder(appContext, ProductoDB.class, "Temas")
                .allowMainThreadQueries().build();

        productDao = database.Dao();
        categoriadao = database.CDao();
        usuariodao = database.UDao();
        registrodao = database.RDao();
        direcciondao = database.DrDao();
    }

    public static Repositorio get(Context context){
        if(repository == null){
            repository = new Repositorio(context);
        }
        return repository;
    }

    public List<Producto> getProducts(){
        return productDao.getProducts();
    }

    public Producto getProduct(String uuid){
        return productDao.getProduct(uuid);
    }

    public void addProduct(Producto product){
        productDao.insertProduct(product);
    }

    public void updateProduct(Producto product){
        productDao.updateProduct(product);
    }

    public void deleteProduct(Producto product){
        productDao.deleteProduct(product);
    }

    public ProductoCategoria getCategoryWithProducts(int id) {return categoriadao.getCategoryWithProducts(id);}
}
