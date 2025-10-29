package com.example.inmobiliariaapi.ui.login;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inmobiliariaapi.LoginActivity;
import com.example.inmobiliariaapi.MainActivity;
import com.example.inmobiliariaapi.R;
import com.example.inmobiliariaapi.databinding.ActivityLoginBinding;
import com.example.inmobiliariaapi.databinding.FragmentInicioBinding;
import com.example.inmobiliariaapi.databinding.FragmentLoginBinding;
import com.example.inmobiliariaapi.ui.inicio.InicioFragment;
import com.example.inmobiliariaapi.ui.inicio.InicioViewModel;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private LoginViewModel mv;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mv = new ViewModelProvider(this).get(LoginViewModel.class);

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        binding.btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.login(binding.etEmail.getText().toString(), binding.etContrasenia.getText().toString());

            }
        });

        mv.getMensaje().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvMensaje.setVisibility(View.VISIBLE);
                binding.tvMensaje.setText(s);
            }
        });



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}