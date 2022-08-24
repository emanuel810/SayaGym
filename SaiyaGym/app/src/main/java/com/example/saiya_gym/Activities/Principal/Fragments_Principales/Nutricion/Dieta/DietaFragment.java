package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Nutricion.Dieta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Nutricion.NotificationsFragment;
import com.example.saiya_gym.R;


public class DietaFragment extends Fragment {


    View view;
    Button btnRegresar;


    public DietaFragment() {
        // Required empty public constructor
    }


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    public static DietaFragment newInstance(String param1, String param2) {
        DietaFragment fragment = new DietaFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_dieta, container, false);
        btnRegresar = view.findViewById(R.id.btnRregresarNutricion);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.listadoDeDietasContenedor, NotificationsFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
            }
        });

        return view;
    }
}