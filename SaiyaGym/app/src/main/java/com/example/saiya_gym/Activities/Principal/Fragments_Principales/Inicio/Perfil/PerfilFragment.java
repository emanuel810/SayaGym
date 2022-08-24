package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Inicio.Perfil;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.saiya_gym.Activities.Inicio.LoginActivity;
import com.example.saiya_gym.Activities.Inicio.Usuario.Usuario;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Inicio.HomeFragment;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.iComunicaFragments;
import com.example.saiya_gym.Activities.Principal.PrincipalActivity;
import com.example.saiya_gym.Activities.SQLite.BDusuario;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Inicio.Perfil.Avances.ListaAvancesFragment;
import com.example.saiya_gym.R;


public class PerfilFragment extends Fragment {


    View view;
    private static final String usuarioVar1 = "param1";
    iComunicaFragments interfaceComunicaComida;

    private String usuariovar;
    TextView nombre,contraseña,usuario,edad,PesoI,PesoF;
    Button btnRegresar,btnVeravances,btnCerrarSesion;


    public PerfilFragment() {
        // Required empty public constructor
    }


    public static PerfilFragment newInstance(String usuariovar, String param2) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(usuarioVar1, usuariovar);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            usuariovar = getArguments().getString(usuarioVar1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.fragment_perfil, container, false);

        usuario = view.findViewById(R.id.usuarioPerfilCambiar);
        nombre= view.findViewById(R.id.NombrePerfilCambiar);
        usuario = view.findViewById(R.id.usuarioPerfilCambiar);
        contraseña = view.findViewById(R.id.contraseñaPerfilCambiar);
        edad= view.findViewById(R.id.edadPerfilCambiar);
        PesoF= view.findViewById(R.id.pesoFInalCambiar);
        PesoI = view.findViewById(R.id.pesoInicialCambiar);


        btnRegresar = view.findViewById(R.id.btnRegresarInicio);
        btnVeravances = view.findViewById(R.id.btnAvances);
        btnCerrarSesion = view.findViewById(R.id.btnCerrarSesion);


        btnVeravances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.contenedorPerfil, ListaAvancesFragment.newInstance("",""));
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
                btnVeravances.setVisibility(View.GONE);
                btnCerrarSesion.setVisibility(View.GONE);
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.contenedorPerfil, HomeFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
                btnVeravances.setVisibility(View.GONE);
                btnCerrarSesion.setVisibility(View.GONE);
            }
        });


        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), LoginActivity.class);
                startActivity(i);
            }
        });




        final BDusuario bDusuario = new BDusuario(getContext());

        String usuairo=(getActivity().getIntent().getExtras().getString("llave"));
        usuario.setText(usuairo);
        Usuario usuario = new Usuario();
        bDusuario.buscarUsuario(usuario,usuairo);

        nombre.setText(usuario.getNombre());
        contraseña.setText(usuario.getContraseña());
        edad.setText(usuario.getEdad());
        PesoI.setText(usuario.getPesoInicial());
        PesoF.setText(usuario.getPesoFinal());

        return view;
    }
}