package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.myapplication.Direcciones;

@Dao
public interface Direcciondao {
    @Insert
    void insertDirection(Direcciones aux);

    @Delete
    void deleteDirection(Direcciones aux);

    @Update
    void updateDirection(Direcciones aux);
}
