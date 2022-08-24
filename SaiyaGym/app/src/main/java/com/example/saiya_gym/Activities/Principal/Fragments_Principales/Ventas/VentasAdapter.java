package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Ventas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saiya_gym.R;

import java.util.List;

public class VentasAdapter extends RecyclerView.Adapter<VentasAdapter.ViewHolder> implements  View.OnClickListener{

    private List<Ventas> ventasList;
    private LayoutInflater inflater;
    private View.OnClickListener listener;

    public VentasAdapter(Context context, List<Ventas> ventasList){
        this.ventasList = ventasList;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_comidas,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);

    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String titulo = ventasList.get(position).getTitulo();
        String contenido = ventasList.get(position).getContenido();
        String precio = ventasList.get(position).getPrecio();
        int imagen = ventasList.get(position).getImagen();


        holder.titulo.setText(titulo);
        holder.contenido.setText(contenido);
        holder.precio.setText(precio);
        holder.imagen.setImageResource(imagen);


    }

    @Override
    public int getItemCount() {
        return ventasList.size();
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titulo,contenido,precio;
        private ImageView imagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tituloComida);
            imagen = itemView.findViewById(R.id.imagenComida);
            contenido = itemView.findViewById(R.id.contenidoComida);
            precio = itemView.findViewById(R.id.precioComida);

        }
    }
}
