package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Rutinas_Ejercicio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.saiya_gym.Activities.Inicio.Entrenadores.Entrenadores;
import com.example.saiya_gym.Activities.SQLite.BDentrenadores;
import com.example.saiya_gym.R;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Entrenadores.SemanaEjecicioFragment;


public class RutinasEntrenadorFragment extends Fragment {

    View view;
    Button lunes,martes,miercoles,jueves,viernes;

    public static RutinasEntrenadorFragment newInstance(String param1, String param2) {
        RutinasEntrenadorFragment fragment = new RutinasEntrenadorFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_rutinas_entrenador, container, false);

        lunes = view.findViewById(R.id.btnLunes);
        martes = view.findViewById(R.id.btnMartes);
        miercoles = view.findViewById(R.id.btnMiercoles);
        jueves = view.findViewById(R.id.btnJueves);
        viernes = view.findViewById(R.id.btnViernes);


        final BDentrenadores bDentrenadores = new BDentrenadores(getContext());

        String usuairo=(getActivity().getIntent().getExtras().getString("llave"));


        Entrenadores entrenadores = new Entrenadores();

        bDentrenadores.buscarEntrenadores(entrenadores,usuairo);



        String lunesE = (entrenadores.getLunes());
        String martesE =(entrenadores.getMartes());
        String miercolesE =(entrenadores.getMiercoles());
        String juevesE =(entrenadores.getJueves());
        String viernesE =(entrenadores.getViernes());


        lunes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.rutinaEjerciciosContenedor, SemanaEjecicioFragment.newInstance("Lunes",lunesE));
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
                transaction.replace(R.id.rutinaEjerciciosContenedor, SemanaEjecicioFragment.newInstance("Martes",martesE));
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
                transaction.replace(R.id.rutinaEjerciciosContenedor, SemanaEjecicioFragment.newInstance("Miercoles",miercolesE));
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
                transaction.replace(R.id.rutinaEjerciciosContenedor, SemanaEjecicioFragment.newInstance("Jueves",juevesE));
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
                transaction.replace(R.id.rutinaEjerciciosContenedor, SemanaEjecicioFragment.newInstance("Viernes",viernesE));
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