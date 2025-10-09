package com.example.inmobiliariaapi.ui.perfil;

import android.app.Application;
import android.util.Log;

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

public class PerfilViewModel extends AndroidViewModel {

    private MutableLiveData<Propietario> propietario;



    public PerfilViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Propietario> getPropietario() {
        if(propietario==null){
            propietario=new MutableLiveData<>();
        }
        return propietario;
    }


    public void obtenerPerfil(){

        ApiClient.InmobiliariaService api = ApiClient.getInmobiliariaService();
        String token = ApiClient.leerToken(getApplication());
        Call<Propietario> llamada = api.perfil(token);
        llamada.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if (response.isSuccessful()) {
                    Log.d("PerfilViewModel", "Perfil obtenido: " + response.body());
                    propietario.setValue(response.body());

                } else {
                 //   mText.setValue("Error al obtener el perfil");
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
              //  mText.setValue("Error de red");
            }
        });

    }



}