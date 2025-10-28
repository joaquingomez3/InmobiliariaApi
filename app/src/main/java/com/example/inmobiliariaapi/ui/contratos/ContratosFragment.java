package com.example.inmobiliariaapi.ui.contratos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inmobiliariaapi.R;
import com.example.inmobiliariaapi.databinding.FragmentContratosBinding;
import com.example.inmobiliariaapi.databinding.FragmentInmueblesBinding;
import com.example.inmobiliariaapi.modelos.Alquiler;
import com.example.inmobiliariaapi.modelos.ContratoAdapter;
import com.example.inmobiliariaapi.ui.inmuebles.InmueblesViewModel;

import java.util.List;

public class ContratosFragment extends Fragment {

    private ContratosViewModel mv;
    private FragmentContratosBinding binding;

    public static ContratosFragment newInstance() {
        return new ContratosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mv = new ViewModelProvider(this).get(ContratosViewModel.class);

        binding = FragmentContratosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mv.getListaContratos().observe(getViewLifecycleOwner(), new Observer<List<Alquiler>>() {
            @Override
            public void onChanged(List<Alquiler> alquileres) {
                ContratoAdapter ca=new ContratoAdapter(alquileres,getContext(),getLayoutInflater());
                GridLayoutManager glm=new GridLayoutManager(getContext(),1, GridLayoutManager.VERTICAL,false);
                binding.lista2.setLayoutManager(glm);
                binding.lista2.setAdapter(ca);
            }
        });
      //  mv.obtenerContratosInmueble();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mv = new ViewModelProvider(this).get(ContratosViewModel.class);
        // TODO: Use the ViewModel
    }

}