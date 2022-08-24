package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Inicio.Noticias.ContenidoNoticias;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Inicio.Noticias.Noticias;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Inicio.HomeFragment;
import com.example.saiya_gym.R;

public class DetalleContenidoFragments extends Fragment {

    TextView nombre,contenido;
    ImageView imagen;
    Button btnRegresar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detalle_noticia,container,false);

        nombre = view.findViewById(R.id.titulo_detalle);
        contenido = view.findViewById(R.id.contenido_detalle);
        imagen = view.findViewById(R.id.imagen_detalle);
        btnRegresar = view.findViewById(R.id.btnRegresarPrincipal);
        Bundle objetoNoticia = getArguments();
        Noticias noticia = null;

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.otroContenedor, HomeFragment.newInstance());
                transaction.commit();
                btnRegresar.setVisibility(View.GONE);
            }
        });




        if(objetoNoticia!=null){
            noticia = (Noticias) objetoNoticia.getSerializable("objeto");

            nombre.setText(noticia.getTitulo());
            contenido.setText((noticia.getContenido()));
            imagen.setImageResource(noticia.getImagenId());

        }



        return view;
    }
}
