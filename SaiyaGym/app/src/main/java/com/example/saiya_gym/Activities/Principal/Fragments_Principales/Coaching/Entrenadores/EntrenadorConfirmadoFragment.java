package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Entrenadores;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.DashboardFragment;
import com.example.saiya_gym.Activities.SQLite.BDdietas;
import com.example.saiya_gym.Activities.SQLite.BDentrenadores;
import com.example.saiya_gym.R;


public class EntrenadorConfirmadoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view;
    Button escojerOtro,regresar;
    public EntrenadorConfirmadoFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static EntrenadorConfirmadoFragment newInstance(String param1, String param2) {
        EntrenadorConfirmadoFragment fragment = new EntrenadorConfirmadoFragment();
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
        view = inflater.inflate(R.layout.fragment_entrenador_confirmado, container, false);

        String usuario = getActivity().getIntent().getExtras().getString("llave");

        escojerOtro = view.findViewById(R.id.escojerNuevoEntrenador);
        regresar = view.findViewById(R.id.botonDetallesRegresar);

        escojerOtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BDentrenadores bDentrenadores = new BDentrenadores(getContext());
                final BDdietas bDdietas = new BDdietas(getContext());

                bDentrenadores.eliminarentrenadores(usuario);

                bDdietas.eliminareEntrenadoresDieta (usuario);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.entrenadorConfirmadoContenedor, EntrenadoresFragment.newInstance());
                transaction.commit();
                regresar.setVisibility(View.GONE);
                escojerOtro.setVisibility(View.GONE);


            }
        });

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.entrenadorConfirmadoContenedor, DashboardFragment.newInstance());
                transaction.commit();
                regresar.setVisibility(View.GONE);
                escojerOtro.setVisibility(View.GONE);
            }
        });




        return view;
    }
}