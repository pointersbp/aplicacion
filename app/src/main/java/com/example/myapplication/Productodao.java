package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Productodao {

    @Query("SELECT * FROM Producto")
    List<Producto> getProducts();

    @Query("SELECT * FROM Producto WHERE uuid Like :productID")
    Producto getProduct(String productID);

    @Insert
    void insertProduct(Producto aux);

    @Delete
    void deleteProduct(Producto aux);

    @Update
    void updateProduct(Producto aux);
}
