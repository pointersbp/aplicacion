package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    RecyclerView recyclerView;
    public static ArrayList<Producto> articulo = new ArrayList<Producto>();
    public static adapter layoutAdapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        for(int i=0; i < 5; i++){
            Producto aux = new Producto("Producto " + i,"Producto " + i, "Descripcion del producto " + i, i,i * 10);
            articulo.add(aux);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView((binding.getRoot()));

        recyclerView = binding.recycler;
        layoutAdapter = new adapter(this, articulo);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(layoutAdapter);
    }
}