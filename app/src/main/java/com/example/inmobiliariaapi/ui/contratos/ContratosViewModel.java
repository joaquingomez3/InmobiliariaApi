package com.example.inmobiliariaapi.ui.contratos;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliariaapi.modelos.Alquiler;
import com.example.inmobiliariaapi.modelos.Inmueble;
import com.example.inmobiliariaapi.request.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContratosViewModel extends AndroidViewModel {

    private final MutableLiveData<List<Alquiler>> listaContratos = new MutableLiveData<>();
    public ContratosViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Alquiler>> getListaContratos() {
        return listaContratos;
    }


    public void obtenerContratosInmueble(int idInmueble) {
        ApiClient.InmobiliariaService api = ApiClient.getInmobiliariaService();
        String token = ApiClient.leerToken(getApplication());
        Call<List<Alquiler>> llamada = api.obtenerContratosInmueble("Bearer "+token, idInmueble);
                llamada.enqueue(new Callback<List<Alquiler>>() {
                    @Override
                    public void onResponse(Call<List<Alquiler>> call, Response<List<Alquiler>> response) {
                        if (response.isSuccessful()) {
                            listaContratos.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Alquiler>> call, Throwable t) {
                        Log.e("ContratosViewModel", "Error al obtener contratos", t);
                    }
                });
    }
}