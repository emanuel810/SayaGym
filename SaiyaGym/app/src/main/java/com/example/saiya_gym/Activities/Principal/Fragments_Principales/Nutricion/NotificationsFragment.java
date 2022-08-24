package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Nutricion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Nutricion.Bebida.BebidasFragment;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Nutricion.Comidas.Fragment_comidas;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Nutricion.Dieta.Aviso_Dieta;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Nutricion.Dieta.DietaEntrenadorFragment;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Nutricion.Dieta.DietaFragment;
import com.example.saiya_gym.Activities.SQLite.BDentrenadores;
import com.example.saiya_gym.R;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Nutricion.Suplemento.SuplementoFragment;
import com.example.saiya_gym.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private ImageView btnComida,btnBebida,btnSuplemento,btnPedido;
    private TextView txcomida,txbebida,txsuplemento,txpedido;
    private FragmentNotificationsBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        txbebida = root.findViewById(R.id.txtbebida);
        txcomida = root.findViewById(R.id.txtcomida);
        txsuplemento = root.findViewById(R.id.txtsuplementos);
        txpedido = root.findViewById(R.id.txtdieta);

        btnBebida = root.findViewById(R.id.btnBebida);
        btnComida = root.findViewById(R.id.btnComida);
        btnSuplemento = root.findViewById(R.id.btnSuplemento);
        btnPedido = root.findViewById(R.id.btnPedidos);


        btnComida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ir_fragmentNutricion();
            }
        });

        btnBebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ir_fragmentBebida();
            }
        });

        btnSuplemento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ir_fragmentSuplemento();
            }
        });

        btnPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ir_fragmentDieta();
                final BDentrenadores bDentrenadores = new BDentrenadores(getContext());
                String usuario = getActivity().getIntent().getExtras().getString("llave");
                if(bDentrenadores.verificarEntrenador(usuario)){
                    ir_dietaEntrenador();
                }else {
                    modificaciones_dieta();
                }
            }
        });

        return root;
    }

    private void ir_dietaEntrenador() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.dietaContenedor, DietaEntrenadorFragment.newInstance(""," "));
        transaction.commit();
    }

    private void ir_fragmentSuplemento() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.contenedorNutricion, SuplementoFragment.newInstance());
        transaction.commit();
    }

    private void ir_fragmentBebida() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.contenedorNutricion, BebidasFragment.newInstance());
        transaction.commit();
    }

    private void modificaciones_dieta() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.dietaContenedor, Aviso_Dieta.newInstance());
        transaction.commit();

    }

    private void ir_fragmentDieta() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.contenedorNutricion, DietaFragment.newInstance("",""));
        transaction.commit();
    }


    public static NotificationsFragment newInstance() {
        NotificationsFragment fragment = new NotificationsFragment();

        return fragment;
    }

    private void ir_fragmentNutricion() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.contenedorNutricion, Fragment_comidas.newInstance());
        transaction.commit();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}