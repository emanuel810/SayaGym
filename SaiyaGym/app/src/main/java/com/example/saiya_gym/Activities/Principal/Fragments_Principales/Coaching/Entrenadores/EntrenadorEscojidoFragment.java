package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Entrenadores;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.DashboardFragment;
import com.example.saiya_gym.R;


public class EntrenadorEscojidoFragment extends Fragment {

    View view;

    TextView titulo,contenido;
    ImageView imagen;
    Button btnAceptar,btnRegresar;

    public EntrenadorEscojidoFragment() {
        // Required empty public constructor
    }

    public static EntrenadorEscojidoFragment newInstance(String param1, String param2) {
        EntrenadorEscojidoFragment fragment = new EntrenadorEscojidoFragment();

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
        view = inflater.inflate(R.layout.fragment_entrenador_escojido, container, false);


        titulo = view.findViewById(R.id.tituloEntrenadoresDetalle);
        contenido = view.findViewById(R.id.contenidoDetalleEntrenadores);
        imagen = view.findViewById(R.id.imagenEntrenadorDetalle);
        btnAceptar = view.findViewById(R.id.btnAceptar);
        btnRegresar = view.findViewById(R.id.botonDetallesRegresar);

        Bundle objetoEntrenador = getArguments();
        Entrenadores entrenadores = null;


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.detalleEntrenadorContenedor, DashboardFragment.newInstance());
                transaction.commit();
                btnAceptar.setVisibility(View.GONE);
                btnRegresar.setVisibility(View.GONE);
            }
        });

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.detalleEntrenadorContenedor, EntrenadoresFragment.newInstance());
                transaction.commit();
                btnAceptar.setVisibility(View.GONE);
                btnRegresar.setVisibility(View.GONE);
            }
        });


        return view;
    }
}