package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.Usuario;

@Dao
public interface Usuariodao {
    @Query("SELECT * FROM Usuario WHERE userName like :username AND password LIKE :password")
    Usuario authenticate(String username, String password);

    @Insert
    void insertUser(Usuario aux);

    @Delete
    void deleteUser(Usuario aux);

    @Update
    void updatetUser(Usuario aux);


    @Query("SELECT * FROM Usuario WHERE userName LIKE :username")
    Usuario UsuarioProducto (String username);

    @Query("SELECT * FROM Usuario WHERE email LIKE :email")
    Usuario UsuarioEmail (String username);

    @Query("SELECT * FROM Usuario WHERE id = :id")
    Usuario getUserWithBuys(int id);
}
