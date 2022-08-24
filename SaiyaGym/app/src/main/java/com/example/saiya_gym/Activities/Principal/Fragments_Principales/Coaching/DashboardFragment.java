package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Prendas.PrendasFragment;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Entrenadores.EntrenadoresFragment;
import com.example.saiya_gym.Activities.SQLite.BDentrenadores;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Avances.AgregarAvancesFragment;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Entrenadores.EntrenadorConfirmadoFragment;
import com.example.saiya_gym.R;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.RutinasFragment;
import com.example.saiya_gym.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private ImageView btnInstructor,btnPrenda,btnResumen,btnRutinas;

    private FragmentDashboardBinding binding;







    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        btnInstructor = root.findViewById(R.id.btnEntrenador);
        btnRutinas = root.findViewById(R.id.btnRutinas);
        btnResumen  = root.findViewById(R.id.btnResumen);
        btnPrenda = root.findViewById(R.id.btnPrenda);




        btnInstructor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BDentrenadores bDentrenadores = new BDentrenadores(getContext());
                String usuario = getActivity().getIntent().getExtras().getString("llave");
                if(bDentrenadores.verificarEntrenador(usuario)){
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.setReorderingAllowed(true);
                    transaction.replace(R.id.contenedorCoaching, EntrenadorConfirmadoFragment.newInstance("",""));
                    transaction.commit();
                }else {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.setReorderingAllowed(true);
                    transaction.replace(R.id.contenedorCoaching, EntrenadoresFragment.newInstance());
                    transaction.commit();
                }








            }
        });

        btnRutinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ir_rutinas();

            }
        });


        btnResumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ir_avances();
            }
        });

        btnPrenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ir_fragmentPrendas();
            }
        });
        return root;
    }

    private void ir_avances() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.contenedorCoaching, AgregarAvancesFragment.newInstance("",""));
        transaction.commit();
    }



    private void ir_rutinas() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.contenedorCoaching, RutinasFragment.newInstance());
        transaction.commit();
    }

    private void ir_fragmentPrendas() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.contenedorCoaching, PrendasFragment.newInstance());
        transaction.commit();
    }

    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();

        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}