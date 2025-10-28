package com.example.inmobiliariaapi.ui.perfil;

import android.app.Application;
import android.content.Context;
import android.telecom.Call;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliariaapi.request.ApiClient;

public class RecuperarViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<String> mToastMessage;
    private MutableLiveData<Boolean> mUpdateExitoso;



    public RecuperarViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
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

        // Aquí podrías añadir más validaciones (ej: longitud mínima de la nueva contraseña)

        // 2. Llamada a la API
        ApiClient.InmobiliariaService api = ApiClient.getInmobiliariaService();
        String token = ApiClient.leerToken(context);
        if (token == null || token.isEmpty()) {
            mToastMessage.setValue("Error de autenticación. Vuelva a iniciar sesión.");
            return;
        }


    }
}