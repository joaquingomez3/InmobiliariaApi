package com.example.inmobiliariaapi.ui.login;

import static androidx.lifecycle.AndroidViewModel_androidKt.getApplication;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliariaapi.LoginActivity;
import com.example.inmobiliariaapi.MainActivity;
import com.example.inmobiliariaapi.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends AndroidViewModel {


    private MutableLiveData<String> mMensaje ;

    public LiveData<String> getMensaje() {
        if (mMensaje == null) {
            mMensaje = new MutableLiveData<>();
        }

        return mMensaje;
    }

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public void login(String email, String clave) {
        ApiClient.InmobiliariaService api = ApiClient.getInmobiliariaService();
        Call<String> llamada = api.login(email, clave);
        llamada.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String token = response.body();
                    ApiClient.guardarToken(getApplication(), token);
                    mMensaje.postValue("Bienvenido");
                    Intent intent = new Intent(getApplication(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplication().startActivity(intent);
                } else
                    mMensaje.postValue("Usuario y/o contraseña Incorrecta; reintente");
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                mMensaje.postValue("Error de Servidor");

            }
        });
    }
}