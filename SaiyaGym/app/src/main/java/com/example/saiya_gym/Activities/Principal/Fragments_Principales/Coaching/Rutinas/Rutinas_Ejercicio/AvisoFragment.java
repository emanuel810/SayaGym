package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Rutinas_Ejercicio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saiya_gym.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AvisoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AvisoFragment extends Fragment {

    View view;

    public AvisoFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static AvisoFragment newInstance() {
        AvisoFragment fragment = new AvisoFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.aviso_escojer_entrenador_coaching, container, false);

        return view;
    }
}