package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Avances;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.DashboardFragment;
import com.example.saiya_gym.Activities.SQLite.BDtallasIniciales;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Inicio.Perfil.Avances.ListaAvancesFragment;
import com.example.saiya_gym.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AgregarAvancesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


public class AgregarAvancesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView ethombros,etespalda,etpecho,etbrazo,etabdomen,etpierna;
    private View view;
    Button btnRegresar,btnAgregar,btnVerAvances;
    public AgregarAvancesFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static AgregarAvancesFragment newInstance(String param1, String param2) {
        AgregarAvancesFragment fragment = new AgregarAvancesFragment();
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
        view = inflater.inflate(R.layout.fragment_agregar_avances, container, false);

        ethombros = view.findViewById(R.id.hombrosAvance);
        etespalda = view.findViewById(R.id.espaldaAvance);
        etpecho = view.findViewById(R.id.pechoAvance);
        etbrazo = view.findViewById(R.id.brazoAvance);
        etabdomen = view.findViewById(R.id.abdomenAvance);
        etpierna = view.findViewById(R.id.piernaAvance);
        final BDtallasIniciales bDtallasIniciales = new BDtallasIniciales(getContext());

        String hombrosinicial = ethombros.getText().toString();
        String pechoInicial = etpecho.getText().toString();
        String espaldaInicial = etespalda.getText().toString();
        String brazosInicial = etbrazo.getText().toString();
        String abdomenInicial = etabdomen.getText().toString();
        String piernaInicial = etpierna.getText().toString();

        btnRegresar =view.findViewById(R.id.btnRegresar);
        btnAgregar= view.findViewById(R.id.btnAgregar);
        btnVerAvances = view.findViewById(R.id.btnVerAvances);


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.avancesAgregarContenedord, DashboardFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
                btnAgregar.setVisibility(View.GONE);
                btnVerAvances.setVisibility(View.GONE);
            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String hombrosinicial = ethombros.getText().toString();
                String pechoInicial = etpecho.getText().toString();
                String espaldaInicial = etespalda.getText().toString();
                String brazosInicial = etbrazo.getText().toString();
                String abdomenInicial = etabdomen.getText().toString();
                String piernaInicial = etpierna.getText().toString();
                if(hombrosinicial.isEmpty()){
                    ethombros.setError("Campo Requerido");
                }else if(pechoInicial.isEmpty()){
                    etpecho.setError("Campo Requerido");
                }else if(espaldaInicial.isEmpty()){
                    etespalda.setError("Campo Requerido");
                }else if(brazosInicial.isEmpty()){
                    etbrazo.setError("Campo Requerido");
                }else if(abdomenInicial.isEmpty()){
                    etabdomen.setError("Campo Requerido");
                }else if(piernaInicial.isEmpty()){
                    etpierna.setError("Campo Requerido");
                }else{
                    String usuairo=(getActivity().getIntent().getExtras().getString("llave"));
                    bDtallasIniciales.agregarTallasIniciales(usuairo,hombrosinicial,pechoInicial,espaldaInicial,brazosInicial,abdomenInicial,piernaInicial);
                    Toast.makeText(getContext(), "Se agrego correctamente", Toast.LENGTH_SHORT).show();
                    ethombros.setText("");
                    etpecho.setText("");
                    etbrazo.setText("");
                    etespalda.setText("");
                    etabdomen.setText("");
                    etpierna.setText("");
                }
            }
        });


        btnVerAvances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.avancesAgregarContenedord, ListaAvancesFragment.newInstance("",""));
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
                btnRegresar.setVisibility(View.GONE);
                btnAgregar.setVisibility(View.GONE);
                btnVerAvances.setVisibility(View.GONE);
            }
        });

        return view;
    }
}