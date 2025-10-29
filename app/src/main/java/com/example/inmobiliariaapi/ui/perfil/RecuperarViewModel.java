package com.example.inmobiliariaapi.ui.perfil;

import android.app.Application;
import android.content.Context;


import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliariaapi.modelos.Propietario;
import com.example.inmobiliariaapi.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecuperarViewModel extends AndroidViewModel {

    private MutableLiveData<String> mToastMessage;
    private MutableLiveData<Boolean> mUpdateExitoso;



    public RecuperarViewModel(@NonNull Application application) {
        super(application);

        mToastMessage = new MutableLiveData<>();
        mUpdateExitoso = new MutableLiveData<>();

    }

    public LiveData<String> getToastMessage() {
        return mToastMessage;
    }

    public LiveData<Boolean> getUpdateExitoso() {
        return mUpdateExitoso;
    }


    public void cambiarPassword(String passActual, String passNueva, String passConfirmar) {

        // 1. Validaciones
        if (passActual.isEmpty() || passNueva.isEmpty() || passConfirmar.isEmpty()) {
            mToastMessage.setValue("Todos los campos son obligatorios.");
            return;
        }

        if (!passNueva.equals(passConfirmar)) {
            mToastMessage.setValue("Las nuevas contraseñas no coinciden.");
            return;
        }



        // 2. Llamada a la API
        ApiClient.InmobiliariaService api = ApiClient.getInmobiliariaService();
        String token = ApiClient.leerToken(getApplication());
        Call<Propietario> llamada = api.cambiarPassword("Bearer "+token, passActual, passNueva);
        llamada.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if (response.isSuccessful()) {
                    mUpdateExitoso.setValue(true);
                } else {
                    mToastMessage.setValue("Error al cambiar la contraseña.");
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
                mToastMessage.setValue("Error al cambiar la contraseña.");
            }
        });

    }
}