package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Inicio;

import android.app.Activity;
import android.content.Context;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Inicio.Noticias.Noticias;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Inicio.Noticias.NoticiasAdapter;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.iComunicaFragments;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Inicio.Perfil.PerfilFragment;
import com.example.saiya_gym.R;
import com.example.saiya_gym.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    List<Noticias> noticiasList;
    RecyclerView recyclerView;
    ImageView perfil;
    private FragmentHomeBinding binding;
    NoticiasAdapter noticiasAdapter;
    TextView perfilTitulo;
    Activity actividad;
    iComunicaFragments interfaceComunicaFragments;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.listaDeNoticias);
        perfil = root.findViewById(R.id.perfilFoto);
        perfilTitulo = root.findViewById(R.id.perfiLTituloHome);

        perfilTitulo.setText(getActivity().getIntent().getExtras().getString("llave"));

        String usuarioVar = getActivity().getIntent().getExtras().getString("llave");



        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.inicioContenedor, PerfilFragment.newInstance(usuarioVar,""));
                transaction.commit();
                perfil.setVisibility(View.GONE);



            }
        });
        noticiasList = new ArrayList<>();
        init();
        mostrarData();



        return root;
    }

    private void mostrarData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        noticiasAdapter = new NoticiasAdapter(getContext(),noticiasList);
        recyclerView.setAdapter(noticiasAdapter);

        noticiasAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 interfaceComunicaFragments.enviarNoticia(noticiasList.get(recyclerView.getChildAdapterPosition(view)));
            }
        });
    }


    public void init(){
        noticiasList.add(new Noticias("¿Usar guantes te hace homosexual?","Segun los expertos dicen que si, ya que se lastiman sus manitas,Los guantes ofrecen un agarre más cómodo, permitiendo hacer los ejercicios de una forma un poco más agradable. De esta manera te permiten realizar ejercicios que no podrías hacer tan bien como sin guantes.",R.drawable.guantes));
        noticiasList.add(new Noticias("Tener Gymbro es de wecos","9 de cada 10 wecos los prefieren y hay una razon de ello,es un lugar que permite practicar deportes o hacer ejercicio en un recinto cerrado con varias máquinas y artículos deportivos a disposición de quienes lo visiten",R.drawable.companeros));
        noticiasList.add(new Noticias("Un poco de waro y ya queda","El men que pensaba ponerle 35lbs al press y apenas aguanta la barra, Bajo la supervisión de un médico deportivo o un fisioterapeuta, actúa con sentido común: Si tienes el brazo inmovilizado, sal a caminar o entrena las piernas en el gimnasio.",R.drawable.quebradura));
        noticiasList.add(new Noticias("Roni coleman se desepciona","Al ver que ni puedes hablarle a tu gymcrush,si eres una de esas personas que crees que encontrar el amor verdadero es algo difícil, no te preocupes, porque hay otras formas y lugares donde puedes conocer a alguien y encontrar el amor; y hoy vas a descubrir un sitio perfecto para ello, un gimnasio",R.drawable.ronicoleman));
        noticiasList.add(new Noticias("Covid en los gimnasios","Hoy en dia los gimnasios adquirieron una modalidad que para algunos,es un lugar que permite practicar deportes o hacer ejercicio en un recinto cerrado con varias máquinas y artículos deportivos a disposición de quienes lo visiten.",R.drawable.covid_gimnasio));
        noticiasList.add(new Noticias("Parejas FITNESS","Segun estudios, puedes encontrar al amor de tu vida en el gimnasio de tu localidad, si eres una de esas personas que crees que encontrar el amor verdadero es algo difícil, no te preocupes, porque hay otras formas y lugares donde puedes conocer a alguien y encontrar el amor",R.drawable.enamorarse));
        noticiasList.add(new Noticias("Cambia tu vida radicalmente","Llena tu cuerpo de energia, con esta rutina que te va a beneficiar radicalmente,es un lugar que permite practicar deportes o hacer ejercicio en un recinto cerrado con varias máquinas y artículos deportivos a disposición de quienes lo visiten.",R.drawable.gordo));
        noticiasList.add(new Noticias("Calambres en los entrenamientos","La forma más eficaz de evitarlos es estirarse bienes un lugar que permite practicar deportes o hacer ejercicio en un recinto cerrado con varias máquinas y artículos deportivos a disposición de quienes lo visiten.",R.drawable.calambres));


    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            this.actividad = (Activity)context;
            interfaceComunicaFragments =(iComunicaFragments) this.actividad;
        }
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
}