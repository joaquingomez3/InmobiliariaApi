package com.example.inmobiliariaapi.ui.contratos;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliariaapi.modelos.Alquiler;
import com.example.inmobiliariaapi.modelos.Inquilino;
import com.example.inmobiliariaapi.modelos.Pago;
import com.example.inmobiliariaapi.request.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoContratoViewModel extends AndroidViewModel {
    private MutableLiveData<Alquiler> mContrato = new MutableLiveData<>();
    private MutableLiveData<Integer> mIdContrato = new MutableLiveData<>();

    public InfoContratoViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<Alquiler> getmContrato() {
        return mContrato;
    }

    public LiveData<Integer> getmIdContrato() {
        return mIdContrato;
    }



    public void obtenerContrato(Bundle idInmuebleBundle) {
        int idInmueble = idInmuebleBundle.getInt("id_inmueble");
        ApiClient.InmobiliariaService api = ApiClient.getInmobiliariaService();
        String token = ApiClient.leerToken(getApplication());
        Call<Alquiler> llamada = api.contratoPorInmueble("Bearer " + token, idInmueble);
        llamada.enqueue(new Callback<Alquiler>() {
            @Override
            public void onResponse(Call<Alquiler> call, Response<Alquiler> response) {
                if (response.isSuccessful()) {
                    mContrato.setValue(response.body());
                    mIdContrato.setValue(response.body().getIdContrato());
                } else {
                    Toast.makeText(getApplication(), "Error al obtener inquilino", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Alquiler> call, Throwable t) {
                Log.e("API_ERROR", "Error al obtener inquilino: " + t.getMessage(), t);
                mContrato.setValue(null);
            }
        });
    }


}