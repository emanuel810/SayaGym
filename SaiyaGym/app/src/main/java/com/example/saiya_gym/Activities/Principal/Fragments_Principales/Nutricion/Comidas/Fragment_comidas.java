package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Nutricion.Comidas;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Ventas.Ventas;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Ventas.VentasAdapter;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Nutricion.NotificationsFragment;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.iComunicaFragments;
import com.example.saiya_gym.R;

import java.util.ArrayList;
import java.util.List;


public class Fragment_comidas extends Fragment {

    List<Ventas> ventasList;
    RecyclerView recyclerView;
    VentasAdapter ventasAdapter;
    Button btnRegresar;
    View view;
    Activity actividad;
    iComunicaFragments interfaceComunicaComida;



    public static Fragment_comidas newInstance() {
        Fragment_comidas fragment = new Fragment_comidas();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_comida, container, false);


        recyclerView = view.findViewById(R.id.lista_comidas);
        btnRegresar = view.findViewById(R.id.btnRregresarNutricion);


        ventasList = new ArrayList<>();
        iniciar();
        mostrarData();


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.contenedorMenu, NotificationsFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
            }
        });

        return view;
    }

    private void mostrarData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ventasAdapter = new VentasAdapter(getContext(), ventasList);
        recyclerView.setAdapter(ventasAdapter);

        ventasAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interfaceComunicaComida.enviarComida(ventasList.get(recyclerView.getChildAdapterPosition(view)));
            }
        });
    }

    private void iniciar() {

        ventasList.add((new Ventas("Sandwich de huevos","Sandiwch de huevo con lechuga","Q.5.00",R.drawable.sandwichhuevo)));
        ventasList.add((new Ventas("Sandwich de jamón","Sandwich de jamon con lechuga y tomate.","Q.10.00",R.drawable.sandwich)));
        ventasList.add((new Ventas("Pollo a la plancha","Pollo a la plancha acompañado con tomate,espinaca y papa. ","Q.35.00",R.drawable.pollo_a_la_plancha2)));
        ventasList.add((new Ventas("Verduras al vapor","Verduras al vapor (ejotes,wicoy, brocoli y chile dulce)","Q.20.00",R.drawable.verduras_al_vapor3)));
        ventasList.add((new Ventas("Tortilla harina de papa","Tortilla de harina rellena de papa cocida, acompañado de aguacate","Q.20.00",R.drawable.omelet9)));
        ventasList.add((new Ventas("Pescado asado","Filete de merluza acompañado con arroz, verduras,platano y tomate","Q.40.00",R.drawable.pescadoasado4)));
        ventasList.add((new Ventas("Ensalada verde","Ensalada de lo mas completa con verduras frescas","Q.30.00",R.drawable.ensaladaverde5)));
        ventasList.add((new Ventas("Pasta con verduras","Espagueti acompañado con una mezcla selectiva de verduras","Q.40.00",R.drawable.espagueticonverduras6)));
        ventasList.add((new Ventas("Yogurt con frutas","Yogurt blanco acompañado de granola con pedazos de fruta","Q.25.00",R.drawable.yogurt7)));
        ventasList.add((new Ventas("Desayuno completo","Huevo acompañado con sus rodajas de pan tostado y rodajas de naranja,jugo de naranja y cafe negro","Q.40.00",R.drawable.pescadoasado4)));

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            this.actividad = (Activity)context;
            interfaceComunicaComida =(iComunicaFragments) this.actividad;
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}