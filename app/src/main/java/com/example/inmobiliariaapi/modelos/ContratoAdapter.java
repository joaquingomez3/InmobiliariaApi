package com.example.inmobiliariaapi.modelos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.inmobiliariaapi.R;
import com.example.inmobiliariaapi.request.ApiClient;

import java.util.List;

public class ContratoAdapter extends RecyclerView.Adapter<ContratoAdapter.ViewHolderInquilino> {
    private List<Alquiler> listado;
    private Context context;
    private LayoutInflater li;

    public ContratoAdapter(List<Alquiler> listado, Context context, LayoutInflater li) {
        this.listado = listado;
        this.context = context;
        this.li = li;
    }

    @NonNull
    @Override
    public ContratoAdapter.ViewHolderInquilino onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=li.inflate(R.layout.item_inquilino,parent,false);
        return new ContratoAdapter.ViewHolderInquilino(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContratoAdapter.ViewHolderInquilino holder, int position) {

        Alquiler contrato=listado.get(position);

        //holder.direccion.setText("Precio: "+contrato.getValor());
       /* Glide.with(context)
                .load(ApiClient.BASE_URL + contrato.getImagen())
                .placeholder(R.drawable.logo)
                .error("null")
                .into(holder.foto);*/
        holder.button.setOnClickListener(v ->
        {
            Bundle bundle = new Bundle();
            bundle.putSerializable("inquilino", contrato);
            Navigation.findNavController((Activity)v.getContext(),R.id.nav_host_fragment_content_main).navigate(R.id.infoInmuebleFragment,bundle);
        });



    }

    @Override
    public int getItemCount() {
        return listado.size();
    }

    public class ViewHolderInquilino extends RecyclerView.ViewHolder{
        TextView direccion;
        ImageView foto;

        Button button;

        public ViewHolderInquilino(@NonNull View itemView) {
            super(itemView);
            foto=itemView.findViewById(R.id.iv_foto_inmueble);
            direccion=itemView.findViewById(R.id.tvDireccionContrato);

            button=itemView.findViewById(R.id.btnVer);


        }
    }
}
