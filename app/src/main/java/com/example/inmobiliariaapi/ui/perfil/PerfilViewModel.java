package com.example.inmobiliariaapi.ui.perfil;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

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

    private MutableLiveData<Propietario> mPropietario;
    private MutableLiveData<Boolean> mActivar;
    private MutableLiveData<String>  mGuardar;



    public PerfilViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Propietario> getPropietario() {
        if(mPropietario==null){
            mPropietario=new MutableLiveData<>();
        }
        return mPropietario;
    }

    public LiveData<Boolean> getMActivar() {
        if(mActivar==null){
            mActivar=new MutableLiveData<>();
        }
        return mActivar;
    }
    public LiveData<String> getMGuardar() {
        if(mGuardar==null){
            mGuardar=new MutableLiveData<>();
        }
        return mGuardar;
    }

    public void guardar(String palabra, String dni, String nombre, String apellido, String mail, String telefono){
        if(palabra.equals("Editar")){
            mActivar.setValue(true);
            mGuardar.setValue("Guardar");

        }else{
           if( dni.length() > 0 && nombre.length() > 0 && apellido.length() > 0 && mail.length() > 0 && telefono.length() > 0 ){
               Propietario p = new Propietario();
               p.setIdPropietario(mPropietario.getValue().getIdPropietario());
               p.setDni(dni);
               p.setNombre(nombre);
               p.setApellido(apellido);
               p.setEmail(mail);
               p.setTelefono(telefono);
               p.setClave(null);

               mActivar.setValue(false);
               mGuardar.setValue("Editar");

               ApiClient.InmobiliariaService api = ApiClient.getInmobiliariaService();
               String token = ApiClient.leerToken(getApplication());
               Call<Propietario> llamada = api.actualizarPerfil("Bearer "+token, p);
               llamada.enqueue(new Callback<Propietario>() {
                   @Override
                   public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                       if (response.isSuccessful()) {
                           Toast.makeText(getApplication(), "Propietario Actualizado", Toast.LENGTH_SHORT).show();

                       } else {
                           Toast.makeText(getApplication(), "No se pudo actualizar Propietario", Toast.LENGTH_SHORT).show();
                       }
                   }

                   @Override
                   public void onFailure(Call<Propietario> call, Throwable t) {
                     //  mText.setValue("Error de red");
                   }
               });
           }
        }

    }
    public void obtenerPerfil(){

        ApiClient.InmobiliariaService api = ApiClient.getInmobiliariaService();
        String token = ApiClient.leerToken(getApplication());
        Call<Propietario> llamada = api.obtenerPerfil("Bearer "+token);
        llamada.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if (response.isSuccessful()) {

                    mPropietario.postValue(response.body());

                } else {
                    Toast.makeText(getApplication(), "No se pudo obtener Propietario", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
              //  mText.setValue("Error de red");
            }
        });

    }



}