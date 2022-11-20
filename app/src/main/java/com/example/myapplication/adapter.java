package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.ItemViewHolder> {
      private final Context context;
      private final ArrayList<producto> articulos;

      public adapter(Context context, ArrayList<producto> courseModelArraylist){
        this.context = context;
        this.articulos = courseModelArraylist;
      }
  @NonNull
  @Override
  public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.objeto_layout , parent, false);
        return new ItemViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
    producto articulo = articulos.get(position);

    holder.articulo.setText(articulo.getArticulo());
    holder.descripcion.setText(articulo.getDescripcion());
    holder.precio.setText(articulo.getPrecio().toString());

    holder.borrar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        articulos.remove(position);
        MainActivity.layoutAdapter.notifyDataSetChanged();
      }
    });
    holder.compartir.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

      }
    });
  }

  @Override
  public int getItemCount() {
    return articulos.size();
  }

  public class ItemViewHolder extends RecyclerView.ViewHolder {

    TextView articulo, descripcion, precio;
    Button borrar, compartir;

    public ItemViewHolder(@NonNull View itemView){
      super(itemView);

      articulo = itemView.findViewById(R.id.articuloName);
      descripcion = itemView.findViewById(R.id.articuloDescription);
      precio = itemView.findViewById(R.id.articuloPrice);
      borrar = itemView.findViewById(R.id.deleteBtn);
      compartir = itemView.findViewById(R.id.shareBtn);}

  }
}
