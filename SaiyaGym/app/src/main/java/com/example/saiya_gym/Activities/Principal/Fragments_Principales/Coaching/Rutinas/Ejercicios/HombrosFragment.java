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


public class HombrosFragment extends Fragment {

    List<Musculos> musculosList;
    RecyclerView recyclerView;
    MusculosAdapter musculosAdapter;
    Button btnRegresar;
    View view;
    Activity actividad;
    iComunicaFragments interfaceComunicaHombro;


    public HombrosFragment() {

    }


    public static HombrosFragment newInstance() {
        HombrosFragment fragment = new HombrosFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_hombros, container, false);


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

        return view;
    }


    private void iniciar() {
        musculosList.add(new Musculos("Elevaciones frontales",R.drawable.elevacionesfrontales));
        musculosList.add(new Musculos("Elevaciones laterales",R.drawable.elevacioneslaterales));
        musculosList.add(new Musculos("Encogimiento",R.drawable.encogimiento));
        musculosList.add(new Musculos("Press frontal",R.drawable.pressfrontal));
        musculosList.add(new Musculos("Remo al cuello",R.drawable.remoalcuello));

    }

    private void mostrarData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        musculosAdapter = new MusculosAdapter(getContext(), musculosList);
        recyclerView.setAdapter(musculosAdapter);

        musculosAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interfaceComunicaHombro.enviarHombros(musculosList.get(recyclerView.getChildAdapterPosition(view)));
            }
        });
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            this.actividad = (Activity)context;
            interfaceComunicaHombro =(iComunicaFragments) this.actividad;
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