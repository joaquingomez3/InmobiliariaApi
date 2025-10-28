package com.example.inmobiliariaapi.ui.perfil;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.inmobiliariaapi.R;
import com.example.inmobiliariaapi.databinding.FragmentRecuperarBinding;

public class RecuperarFragment extends Fragment {

    private RecuperarViewModel mv;
    private FragmentRecuperarBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar la vista usando View Binding
        binding = FragmentRecuperarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Inicializar el ViewModel
        mv = new ViewModelProvider(this).get(RecuperarViewModel.class);

        // Observar cambios para mostrar mensajes (Toast o Snackbar)
        mv.getToastMessage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String message) {
                if (message != null) {
                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Observar si el cambio fue exitoso para navegar hacia atrás
        mv.getUpdateExitoso().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean exitoso) {
                if(exitoso){
                    // Navega de vuelta al perfil o a donde necesites ir
                    Navigation.findNavController(getView()).popBackStack();
                }
            }
        });


        // Configurar el listener del botón
        binding.btCambiarPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passActual = binding.etPasswordActual.getText().toString();
                String passNueva = binding.etPasswordNueva.getText().toString();
                String passConfirmar = binding.etConfirmarPassword.getText().toString();

                mv.cambiarPassword(passActual, passNueva, passConfirmar);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mv = new ViewModelProvider(this).get(RecuperarViewModel.class);
        // TODO: Use the ViewModel
    }

}