package com.example.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    private Repositorio repository;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Repositorio(application);
    }
    public List<Producto> getProducts(){
        return repository.getProducts();
    }

    public Usuario autenticar(String username, String password){
        return repository.autenticar(username, password);
    }

    public Producto getProduct(String uuid){
        return repository.getProduct(uuid);
    }

    public void addProduct(Producto product) {repository.addProduct(product);}

    public void updateProduct(Producto product){
        repository.updateProduct(product);
    }

    public void deleteProduct(Producto product){
        repository.deleteProduct(product);
    }

    public ProductoCategoria getCategoryWithProducts(int id) {return repository.getCategoryWithProducts(id);}
}
