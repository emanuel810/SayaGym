package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Ejercicios.AbdomenFragment;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Ejercicios.BicepsFragment;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Ejercicios.EspaldaFragment;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Ejercicios.HombrosFragment;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Ejercicios.PechoFragment;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Ejercicios.PiernasFragment;
import com.example.saiya_gym.R;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Ejercicios.TricepsFragment;


public class EjerciciosFragment extends Fragment {

    Button btnRegresar,btnHombro,btnPecho,btnEspalda,btnBiceps,btnTriceps,btnAbdomen,btnPierna;
    View view;
    public EjerciciosFragment() {
        // Required empty public constructor
    }


    public static EjerciciosFragment newInstance() {
        EjerciciosFragment fragment = new EjerciciosFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_ejercicios, container, false);
        btnRegresar = view.findViewById(R.id.btnRegresarCoachingR);
        btnBiceps = view.findViewById(R.id.btnBiceps);
        btnAbdomen = view.findViewById(R.id.btnAbdomen);
        btnEspalda = view.findViewById(R.id.btnEspalda);
        btnHombro = view.findViewById(R.id.btnHombros);
        btnTriceps = view.findViewById(R.id.btnTriceps);
        btnPierna= view.findViewById(R.id.btnPierna);
        btnPecho= view.findViewById(R.id.btnPecho);

        btnHombro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.musculoContenedor, HombrosFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
                btnAbdomen.setVisibility(View.GONE);
                btnBiceps.setVisibility(View.GONE);
                btnEspalda.setVisibility(View.GONE);
                btnTriceps.setVisibility(View.GONE);
                btnHombro.setVisibility(View.GONE);
                btnPecho.setVisibility(View.GONE);
                btnPierna.setVisibility(View.GONE);
            }
        });


        btnPecho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.musculoContenedor, PechoFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
                btnAbdomen.setVisibility(View.GONE);
                btnBiceps.setVisibility(View.GONE);
                btnEspalda.setVisibility(View.GONE);
                btnTriceps.setVisibility(View.GONE);
                btnHombro.setVisibility(View.GONE);
                btnPecho.setVisibility(View.GONE);
                btnPierna.setVisibility(View.GONE);
            }
        });


        btnEspalda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.musculoContenedor, EspaldaFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
                btnAbdomen.setVisibility(View.GONE);
                btnBiceps.setVisibility(View.GONE);
                btnEspalda.setVisibility(View.GONE);
                btnTriceps.setVisibility(View.GONE);
                btnHombro.setVisibility(View.GONE);
                btnPecho.setVisibility(View.GONE);
                btnPierna.setVisibility(View.GONE);
            }
        });


        btnBiceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.musculoContenedor, BicepsFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
                btnAbdomen.setVisibility(View.GONE);
                btnBiceps.setVisibility(View.GONE);
                btnEspalda.setVisibility(View.GONE);
                btnTriceps.setVisibility(View.GONE);
                btnHombro.setVisibility(View.GONE);
                btnPecho.setVisibility(View.GONE);
                btnPierna.setVisibility(View.GONE);
            }
        });


        btnTriceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.musculoContenedor, TricepsFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
                btnAbdomen.setVisibility(View.GONE);
                btnBiceps.setVisibility(View.GONE);
                btnEspalda.setVisibility(View.GONE);
                btnTriceps.setVisibility(View.GONE);
                btnHombro.setVisibility(View.GONE);
                btnPecho.setVisibility(View.GONE);
                btnPierna.setVisibility(View.GONE);
            }
        });

        btnAbdomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.musculoContenedor, AbdomenFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
                btnAbdomen.setVisibility(View.GONE);
                btnBiceps.setVisibility(View.GONE);
                btnEspalda.setVisibility(View.GONE);
                btnTriceps.setVisibility(View.GONE);
                btnHombro.setVisibility(View.GONE);
                btnPecho.setVisibility(View.GONE);
                btnPierna.setVisibility(View.GONE);
            }
        });


        btnPierna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.musculoContenedor, PiernasFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
                btnAbdomen.setVisibility(View.GONE);
                btnBiceps.setVisibility(View.GONE);
                btnEspalda.setVisibility(View.GONE);
                btnTriceps.setVisibility(View.GONE);
                btnHombro.setVisibility(View.GONE);
                btnPecho.setVisibility(View.GONE);
                btnPierna.setVisibility(View.GONE);
            }
        });



        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.musculoContenedor, RutinasFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
                btnAbdomen.setVisibility(View.GONE);
                btnBiceps.setVisibility(View.GONE);
                btnEspalda.setVisibility(View.GONE);
                btnTriceps.setVisibility(View.GONE);
                btnHombro.setVisibility(View.GONE);
                btnPecho.setVisibility(View.GONE);
                btnPierna.setVisibility(View.GONE);
            }
        });


        return view;
    }
}