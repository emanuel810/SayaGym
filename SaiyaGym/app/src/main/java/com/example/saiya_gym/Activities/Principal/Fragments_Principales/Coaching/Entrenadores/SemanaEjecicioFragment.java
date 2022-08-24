package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Entrenadores;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.DashboardFragment;
import com.example.saiya_gym.R;


public class SemanaEjecicioFragment extends Fragment {


    View view;
    Button regresar;
    TextView titulo,contenido;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SemanaEjecicioFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SemanaEjecicioFragment newInstance(String param1, String param2) {
        SemanaEjecicioFragment fragment = new SemanaEjecicioFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_semana_ejecicio, container, false);

        regresar = view.findViewById(R.id.botonDetallesRegresar);
        titulo = view.findViewById(R.id.tituloEjerciciosEntrenador);
        contenido = view.findViewById(R.id.contenidoEjercicioEntrenador);

        titulo.setText(mParam1);
        contenido.setText(mParam2);

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.rutinaEjerciciosContenedor, DashboardFragment.newInstance());
                transaction.commit();
                regresar.setVisibility(View.GONE);
            }
        });

        return view;
    }
}