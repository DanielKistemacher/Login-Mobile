package com.example.primeiroprojetodaniel.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primeiroprojetodaniel.R;
import com.example.primeiroprojetodaniel.adapter.ItemAdapter;
import com.example.primeiroprojetodaniel.apoio.DatabaseHelper;
import com.example.primeiroprojetodaniel.apoio.Item;

import java.util.ArrayList;

public class ListaItens extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Item> itemList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_itens);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList.addAll(new DatabaseHelper(this).consultaTodosItens());

        ItemAdapter itemAdapter = new ItemAdapter(itemList);
        recyclerView.setAdapter(itemAdapter);

        itemAdapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
            @Override
            public void onEditClick(int position, Item itemAntigo) {
                // abrir tela
                // preencher com o item, todos os campos da tela
                // Item novoItem = itemDaTela;

//                new DatabaseHelper(ListaItens.this).editaItem(item);
                itemAdapter.notifyDataSetChanged();

                // LINK PARA EDITAR: https://chat.openai.com/share/2129cd0d-7319-47ca-86b2-72435442dea0
            }

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDeleteClick(int position, Item item) {
                new DatabaseHelper(ListaItens.this).deletaItem(item.getId());
                //itemAdapter.notifyDataSetChanged();
                finish();
                startActivity(getIntent());
            }
        });
    }
}
