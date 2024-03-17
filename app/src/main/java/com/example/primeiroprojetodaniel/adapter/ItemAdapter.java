package com.example.primeiroprojetodaniel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primeiroprojetodaniel.R;
import com.example.primeiroprojetodaniel.apoio.Item;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private ArrayList<Item> itemList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onEditClick(int position, Item item);

        void onDeleteClick(int position, Item item);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public ItemAdapter(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_adapter, parent, false);
        return new ItemViewHolder(view, listener, itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final Item currentItem = itemList.get(position);
        holder.textView.setText(currentItem.getNomeItem() + "(" + currentItem.getQuantidadeItem() + ")");
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public Button buttonEdit;
        public Button buttonDelete;

        public ItemViewHolder(@NonNull View itemView, final OnItemClickListener listener, final ArrayList<Item> itemList) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewItem);
            buttonEdit = itemView.findViewById(R.id.buttonEdit);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);

            buttonEdit.setOnClickListener(event -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onEditClick(position, itemList.get(position));
                    }
                }
            });

            buttonDelete.setOnClickListener(event -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onDeleteClick(position, itemList.get(position));
                    }
                }
            });
        }
    }
}
