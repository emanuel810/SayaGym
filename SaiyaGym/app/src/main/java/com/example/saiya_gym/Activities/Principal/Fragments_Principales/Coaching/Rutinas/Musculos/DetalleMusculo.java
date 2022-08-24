package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Musculos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.EjerciciosFragment;
import com.example.saiya_gym.R;


public class DetalleMusculo extends Fragment {


    TextView titulo;
    ImageView imagen;
    Button btnEntendido;
    View view;
    public DetalleMusculo() {

    }



    public static DetalleMusculo newInstance() {
        DetalleMusculo fragment = new DetalleMusculo();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.detalle_musculo, container, false);

        titulo = view.findViewById(R.id.tituloMusculoDetalle);
        imagen = view.findViewById(R.id.imagenMusculoDetalle);
        btnEntendido = view.findViewById(R.id.btnEntendido);

        btnEntendido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.contenedorMusculos, EjerciciosFragment.newInstance());
                transaction.commit();
                btnEntendido.setVisibility(View.GONE);
            }
        });

        Bundle ObjetoMusculo = getArguments();
        Musculos musculos = null;


        if(ObjetoMusculo!=null){
            musculos = (Musculos) ObjetoMusculo.getSerializable("objeto");

            titulo.setText(musculos.getTitulo());
            imagen.setImageResource(musculos.getImagen());

        }



        return view;
    }
}