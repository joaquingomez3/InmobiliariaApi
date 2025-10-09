package com.example.inmobiliariaapi.ui.inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.inmobiliariaapi.R;
import com.example.inmobiliariaapi.databinding.FragmentInicioBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class InicioFragment extends Fragment {

    private FragmentInicioBinding binding;
    private InicioViewModel mv;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mv = new ViewModelProvider(this).get(InicioViewModel.class);
        binding = FragmentInicioBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // 1. Observar el LiveData del ViewModel
        mv.getMMapaActual().observe(getViewLifecycleOwner(), mapaActual -> {
            SupportMapFragment mapFragment =
                    (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

            if (mapFragment != null) {
                // 2. Usar la instancia MapaActual (que es el OnMapReadyCallback) del ViewModel
                mapFragment.getMapAsync(mapaActual);
            }
        });

        // 3. Notificar al ViewModel que inicie la carga del mapa
        mv.cargarMapa();
    }
}