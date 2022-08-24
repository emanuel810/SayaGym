package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.DashboardFragment;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Consejos.ConsejosFragment;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Rutinas_Ejercicio.AvisoFragment;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Rutinas_Ejercicio.RutinaEjercicioFragment;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Rutinas_Ejercicio.RutinasEntrenadorFragment;
import com.example.saiya_gym.Activities.SQLite.BDentrenadores;
import com.example.saiya_gym.R;


public class RutinasFragment extends Fragment {

    View view;
    Button btnRegresar,btnEjercicio,btnrutinaEjercicio,btnConsejos;

    public RutinasFragment() {
        // Required empty public constructor
    }


    public static RutinasFragment newInstance() {
        RutinasFragment fragment = new RutinasFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_rutinas, container, false);


        btnRegresar = view.findViewById(R.id.btnRegresarCoachingR);
        btnEjercicio = view.findViewById(R.id.btnEjercicios);
        btnrutinaEjercicio = view.findViewById(R.id.btnEjerciciosRutina);
        btnConsejos = view.findViewById(R.id.btnConsejos);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.contenedorRutinasCoashing, DashboardFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
                btnEjercicio.setVisibility(View.GONE);
                btnrutinaEjercicio.setVisibility(View.GONE);
                btnConsejos.setVisibility(View.GONE);
            }
        });

        btnEjercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.contenedorRutinasCoashing, EjerciciosFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
                btnEjercicio.setVisibility(View.GONE);
                btnrutinaEjercicio.setVisibility(View.GONE);
                btnConsejos.setVisibility(View.GONE);
            }
        });

        btnrutinaEjercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ir_rutinasEjercicio();
                final BDentrenadores bDentrenadores = new BDentrenadores(getContext());
                String usuario = getActivity().getIntent().getExtras().getString("llave");
                if(bDentrenadores.verificarEntrenador(usuario)){
                    ir_rutinasSemanas();;
                }else{
                ir_mensaje();}
            }
        });


        btnConsejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.contenedorRutinasCoashing, ConsejosFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
                btnEjercicio.setVisibility(View.GONE);
                btnrutinaEjercicio.setVisibility(View.GONE);
                btnConsejos.setVisibility(View.GONE);
            }
        });

        return view;
    }

    private void ir_rutinasSemanas() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.contenedorRutinasEjercicios, RutinasEntrenadorFragment.newInstance("",""));
        transaction.commit();
        btnRegresar.setVisibility(View.GONE);
        btnEjercicio.setVisibility(View.GONE);
        btnrutinaEjercicio.setVisibility(View.GONE);
        btnConsejos.setVisibility(View.GONE);
    }

    private void ir_mensaje() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.contenedorRutinasEjercicios, AvisoFragment.newInstance());
        transaction.commit();
        btnRegresar.setVisibility(View.GONE);
        btnEjercicio.setVisibility(View.GONE);
        btnrutinaEjercicio.setVisibility(View.GONE);
        btnConsejos.setVisibility(View.GONE);


    }

    private void ir_rutinasEjercicio() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.contenedorRutinasCoashing, RutinaEjercicioFragment.newInstance("",""));
        transaction.commit();
        btnRegresar.setVisibility(View.GONE);
        btnEjercicio.setVisibility(View.GONE);
        btnrutinaEjercicio.setVisibility(View.GONE);
        btnConsejos.setVisibility(View.GONE);
    }
}