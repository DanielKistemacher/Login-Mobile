package com.example.primeiroprojetodaniel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primeiroprojetodaniel.R;
import com.example.primeiroprojetodaniel.apoio.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private List<Item> listaItens;

    public ItemAdapter(List<Item> lista) {
        this.listaItens = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_item_adapter, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = listaItens.get(position);
        holder.item.setText(item.getNomeItem());
    }

    @Override
    public int getItemCount() {
        return this.listaItens.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView item;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            item = itemView.findViewById(R.id.textItem);
        }
    }
}
