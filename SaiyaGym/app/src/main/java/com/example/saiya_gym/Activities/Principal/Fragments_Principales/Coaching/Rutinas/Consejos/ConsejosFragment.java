package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Consejos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.RutinasFragment;
import com.example.saiya_gym.R;


public class ConsejosFragment extends Fragment {

    View view;
    Button btnRegresar;

    public ConsejosFragment() {
        // Required empty public constructor
    }


    public static ConsejosFragment newInstance() {
        ConsejosFragment fragment = new ConsejosFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_consejos, container, false);

        btnRegresar = view.findViewById(R.id.btnConsejosRegresar);


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.consejosContenedor, RutinasFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
            }
        });
        return view;
    }
}