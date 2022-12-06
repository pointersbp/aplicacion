package com.example.myapplication;

import androidx.room.Embedded;
import androidx.room.Relation;
import java.util.List;

public class ProductoCategoria {
    @Embedded public Categoria category;
    @Relation(
            parentColumn = "ID",
            entityColumn = "CategoriaID"
    )
    public List<Producto> Productos;
}
