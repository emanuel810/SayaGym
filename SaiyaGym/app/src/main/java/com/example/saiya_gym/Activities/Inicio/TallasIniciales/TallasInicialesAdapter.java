package com.example.saiya_gym.Activities.Inicio.TallasIniciales;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saiya_gym.Activities.Inicio.Usuario.Usuario;
import com.example.saiya_gym.Activities.Inicio.Usuario.UsuarioAdapter;
import com.example.saiya_gym.R;

import java.util.List;

public class TallasInicialesAdapter extends RecyclerView.Adapter<TallasInicialesAdapter.ViewHolder>{


    public List<TallasI> tallasIList;


    public TallasInicialesAdapter( List<TallasI> tallasIList){
        this.tallasIList=tallasIList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_avances,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TallasInicialesAdapter.ViewHolder holder, int position) {
        holder.hombrosAv.setText(tallasIList.get(position).getHombros());
        holder.pechoAv.setText(tallasIList.get(position).getPecho());
        holder.espaldaAv.setText(tallasIList.get(position).getEspalda());
        holder.brazoAv.setText(tallasIList.get(position).getBrazos());
        holder.abdomenAv.setText(tallasIList.get(position).getAbdomen());
        holder.piernaAv.setText(tallasIList.get(position).getPierna());
    }

    @Override
    public int getItemCount() {
        return tallasIList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView hombrosAv,pechoAv,espaldaAv,brazoAv,abdomenAv,piernaAv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hombrosAv=(TextView) itemView.findViewById(R.id.hombroAvan);
            pechoAv=(TextView) itemView.findViewById(R.id.pechoAvan);
            espaldaAv=(TextView) itemView.findViewById(R.id.espaldaAvan);
            brazoAv=(TextView) itemView.findViewById(R.id.brazoAvan);
            abdomenAv=(TextView) itemView.findViewById(R.id.abdomenAvan);
            piernaAv=(TextView) itemView.findViewById(R.id.piernaAvan);
        }
    }
}
