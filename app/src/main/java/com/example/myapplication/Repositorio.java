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

    private Repositorio(Context context){
        Context appContext = context.getApplicationContext();
        ProductoDB database = Room.databaseBuilder(appContext, ProductoDB.class, "Temas")
                .allowMainThreadQueries().build();

        productDao = database.Dao();
        categoriadao = database.CDao();
    }

    public static Repositorio get(Context context){
        if(repository == null){
            repository = new Repositorio(context);
        }
        return repository;
    }

    public List<producto> getProducts(){
        return productDao.getProducts();
    }

    public producto getProduct(String uuid){
        return productDao.getProduct(uuid);
    }

    public void addProduct(producto product){
        productDao.insertProduct(product);
    }

    public void updateProduct(producto product){
        productDao.updateProduct(product);
    }

    public void deleteProduct(producto product){
        productDao.deleteProduct(product);
    }

    public ProductoCategoria getCategoryWithProducts(int id) {return categoriadao.getCategoryWithProducts(id);};
}
