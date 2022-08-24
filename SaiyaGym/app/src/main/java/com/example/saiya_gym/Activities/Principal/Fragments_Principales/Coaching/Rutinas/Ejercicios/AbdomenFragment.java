package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Ejercicios;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.EjerciciosFragment;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Musculos.Musculos;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Musculos.MusculosAdapter;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.iComunicaFragments;
import com.example.saiya_gym.R;

import java.util.ArrayList;
import java.util.List;


public class AbdomenFragment extends Fragment {

    List<Musculos> musculosList;
    RecyclerView recyclerView;
    MusculosAdapter musculosAdapter;
    Button btnRegresar;
    View view;
    Activity actividad;
    iComunicaFragments interfaceComunicaAbdomen;

    public AbdomenFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static AbdomenFragment newInstance() {
        AbdomenFragment fragment = new AbdomenFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_abdomen, container, false);

        recyclerView = view.findViewById(R.id.listasEjercicios);
        btnRegresar = view.findViewById(R.id.btnRegresarEjercicios);
        musculosList = new ArrayList<>();
        iniciar();
        mostrarData();


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.contenedorMusculos, EjerciciosFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
            }
        });


        return  view;
    }

    private void iniciar() {
        musculosList.add(new Musculos("Abdominales",R.drawable.elevaciondetroncoenelsuelo));
        musculosList.add(new Musculos("Elevaciones de tronco inclinado",R.drawable.elevaciondetroncoinclinado));
        musculosList.add(new Musculos("Encogimiento de tronco",R.drawable.encogimientoalterno));
        musculosList.add(new Musculos("Flexiones laterales de tronco",R.drawable.flexionlateraldeltronco));
        musculosList.add(new Musculos("Hiper extensiones",R.drawable.hiperextensiones));


    }

    private void mostrarData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        musculosAdapter = new MusculosAdapter(getContext(), musculosList);
        recyclerView.setAdapter(musculosAdapter);

        musculosAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interfaceComunicaAbdomen.enviarAbdomen(musculosList.get(recyclerView.getChildAdapterPosition(view)));
            }
        });
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            this.actividad = (Activity)context;
            interfaceComunicaAbdomen =(iComunicaFragments) this.actividad;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        view = null;
    }

}