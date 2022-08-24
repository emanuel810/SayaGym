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


public class EspaldaFragment extends Fragment {

    List<Musculos> musculosList;
    RecyclerView recyclerView;
    MusculosAdapter musculosAdapter;
    Button btnRegresar;
    View view;
    Activity actividad;
    iComunicaFragments interfaceComunicaEspalda;

    public EspaldaFragment() {
        // Required empty public constructor
    }


    public static EspaldaFragment newInstance() {
        EspaldaFragment fragment = new EspaldaFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_espalda, container, false);
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
        musculosList.add(new Musculos("Dominadas",R.drawable.dominadas));
        musculosList.add(new Musculos("Polea al pecho",R.drawable.poleaalpecho));
        musculosList.add(new Musculos("Remo",R.drawable.remo));
        musculosList.add(new Musculos("Remo T",R.drawable.remot));
        musculosList.add(new Musculos("Serrucho",R.drawable.serrucho));

    }

    private void mostrarData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        musculosAdapter = new MusculosAdapter(getContext(), musculosList);
        recyclerView.setAdapter(musculosAdapter);

        musculosAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interfaceComunicaEspalda.enviarEspalda(musculosList.get(recyclerView.getChildAdapterPosition(view)));
            }
        });
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            this.actividad = (Activity)context;
            interfaceComunicaEspalda =(iComunicaFragments) this.actividad;
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