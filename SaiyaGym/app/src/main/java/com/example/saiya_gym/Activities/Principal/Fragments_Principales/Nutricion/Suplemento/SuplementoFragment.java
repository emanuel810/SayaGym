package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Nutricion.Suplemento;

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

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Nutricion.NotificationsFragment;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Ventas.Ventas;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Ventas.VentasAdapter;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.iComunicaFragments;
import com.example.saiya_gym.R;

import java.util.ArrayList;
import java.util.List;


public class SuplementoFragment extends Fragment {

    List<Ventas> ventasList;
    RecyclerView recyclerView;
    VentasAdapter ventasAdapter;
    Button btnRegresar;
    View view;
    Activity actividad;
    iComunicaFragments interfaceComunicaSuplemento;


    public SuplementoFragment() {
        // Required empty public constructor
    }


    public static SuplementoFragment newInstance() {
        SuplementoFragment fragment = new SuplementoFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_suplemento, container, false);

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
                interfaceComunicaSuplemento.enviarSuplemento(ventasList.get(recyclerView.getChildAdapterPosition(view)));
            }
        });
    }

    private void iniciar() {

        ventasList.add((new Ventas("Nitrotech","Bote grande","Q.850.00",R.drawable.nitrotesh)));
        ventasList.add((new Ventas("Gold Standar","Bote grande","Q.1,000.00",R.drawable.goldestandar2suplemento)));
        ventasList.add((new Ventas("Combat","Bote grande","Q.700.00",R.drawable.combat2suplemento)));
        ventasList.add((new Ventas("C4 Extreme","Bote grande","Q.1,250.00",R.drawable.c4extreme4suplemento)));
        ventasList.add((new Ventas("Aminox","Bote grande","Q.800.00",R.drawable.aminox5suplemento)));
        ventasList.add((new Ventas("Creature Beast","Bote grande","Q.1,050.00",R.drawable.bcreature6suplemento)));
        ventasList.add((new Ventas("SUPER HD","Bote grande","Q.600.00",R.drawable.superhdsuplemento)));
        ventasList.add((new Ventas("Animals PAK","Bote grande","Q.850.00",R.drawable.animalspack8suplemento)));
        ventasList.add((new Ventas("Elite Casein","Bote grande","Q.850.00",R.drawable.elitecasein9suplemento)));
        ventasList.add((new Ventas("Hidroxi Cut","Bote grande","Q.1,500.00",R.drawable.hidroxicut10suplemento)));


    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            this.actividad = (Activity)context;
            interfaceComunicaSuplemento =(iComunicaFragments) this.actividad;
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