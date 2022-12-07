package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.myapplication.Registro;

@Dao
public interface Registrodao {

    @Insert
    void insertBuy(Registro aux);
}
