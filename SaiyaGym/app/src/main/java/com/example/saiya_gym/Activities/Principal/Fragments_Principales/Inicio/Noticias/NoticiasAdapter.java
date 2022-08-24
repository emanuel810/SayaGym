package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Inicio.Noticias;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.saiya_gym.R;

import java.util.List;

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.ViewHolder> implements View.OnClickListener {

    private List<Noticias> noticiasList;
    private LayoutInflater inflater;
    private View.OnClickListener listener;


    public NoticiasAdapter(Context context, List<Noticias> noticiasList ) {
        this.noticiasList = noticiasList;
        this.inflater = LayoutInflater.from(context);
    }

    public int getItemCount(){return noticiasList.size();}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = inflater.inflate(R.layout.lista_noticias,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        String nombre = noticiasList.get(position).getTitulo();
        String contenido = noticiasList.get(position).getContenido();
        int imagen = noticiasList.get(position).getImagenId();

        holder.titulo.setText(nombre);
        holder.contenido.setText(contenido);
        holder.imagen.setImageResource(imagen);

    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagen;
        private TextView titulo,contenido;

         public ViewHolder(View itemView){
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen_noticia);
            titulo = itemView.findViewById(R.id.titulo_noticia);
            contenido = itemView.findViewById(R.id.contenido_noticia);
        }
    }
}
