package com.example.primeiroprojetodaniel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuOpcoes extends AppCompatActivity implements View.OnClickListener {

    private Button buttonMenuCadastrarItem = null;
    private Button buttonMenuListarItens = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opcoes);

        initComponents();
    }

    private void initComponents() {
        buttonMenuCadastrarItem = (Button) findViewById(R.id.buttonMenuCadastroItem);
        buttonMenuCadastrarItem.setOnClickListener(this);

        buttonMenuListarItens = (Button) findViewById(R.id.buttonMenuListarItens);
        buttonMenuListarItens.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonMenuCadastroItem){
            Intent intent = new Intent(getApplicationContext(), CadastroItem.class);
            startActivity(intent);
        } else if (view.getId() == R.id.buttonMenuListarItens) {
            Intent intent = new Intent(getApplicationContext(), ListaItens.class);
            startActivity(intent);
        }
    }
}