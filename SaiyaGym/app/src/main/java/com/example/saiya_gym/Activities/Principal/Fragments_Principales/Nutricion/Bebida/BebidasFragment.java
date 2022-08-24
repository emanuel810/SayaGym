package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Nutricion.Bebida;

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


public class BebidasFragment extends Fragment {

    View view;
    List<Ventas> ventasList;
    RecyclerView recyclerView;
    VentasAdapter ventasAdapter;
    Button btnRegresar;
    Activity actividad;
    iComunicaFragments interfaceComunicaBebida;

    public BebidasFragment() {

    }

    public static BebidasFragment newInstance() {
        BebidasFragment fragment = new BebidasFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bebidas, container, false);


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
                interfaceComunicaBebida.enviarBebida(ventasList.get(recyclerView.getChildAdapterPosition(view)));
            }
        });
    }

    private void iniciar() {

        ventasList.add((new Ventas("Licuado verde","Hecho con hierbas frescas","Q.15.00",R.drawable.licuadoverde1)));
        ventasList.add((new Ventas("Jugo de naranja","naranjas recien extraidas","Q.15.00",R.drawable.naranja2)));
        ventasList.add((new Ventas("Limonada","limones recien extraido","Q.15.00",R.drawable.limonadad3)));
        ventasList.add((new Ventas("Jugo de jamaica","100% natural","Q.15.00",R.drawable.jamaica4)));
        ventasList.add((new Ventas("Agua pura","agua purificada","Q.5.00",R.drawable.aguapurta5)));
        ventasList.add((new Ventas("Jugo de zanahoria","Recien extraido","Q.15.00",R.drawable.zanahoria6)));
        ventasList.add((new Ventas("Jugo de remolacha","Recien extraido","Q.15.00",R.drawable.remolacha7)));
        ventasList.add((new Ventas("Jugo de sandia","Recien extraido","Q.15.00",R.drawable.sandia8)));
        ventasList.add((new Ventas("Jugo de limón","Recien extraido","Q.15.00",R.drawable.melon9)));
        ventasList.add((new Ventas("Jugo de piña","Recien extraido","Q.15.00",R.drawable.pina10)));

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            this.actividad = (Activity)context;
            interfaceComunicaBebida =(iComunicaFragments) this.actividad;
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