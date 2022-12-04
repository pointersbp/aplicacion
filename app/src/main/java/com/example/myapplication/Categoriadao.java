package com.example.myapplication;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Categoriadao {

    @Query("SELECT * FROM Categoria")
    List<Categoria> getCategorias();

    @Query("SELECT * FROM Categoria WHERE ID = :ID")
    Categoria getCategoria(int ID);

    @Insert
    void insertCategoria(Categoria aux);

    @Delete
    void deleteProduct(Categoria aux);

    @Update
    void updateProduct(Categoria aux);

    @Transaction
    @Query("SELECT * FROM Categoria WHERE ID = :ID")
    ProductoCategoria getCategoryWithProducts(int ID);
}
