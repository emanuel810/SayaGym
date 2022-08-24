package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Entrenadores;

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
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.iComunicaFragments;
import com.example.saiya_gym.Activities.SQLite.BDdietas;
import com.example.saiya_gym.Activities.SQLite.BDentrenadores;
import com.example.saiya_gym.Activities.SQLite.BDtallasIniciales;
import com.example.saiya_gym.R;

import java.util.ArrayList;
import java.util.List;


public class EntrenadoresFragment extends Fragment {

    View view;
    List<Entrenadores> entrenadoresList;
    RecyclerView recyclerView;
    EntrenadoresAdapter entrenadoresAdapter;
    Button btnRegresar;
    Activity actividad;
    iComunicaFragments interfaceComunicaEntrenadores;




    public EntrenadoresFragment() {
        // Required empty public constructor
    }



    public static EntrenadoresFragment newInstance() {
        EntrenadoresFragment fragment = new EntrenadoresFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_entrenadores, container, false);


        recyclerView = view.findViewById(R.id.lista_entrenador);
        btnRegresar = view.findViewById(R.id.btnRegresarMenuCoaching);

        entrenadoresList = new ArrayList<>();
        iniciar();
        mostrarData();


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.contenedorEntrenadores, DashboardFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
            }
        });


        return view;
    }
    private void iniciar() {
        final BDentrenadores bDentrenadores = new BDentrenadores(getContext());
        final BDdietas bDdietas = new BDdietas(getContext());
        String usuairo=(getActivity().getIntent().getExtras().getString("llave"));
        bDentrenadores.mostrarEntrenadores(usuairo);
        bDdietas.mostrarDietas(usuairo);
    }

    private void mostrarData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        entrenadoresAdapter = new EntrenadoresAdapter(getContext(), entrenadoresList);
        recyclerView.setAdapter(entrenadoresAdapter);

        entrenadoresAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interfaceComunicaEntrenadores.enviarEntrenadores(entrenadoresList.get(recyclerView.getChildAdapterPosition(view)));
            }
        });
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            this.actividad = (Activity)context;
            interfaceComunicaEntrenadores =(iComunicaFragments) this.actividad;
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