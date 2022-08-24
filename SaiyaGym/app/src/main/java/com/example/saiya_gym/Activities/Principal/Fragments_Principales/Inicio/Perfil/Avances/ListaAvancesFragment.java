package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Inicio.Perfil.Avances;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.saiya_gym.Activities.Inicio.TallasFinales.TallasF;
import com.example.saiya_gym.Activities.Inicio.TallasIniciales.TallasInicialesAdapter;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Inicio.Perfil.PerfilFragment;
import com.example.saiya_gym.Activities.SQLite.BDtallasFinales;
import com.example.saiya_gym.Activities.SQLite.BDtallasIniciales;
import com.example.saiya_gym.R;


public class ListaAvancesFragment extends Fragment {

    private RecyclerView recyclerView;
    private TallasInicialesAdapter cursoAdapter;
    private TextView hombros,pecho,espalda,brazos,abdomen,pierna;

    Button btnRegresar;
    View view;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListaAvancesFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ListaAvancesFragment newInstance(String param1, String param2) {
        ListaAvancesFragment fragment = new ListaAvancesFragment();
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
        view = inflater.inflate(R.layout.fragment_lista_avances, container, false);

        btnRegresar = view.findViewById(R.id.btnRegresarInicio);

        hombros = view.findViewById(R.id.hombroMeta);
        pecho = view.findViewById(R.id.pechoMeta);
        espalda = view.findViewById(R.id.espaldaMeta);
        brazos = view.findViewById(R.id.brazosMeta);
        abdomen  = view.findViewById(R.id.abdomenMeta);
        pierna = view.findViewById(R.id.piernaMeta);




        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.contenedorAvancesLista, PerfilFragment.newInstance("",""));
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
            }
        });

        recyclerView = view.findViewById(R.id.lista_de_avances);

        String usuairo=(getActivity().getIntent().getExtras().getString("llave"));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        BDtallasIniciales bDtallasIniciales = new BDtallasIniciales(getContext());
        cursoAdapter = new TallasInicialesAdapter(bDtallasIniciales.mostrarTallas(usuairo));
        recyclerView.setAdapter(cursoAdapter);


        BDtallasFinales bDtallasFinales = new BDtallasFinales(getContext());

        TallasF tallasF = new TallasF();

        bDtallasFinales.buscarTallasFinales(tallasF,usuairo);


        hombros.setText(tallasF.getHombros());
        pecho.setText(tallasF.getPecho());
        espalda.setText(tallasF.getEspalda());
        brazos.setText(tallasF.getBrazos());
        abdomen.setText(tallasF.getAbdomen());
        pierna.setText(tallasF.getPierna());


        return view;

    }

}