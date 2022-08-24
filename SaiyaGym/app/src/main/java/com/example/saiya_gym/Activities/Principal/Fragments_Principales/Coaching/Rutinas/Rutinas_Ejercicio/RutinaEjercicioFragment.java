package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Rutinas_Ejercicio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.RutinasFragment;
import com.example.saiya_gym.R;


public class RutinaEjercicioFragment extends Fragment {

    View view;
    Button btnRegresar;

    public RutinaEjercicioFragment() {
        // Required empty public constructor
    }

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    public static RutinaEjercicioFragment newInstance(String param1, String param2) {
        RutinaEjercicioFragment fragment = new RutinaEjercicioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_rutina_ejercicio, container, false);

        btnRegresar = view.findViewById(R.id.btnRegresarEjerciciosCoaching);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.rutinaEjerciciosContenedor, RutinasFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
            }
        });

        return view;
    }
}