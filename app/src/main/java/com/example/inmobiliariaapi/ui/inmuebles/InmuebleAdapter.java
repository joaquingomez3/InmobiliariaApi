package com.example.inmobiliariaapi.ui.inmuebles;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.inmobiliariaapi.R;
import com.example.inmobiliariaapi.modelos.Inmueble;
import com.example.inmobiliariaapi.request.ApiClient;

import java.util.List;

public class InmuebleAdapter extends RecyclerView.Adapter<InmuebleAdapter.ViewHolderInmueble> {


        private List<Inmueble> listado;
        private Context context;
        private LayoutInflater li;

        public InmuebleAdapter(List<Inmueble>listado,Context context,LayoutInflater li){
            this.context=context;
            this.listado=listado;
            this.li=li;
        }
        @NonNull
        @Override
        public ViewHolderInmueble onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView=li.inflate(R.layout.item,parent,false);
            return new ViewHolderInmueble(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolderInmueble holder, int position) {

            Inmueble inmuebleActual=listado.get(position);
            holder.direccion.setText("Direccion: "+inmuebleActual.getDireccion());
            holder.precio.setText("Precio: "+inmuebleActual.getValor());
            Glide.with(context)
                    .load(ApiClient.BASE_URL + inmuebleActual.getImagen())
                    .placeholder(R.drawable.logo)
                    .error("null")
                    .into(holder.foto);
            holder.cardView.setOnClickListener(v ->
            {
                Bundle bundle = new Bundle();
                bundle.putSerializable("inmueble", inmuebleActual);
                Navigation.findNavController((Activity)v.getContext(),R.id.nav_host_fragment_content_main).navigate(R.id.infoInmuebleFragment,bundle);
            });



        }

        @Override
        public int getItemCount() {
            return listado.size();
        }

        public class ViewHolderInmueble extends RecyclerView.ViewHolder{
            TextView direccion,precio;
            ImageView foto;

            CardView cardView ;

            public ViewHolderInmueble(@NonNull View itemView) {
                super(itemView);
                foto=itemView.findViewById(R.id.iv_foto_inmueble);
                precio=itemView.findViewById(R.id.tv_precio_inmueble);
                direccion=itemView.findViewById(R.id.tv_direccion_inmueble);
                cardView=itemView.findViewById(R.id.idCard);


            }
        }
}


