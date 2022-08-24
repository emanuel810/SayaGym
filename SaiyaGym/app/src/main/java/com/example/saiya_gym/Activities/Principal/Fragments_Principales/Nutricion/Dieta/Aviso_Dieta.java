package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Nutricion.Dieta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.saiya_gym.R;

public class Aviso_Dieta extends Fragment {
    View view;

    public static Aviso_Dieta newInstance() {
        Aviso_Dieta fragment = new Aviso_Dieta();

        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.aviso_escojer_entrenador_nutricion, container, false);
        return  view;
    }
}
