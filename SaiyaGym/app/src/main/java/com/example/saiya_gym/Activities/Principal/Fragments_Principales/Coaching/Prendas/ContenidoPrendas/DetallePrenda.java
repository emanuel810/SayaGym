package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Prendas.ContenidoPrendas;

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

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Ventas.Ventas;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Ventas.Confirmacion_Venta_Fragment;
import com.example.saiya_gym.R;


public class DetallePrenda extends Fragment {

    View view;

    TextView titulo,contenido,precio;
    ImageView imagen;
    Button btnAgregar;


    public DetallePrenda() {
        // Required empty public constructor
    }


    public static DetallePrenda newInstance() {
        DetallePrenda fragment = new DetallePrenda();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.detalle_prenda, container, false);

        titulo = view.findViewById(R.id.tituloPrendaDetalle);
        contenido =view.findViewById(R.id.contenidoPrendaDetalle);
        precio = view.findViewById(R.id.precioPrendaDetalle);
        imagen = view.findViewById(R.id.imagenPrendaDetalle);
        btnAgregar = view.findViewById(R.id.btnAgregarPrenda);



        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.prendasContenedor, Confirmacion_Venta_Fragment.newInstance());
                transaction.commit();
                btnAgregar.setVisibility(View.GONE);
            }
        });
        Bundle objetoComida = getArguments();
        Ventas ventas = null;


        if(objetoComida!=null){
            ventas = (Ventas) objetoComida.getSerializable("objeto");

            titulo.setText(ventas.getTitulo());
            contenido.setText((ventas.getContenido()));
            precio.setText((ventas.getPrecio()));
            imagen.setImageResource(ventas.getImagen());

        }

        return view;
    }
}