package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Prendas;

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

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.DashboardFragment;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Ventas.Ventas;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Ventas.VentasAdapter;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.iComunicaFragments;
import com.example.saiya_gym.R;

import java.util.ArrayList;
import java.util.List;


public class PrendasFragment extends Fragment {


    List<Ventas> ventasList;
    RecyclerView recyclerView;
    VentasAdapter ventasAdapter;
    Button btnRegresar;
    View view;
    Activity actividad;
    iComunicaFragments interfaceComunicaPrenda;


    public static PrendasFragment newInstance() {
        PrendasFragment fragment = new PrendasFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_prendas, container, false);

        recyclerView = view.findViewById(R.id.listas_prenda);
        btnRegresar = view.findViewById(R.id.btnRegresarCoaching);
        ventasList = new ArrayList<>();
        iniciar();
        mostrarData();


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.prendasContenedor, DashboardFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
            }
        });




        return  view;
    }

    private void mostrarData() {

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ventasAdapter = new VentasAdapter(getContext(), ventasList);
        recyclerView.setAdapter(ventasAdapter);

        ventasAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interfaceComunicaPrenda.enviarPrenda(ventasList.get(recyclerView.getChildAdapterPosition(view)));
            }
        });
    }

    private void iniciar() {
        ventasList.add(new Ventas("guantes rosados","proteje ante todo con buen agarre","Q50.00",R.drawable.guantesventa));
        ventasList.add(new Ventas("guantes negros","proteje ante todo con buen agarre","Q50.00",R.drawable.guanteshombres));
        ventasList.add(new Ventas("Conjunto","viene incluido 5 piezas","Q500.00",R.drawable.conjunto));
        ventasList.add(new Ventas("Faja reductora","ayuda a rebajar la cintura","Q200.00",R.drawable.fajareductora));
        ventasList.add(new Ventas("Top deportivo","refresca durante el ejercicio","Q100.00",R.drawable.topdeportivo));
        ventasList.add(new Ventas("Licra","viene en diferentes colores","Q100.00",R.drawable.licras));
        ventasList.add(new Ventas("Mochila GYM BAG","lleva tus cosas con estilo","Q250.00",R.drawable.mochilagymbag));
        ventasList.add(new Ventas("Pachon GNC","Lo infaltable no puede quedarse","Q60.00",R.drawable.pachongnc));
        ventasList.add(new Ventas("Pans","viene en diferentes colores","Q200.00",R.drawable.panshombre));
        ventasList.add(new Ventas("Smart Bands","La tecnologia en tu muñeca","Q1,000.00",R.drawable.smartbands));

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.actividad = (Activity)context;
        interfaceComunicaPrenda =(iComunicaFragments) this.actividad;

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        view=null;
    }
}