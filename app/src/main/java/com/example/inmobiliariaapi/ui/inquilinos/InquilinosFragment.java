package com.example.inmobiliariaapi.ui.inquilinos;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inmobiliariaapi.R;
import com.example.inmobiliariaapi.databinding.FragmentInmueblesBinding;
import com.example.inmobiliariaapi.databinding.FragmentInquilinosBinding;
import com.example.inmobiliariaapi.ui.inmuebles.InmueblesViewModel;

public class InquilinosFragment extends Fragment {

    private InquilinosViewModel mv;
    private FragmentInquilinosBinding binding;

    public static InquilinosFragment newInstance() {
        return new InquilinosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mv = new ViewModelProvider(this).get(InquilinosViewModel.class);

        binding = FragmentInquilinosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mv = new ViewModelProvider(this).get(InquilinosViewModel.class);
        // TODO: Use the ViewModel
    }

}