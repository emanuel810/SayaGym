package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Musculos;

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

public class MusculosAdapter extends RecyclerView.Adapter<MusculosAdapter.ViewHolder> implements  View.OnClickListener{


    private List<Musculos> musculosList;
    private LayoutInflater inflater;
    private View.OnClickListener listener;


    public MusculosAdapter(Context context, List<Musculos> musculosList){
        this.musculosList = musculosList;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_musculos,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }


    @Override
    public void onBindViewHolder(@NonNull MusculosAdapter.ViewHolder holder, int position) {
        String titulo =musculosList.get(position).getTitulo();
        int imagen =musculosList.get(position).getImagen();

        holder.titulo.setText(titulo);
        holder.imagen.setImageResource(imagen);
    }

    @Override
    public int getItemCount() {
        return musculosList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titulo;
        private ImageView imagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tituloMusculo);
            imagen = itemView.findViewById(R.id.imagenMusculo);
        }
    }
}
