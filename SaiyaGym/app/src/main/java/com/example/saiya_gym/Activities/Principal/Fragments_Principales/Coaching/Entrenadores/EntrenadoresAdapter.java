package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Entrenadores;

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

public class EntrenadoresAdapter extends RecyclerView.Adapter<EntrenadoresAdapter.ViewHolder> implements  View.OnClickListener{



    private List<Entrenadores> entrenadoresList;
    private LayoutInflater inflater;
    private View.OnClickListener listener;

    public EntrenadoresAdapter(Context context, List<Entrenadores> entrenadoresList){
        this.entrenadoresList = entrenadoresList;
        this.inflater = LayoutInflater.from(context);

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_entrenadores,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EntrenadoresAdapter.ViewHolder holder, int position) {

        String titulo =entrenadoresList.get(position).getNombre();
        String contenido = entrenadoresList.get(position).getInformacion();
        int imagen =entrenadoresList.get(position).getImagen();


        holder.titulo.setText(titulo);
        holder.contenido.setText(contenido);
        holder.imagen.setImageResource(imagen);

    }

    @Override
    public int getItemCount() {
        return entrenadoresList.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }


    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titulo,contenido;
        private ImageView imagen;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo=itemView.findViewById(R.id.tituloEntrenadores);
            contenido = itemView.findViewById(R.id.contenidoEntrenadores);
            imagen = itemView.findViewById(R.id.imagenEntrenadores);

        }
    }
}
