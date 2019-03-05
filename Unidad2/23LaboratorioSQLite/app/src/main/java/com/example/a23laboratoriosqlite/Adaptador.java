package com.example.a23laboratoriosqlite;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolderClientes> {

    ArrayList<Cliente> listaClientes;

    Context context;

    public Adaptador(ArrayList<Cliente> listaClientes, Context context){
        this.listaClientes = listaClientes;
        this.context = context;
    }

    @Override
    public ViewHolderClientes onCreateViewHolder(ViewGroup viewGroup, int i) {
        int layout = R.layout.vista;
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layout, null, false);
        return new ViewHolderClientes(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderClientes viewHolderClientes, int i) {

        viewHolderClientes.id.setText("ID: "+listaClientes.get(i).getIdCliente());
        viewHolderClientes.nombre.setText("Nombre: "+listaClientes.get(i).getNombre());
        viewHolderClientes.rfc.setText("RFC: "+listaClientes.get(i).getRfc());
        viewHolderClientes.cel.setText("Celular: "+listaClientes.get(i).getCel());
        viewHolderClientes.descripcion.setText("Descripcion: "+listaClientes.get(i).getDescripcion());
        viewHolderClientes.costo.setText("Costo: "+listaClientes.get(i).getCosto());


    }

    @Override
    public int getItemCount() {
        return listaClientes.size();
    }

    public class ViewHolderClientes extends RecyclerView.ViewHolder{

        TextView id, nombre, rfc, cel, descripcion, costo;

        public ViewHolderClientes(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            nombre = itemView.findViewById(R.id.nombre);
            rfc = itemView.findViewById(R.id.rfc);
            cel = itemView.findViewById(R.id.cel);
            descripcion = itemView.findViewById(R.id.descripcion);
            costo = itemView.findViewById(R.id.costo);
        }
    }
}
