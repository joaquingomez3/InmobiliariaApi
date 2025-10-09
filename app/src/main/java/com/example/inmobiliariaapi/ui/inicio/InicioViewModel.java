package com.example.inmobiliariaapi.ui.inicio;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class InicioViewModel extends AndroidViewModel {

    private MutableLiveData<MapaActual> mMapaActual;

    public InicioViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<MapaActual> getMMapaActual() {
        if (mMapaActual == null) {
            mMapaActual = new MutableLiveData<>();
        }
        return mMapaActual;
    }

    public void cargarMapa(){
        MapaActual mapaActual = new MapaActual();
        mMapaActual.setValue(mapaActual);
    }

    public class MapaActual implements OnMapReadyCallback {

        LatLng inmobiliaria = new LatLng(-33.1838813, -66.3138249);


        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {//cuando el mapa esté cargado y se esté renderizando
            MarkerOptions macadorInmobiliaria = new MarkerOptions();
            macadorInmobiliaria.position(inmobiliaria);
            macadorInmobiliaria.title("Inmobiliaria");



            googleMap.addMarker(macadorInmobiliaria);

            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            CameraPosition cameraPosition = new CameraPosition
                    .Builder()
                    .target(inmobiliaria)
                    .zoom(20)
                    .bearing(45)
                    .tilt(15)
                    .build();
            CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);

            googleMap.animateCamera(cameraUpdate);

        }
    }
}