package com.example.inmobiliariaapi.ui.contratos;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inmobiliariaapi.R;
import com.example.inmobiliariaapi.databinding.FragmentInfoContratoBinding;
import com.example.inmobiliariaapi.databinding.FragmentVerInquilinoBinding;
import com.example.inmobiliariaapi.ui.inquilinos.VerInquilinoViewModel;

public class InfoContratoFragment extends Fragment {

    private InfoContratoViewModel mv;
    private FragmentInfoContratoBinding binding;

    public static InfoContratoFragment newInstance() {
        return new InfoContratoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mv = new ViewModelProvider(this).get(InfoContratoViewModel.class);

        binding = FragmentInfoContratoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mv.getmContrato().observe(getViewLifecycleOwner(), contrato -> {
           binding.tvCodigoContrato.setText(String.valueOf(contrato.getIdContrato()));
           binding.tvFechaInicio.setText(contrato.getFechaInicio());
           binding.tvFechaFin.setText(contrato.getFechaFinalizacion());
           binding.tvMonto.setText(String.valueOf(contrato.getMontoAlquiler()));
           binding.tvInquilino.setText(contrato.getInquilino().getNombre());
           binding.tvInmueble.setText(contrato.getInmueble().getDireccion());


        });
        mv.obtenerContrato(getArguments());

        binding.btnPagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.getmIdContrato().observe(getViewLifecycleOwner(), idContrato -> {

                    Bundle bundle = new Bundle();
                    bundle.putInt("idContrato", idContrato);
                    Navigation.findNavController(v).navigate(R.id.detallePagosFragment, bundle);

                });
            }
        });




        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mv = new ViewModelProvider(this).get(InfoContratoViewModel.class);
        // TODO: Use the ViewModel
    }

}