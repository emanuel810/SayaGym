package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Ventas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Inicio.HomeFragment;
import com.example.saiya_gym.R;

public class Confirmacion_Venta_Fragment extends Fragment {
    View view;

    Button btnAceptar;
    public Confirmacion_Venta_Fragment() {
        // Required empty public constructor
    }


    public static Confirmacion_Venta_Fragment newInstance() {
        Confirmacion_Venta_Fragment fragment = new Confirmacion_Venta_Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_confirmacion_venta, container, false);



        btnAceptar = view.findViewById(R.id.confirmarbtn);


        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.confirmacionVentaContenedor, HomeFragment.newInstance());
                transaction.commit();
                btnAceptar.setVisibility(View.GONE);
            }
        });



        return view;
    }
}