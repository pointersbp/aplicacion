package com.example.myapplication;
import android.annotation.SuppressLint;
import android.app.Application;
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

    public Repositorio(Application application){
        ProductoDB database = ProductoDB.getInstance(application);

        productDao = database.Dao();
        categoriadao = database.CDao();
        usuariodao = database.UDao();
        registrodao = database.RDao();
        direcciondao = database.DrDao();
    }

    public static Repositorio get(Application application){
        if(repository == null){
            repository = new Repositorio(application);
        }
        return repository;
    }

    public Usuario autenticar(String username, String password){
        return usuariodao.authenticate(username, password);
    }

    public Usuario UsuarioProducto (String username){
        return usuariodao.UsuarioProducto(username);
    }
   /*
    public Usuario UsuarioEmail (String email){
        return usuariodao.UsuarioEmail(email);
    }
*/
    public void addUser(Usuario user){
        usuariodao.insertUser(user);
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
