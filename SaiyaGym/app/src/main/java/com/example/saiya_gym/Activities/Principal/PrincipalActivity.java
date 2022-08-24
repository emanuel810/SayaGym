package com.example.saiya_gym.Activities.Principal;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;


import com.example.saiya_gym.Activities.Inicio.ActivityIntegrantes;
import com.example.saiya_gym.Activities.Inicio.LoginActivity;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Entrenadores.Entrenadores;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Musculos.Musculos;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Inicio.Noticias.ContenidoNoticias.DetalleContenidoFragments;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Inicio.Noticias.Noticias;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Ventas.Ventas;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.iComunicaFragments;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Ventas.DetalleVenta;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Prendas.ContenidoPrendas.DetallePrenda;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Musculos.DetalleMusculo;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Entrenadores.DetalleEntrenadores;
import com.example.saiya_gym.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.saiya_gym.databinding.ActivityPrincipalBinding;

public class PrincipalActivity extends AppCompatActivity implements iComunicaFragments {

    private ActivityPrincipalBinding binding;
    DetalleContenidoFragments detalleContenidoFragments;
    DetalleVenta detalleVenta;
    DetallePrenda detallePrenda;
    DetalleMusculo detalleMusculo;
    DetalleEntrenadores detalleEntrenadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        binding = ActivityPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());





        //me recibe el dato y lo imprime en un toast para confirmar que recibe el dato
        Intent intent = getIntent();
        String mensaje = intent.getStringExtra("llave");






        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_principal);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }


    @Override
    public void enviarNoticia(Noticias noticias) {
        detalleContenidoFragments = new DetalleContenidoFragments();
        Bundle bundleenvio = new Bundle();
        bundleenvio.putSerializable("objeto",noticias);
        detalleContenidoFragments.setArguments(bundleenvio);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.inicioContenedor,detalleContenidoFragments);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void enviarPrenda(Ventas ventas) {
        detallePrenda = new DetallePrenda();
        Bundle bundleenvio = new Bundle();
        bundleenvio.putSerializable("objeto", ventas);
        detallePrenda.setArguments(bundleenvio);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.prendasContenedor,detallePrenda);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void enviarBebida(Ventas ventas) {
        detalleVenta = new DetalleVenta();
        Bundle bundleenvio = new Bundle();
        bundleenvio.putSerializable("objeto", ventas);
        detalleVenta.setArguments(bundleenvio);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedorMenu, detalleVenta);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void enviarSuplemento(Ventas ventas) {
        detalleVenta = new DetalleVenta();
        Bundle bundleenvio = new Bundle();
        bundleenvio.putSerializable("objeto", ventas);
        detalleVenta.setArguments(bundleenvio);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedorMenu, detalleVenta);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void enviarPecho(Musculos musculos) {
        detalleMusculo= new DetalleMusculo();
        Bundle bundleenvio = new Bundle();
        bundleenvio.putSerializable("objeto", musculos);
        detalleMusculo.setArguments(bundleenvio);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedorMusculos, detalleMusculo);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void enviarHombros(Musculos musculos) {
        detalleMusculo= new DetalleMusculo();
        Bundle bundleenvio = new Bundle();
        bundleenvio.putSerializable("objeto", musculos);
        detalleMusculo.setArguments(bundleenvio);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedorMusculos, detalleMusculo);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void enviarEspalda(Musculos musculos) {
        detalleMusculo= new DetalleMusculo();
        Bundle bundleenvio = new Bundle();
        bundleenvio.putSerializable("objeto", musculos);
        detalleMusculo.setArguments(bundleenvio);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedorMusculos, detalleMusculo);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void enviarBiceps(Musculos musculos) {
        detalleMusculo= new DetalleMusculo();
        Bundle bundleenvio = new Bundle();
        bundleenvio.putSerializable("objeto", musculos);
        detalleMusculo.setArguments(bundleenvio);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedorMusculos, detalleMusculo);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void enviarTriceps(Musculos musculos) {
        detalleMusculo= new DetalleMusculo();
        Bundle bundleenvio = new Bundle();
        bundleenvio.putSerializable("objeto", musculos);
        detalleMusculo.setArguments(bundleenvio);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedorMusculos, detalleMusculo);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void enviarAbdomen(Musculos musculos) {
        detalleMusculo= new DetalleMusculo();
        Bundle bundleenvio = new Bundle();
        bundleenvio.putSerializable("objeto", musculos);
        detalleMusculo.setArguments(bundleenvio);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedorMusculos, detalleMusculo);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void enviarPiernas(Musculos musculos) {
        detalleMusculo= new DetalleMusculo();
        Bundle bundleenvio = new Bundle();
        bundleenvio.putSerializable("objeto", musculos);
        detalleMusculo.setArguments(bundleenvio);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedorMusculos, detalleMusculo);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void enviarEntrenadores(Entrenadores entrenadores) {
        detalleEntrenadores= new DetalleEntrenadores();
        Bundle bundleenvio = new Bundle();
        bundleenvio.putSerializable("objeto", entrenadores);
        detalleEntrenadores.setArguments(bundleenvio);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedorEntrenadores, detalleEntrenadores);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }




    @Override
    public void enviarComida(Ventas ventas) {
        detalleVenta = new DetalleVenta();
        Bundle bundleenvio = new Bundle();
        bundleenvio.putSerializable("objeto", ventas);
        detalleVenta.setArguments(bundleenvio);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedorMenu, detalleVenta);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}