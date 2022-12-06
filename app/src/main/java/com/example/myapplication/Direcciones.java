package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class Direcciones {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @ColumnInfo(name = "userID")
    private int userID;

    @ColumnInfo(name = "direccion")
    private String direccion;

    public Direcciones(int userID, String direccion) {
        this.userID = userID;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDirection() {
        return direccion;
    }

    public void setDirection(String direction) {
        this.direccion = direccion;
    }
}
