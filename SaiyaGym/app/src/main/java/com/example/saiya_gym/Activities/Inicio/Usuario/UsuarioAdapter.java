package com.example.saiya_gym.Activities.Inicio.Usuario;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saiya_gym.R;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.ViewHolder> {


    public List<Usuario>cursoList;
    public UsuarioAdapter(List<Usuario> cursoList){
        this.cursoList=cursoList;
    }

    /*@NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_curso,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }*/

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdapter.ViewHolder holder, int position) {
        holder.nombre.setText(cursoList.get(position).getUsuario());
        holder.contraseña.setText(cursoList.get(position).getContraseña());
        holder.usuario.setText(cursoList.get(position).getUsuario());
    }

    @Override
    public int getItemCount() {
        return cursoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nombre,usuario,contraseña;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            /*nombre=(TextView) itemView.findViewById(R.id.codigo);
            usuario=(TextView) itemView.findViewById(R.id.carrera);
            contraseña=(TextView) itemView.findViewById(R.id.curso);*/

        }
    }
}
