package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Productodao {

    @Query("SELECT * FROM producto")
    List<producto> getProducts();

    @Query("SELECT * FROM producto WHERE uuid Like :productID")
    producto getProduct(String productID);

    @Insert
    void insertProduct(producto aux);

    @Delete
    void deleteProduct(producto aux);

    @Update
    void updateProduct(producto aux);
}
