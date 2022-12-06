package com.example.myapplication;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UsuarioRegistro {
    @Embedded Usuario usuario;
    @Relation(
            parentColumn = "id",
            entityColumn = "userID"
    )
    public List<Registro> Compras;
}
