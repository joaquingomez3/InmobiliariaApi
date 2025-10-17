package com.example.inmobiliariaapi.ui.inmuebles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.inmobiliariaapi.R;
import com.example.inmobiliariaapi.modelos.Inmueble;

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
            String urls = "https://inmobiliariaulp-amb5hwfqaraweyga.canadacentral-01.azurewebsites.net";
            Inmueble inmuebleActual=listado.get(position);
            holder.direccion.setText("Direccion: "+inmuebleActual.getDireccion());
            holder.precio.setText("Precio: "+inmuebleActual.getValor());
            Glide.with(context)
                    .load(urls + inmuebleActual.getImagen())
                    .placeholder(R.drawable.logo)
                    .error("null")
                    .into(holder.foto);



        }

        @Override
        public int getItemCount() {
            return listado.size();
        }

        public class ViewHolderInmueble extends RecyclerView.ViewHolder{
            TextView direccion,precio;
            ImageView foto;

            public ViewHolderInmueble(@NonNull View itemView) {
                super(itemView);
                foto=itemView.findViewById(R.id.iv_foto_inmueble);
                precio=itemView.findViewById(R.id.tv_precio_inmueble);
                direccion=itemView.findViewById(R.id.tv_direccion_inmueble);


            }
        }
}


