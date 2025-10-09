package com.example.inmobiliariaapi.modelos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/*public class InmuebleAdapter extends RecyclerView.Adapter<InmuebleAdapter.InmuebleAdapter.ViewHolderInmueble> {


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
            holder.superficie.setText("Superficie: "+inmuebleActual.getSuperficie());
            holder.precio.setText("Precio: "+inmuebleActual.getPrecio());
            holder.foto.setImageResource(inmuebleActual.getFoto());


        }

        @Override
        public int getItemCount() {
            return listado.size();
        }

        public class ViewHolderInmueble extends RecyclerView.ViewHolder{
            TextView direccion,superficie,precio;
            ImageView foto;

            public ViewHolderInmueble(@NonNull View itemView) {
                super(itemView);
                direccion=itemView.findViewById(R.id.tvDireccion);
                superficie=itemView.findViewById(R.id.tvSuperficie);
                precio=itemView.findViewById(R.id.tvPrecio);
                foto=itemView.findViewById(R.id.foto);
            }
        }
    }
}*/

