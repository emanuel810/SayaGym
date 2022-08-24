package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Nutricion.Dieta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.saiya_gym.Activities.Inicio.Entrenadores.Entrenadores;
import com.example.saiya_gym.Activities.SQLite.BDdietas;
import com.example.saiya_gym.R;

public class DietaEntrenadorFragment extends Fragment {

    View view;
    Button lunes,martes,miercoles,jueves,viernes;

    public DietaEntrenadorFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DietaEntrenadorFragment newInstance(String param1, String param2) {
        DietaEntrenadorFragment fragment = new DietaEntrenadorFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_dieta_entrenador, container, false);




        final BDdietas bDdietas = new BDdietas(getContext());

        String usuairo=(getActivity().getIntent().getExtras().getString("llave"));


        Entrenadores entrenadores = new Entrenadores();

        bDdietas.buscarEntrenadoresDieta(entrenadores,usuairo);



        String lunesD = (entrenadores.getLunesD());
        String martesD =(entrenadores.getMartesD());
        String miercolesD =(entrenadores.getMiercolesD());
        String juevesD =(entrenadores.getJuevesD());
        String viernesD =(entrenadores.getViernesD());




        lunes = view.findViewById(R.id.btnLunes);
        martes = view.findViewById(R.id.btnMartes);
        miercoles = view.findViewById(R.id.btnMiercoles);
        jueves = view.findViewById(R.id.btnJueves);
        viernes = view.findViewById(R.id.btnViernes);


        lunes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.listadoDeDietasContenedor, SemanaDietaFragment.newInstance("Lunes",lunesD));
                transaction.commit();
                lunes.setVisibility(View.GONE);
                martes.setVisibility(View.GONE);
                miercoles.setVisibility(View.GONE);
                jueves.setVisibility(View.GONE);
                viernes.setVisibility(View.GONE);
            }
        });

        martes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.listadoDeDietasContenedor, SemanaDietaFragment.newInstance("Martes",martesD));
                transaction.commit();
                lunes.setVisibility(View.GONE);
                martes.setVisibility(View.GONE);
                miercoles.setVisibility(View.GONE);
                jueves.setVisibility(View.GONE);
                viernes.setVisibility(View.GONE);
            }
        });


        miercoles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.listadoDeDietasContenedor, SemanaDietaFragment.newInstance("Miercoles",miercolesD));
                transaction.commit();
                lunes.setVisibility(View.GONE);
                martes.setVisibility(View.GONE);
                miercoles.setVisibility(View.GONE);
                jueves.setVisibility(View.GONE);
                viernes.setVisibility(View.GONE);
            }
        });


        jueves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.listadoDeDietasContenedor, SemanaDietaFragment.newInstance("Jueves",juevesD));
                transaction.commit();
                lunes.setVisibility(View.GONE);
                martes.setVisibility(View.GONE);
                miercoles.setVisibility(View.GONE);
                jueves.setVisibility(View.GONE);
                viernes.setVisibility(View.GONE);
            }
        });


        viernes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.listadoDeDietasContenedor, SemanaDietaFragment.newInstance("Viernes",viernesD));
                transaction.commit();
                lunes.setVisibility(View.GONE);
                martes.setVisibility(View.GONE);
                miercoles.setVisibility(View.GONE);
                jueves.setVisibility(View.GONE);
                viernes.setVisibility(View.GONE);
            }
        });








        return view;
    }
}