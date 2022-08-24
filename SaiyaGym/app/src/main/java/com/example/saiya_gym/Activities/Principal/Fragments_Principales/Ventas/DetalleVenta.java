package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Ventas;

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

import com.example.saiya_gym.R;


public class DetalleVenta extends Fragment {

    TextView titulo,contenido,precio;
    ImageView imagen;
    Button btnAgregar;

    public DetalleVenta() {
        // Required empty public constructor
    }


    public static DetalleVenta newInstance() {
        DetalleVenta fragment = new DetalleVenta();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.detalle_venta,container,false);

        titulo = view.findViewById(R.id.tituloPrendaDetalle);
        contenido =view.findViewById(R.id.ContenidoComidaDetalle);
        precio = view.findViewById(R.id.precioComidaDetalle);
        imagen = view.findViewById(R.id.imagenComidaDetalle);
        btnAgregar = view.findViewById(R.id.btnAgregarComida);


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.contenedorMenu, Confirmacion_Venta_Fragment.newInstance());
                transaction.commit();
                btnAgregar.setVisibility(View.GONE);
            }
        });
        Bundle objetoVentas = getArguments();
        Ventas ventas = null;


        if(objetoVentas!=null){
            ventas = (Ventas) objetoVentas.getSerializable("objeto");

            titulo.setText(ventas.getTitulo());
            contenido.setText((ventas.getContenido()));
            precio.setText((ventas.getPrecio()));
            imagen.setImageResource(ventas.getImagen());

        }

        return view;
    }
}