package com.example.primeiroprojetodaniel.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.example.primeiroprojetodaniel.R;
import com.example.primeiroprojetodaniel.adapter.ItemAdapter;
import com.example.primeiroprojetodaniel.apoio.DataBaseManager;
import com.example.primeiroprojetodaniel.apoio.DatabaseHelper;
import com.example.primeiroprojetodaniel.apoio.Item;
import java.util.ArrayList;
import java.util.List;

public class ListaItens extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private List<Item> listaItens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_itens);

        recyclerView = findViewById(R.id.recyclerView);
    }

    public void carregarListaItens(){
        //Pegar tarefas do BD
        //DataBaseManager db = new DataBaseManager(this, "baseDados", 1);
        DatabaseHelper db = new DatabaseHelper(this);
        listaItens = db.consultaTodosItens();


        //Configurar o recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(itemAdapter);
    }

    @Override
    protected void onStart() {
        carregarListaItens();
        super.onStart();
    }
}