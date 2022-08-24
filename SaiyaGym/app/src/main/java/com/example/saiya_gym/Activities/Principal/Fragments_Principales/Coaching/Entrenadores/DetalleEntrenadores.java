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
import android.widget.Toast;

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.DashboardFragment;
import com.example.saiya_gym.Activities.SQLite.BDdietas;
import com.example.saiya_gym.Activities.SQLite.BDentrenadores;
import com.example.saiya_gym.Activities.SQLite.BDusuario;
import com.example.saiya_gym.R;

public class DetalleEntrenadores extends Fragment {

    View view;
    TextView titulo,contenido,ejemplo;
    ImageView imagen;
    Button btnAceptar,btnRegresar;
    public DetalleEntrenadores() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DetalleEntrenadores newInstance() {
        DetalleEntrenadores fragment = new DetalleEntrenadores();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.detalle_entrenadores, container, false);
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
                transaction.replace(R.id.detalleEntrenadorContenedor, EntrenadoresFragment.newInstance());
                transaction.commit();
                btnAceptar.setVisibility(View.GONE);
                btnRegresar.setVisibility(View.GONE);
            }
        });


        if(objetoEntrenador!=null){
            entrenadores = (Entrenadores) objetoEntrenador.getSerializable("objeto");

            titulo.setText(entrenadores.getNombre());
            contenido.setText(entrenadores.getInformacion());
            imagen.setImageResource(entrenadores.getImagen());

        }
        String usuario = getActivity().getIntent().getExtras().getString("llave");
        String entrenador =(entrenadores.getNombre());
        String lunes = (entrenadores.getLunesE());
        String martes = (entrenadores.getMartesE());
        String miercoles = (entrenadores.getMiercolesE());
        String jueves = (entrenadores.getJuevesE());
        String viernes = (entrenadores.getViernesE());


        String lunesD =(entrenadores.getLunesDi());
        String martesD =(entrenadores.getMartesDi());
        String miercolesD =(entrenadores.getMiercolesDi());
        String juevesD =(entrenadores.getJuevesDi());
        String viernesD =(entrenadores.getViernesDi());



        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.contenedorEntrenadores, DashboardFragment.newInstance());
                transaction.commit();
                btnAceptar.setVisibility(View.GONE);
                btnRegresar.setVisibility(View.GONE);
                final BDentrenadores bDentrenadores = new BDentrenadores(getContext());
                final BDdietas bDdietas = new BDdietas(getContext());

                bDentrenadores.agregarEntrenadores(usuario,entrenador,lunes,martes,miercoles,jueves,viernes);

                bDdietas.agregarEntrenadoresDieta(usuario,entrenador,lunesD,martesD,miercolesD,juevesD,viernesD);

            }
        });


        return view;
    }
}