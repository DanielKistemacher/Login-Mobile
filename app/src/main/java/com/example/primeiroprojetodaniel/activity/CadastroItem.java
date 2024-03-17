package com.example.primeiroprojetodaniel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.primeiroprojetodaniel.R;
import com.example.primeiroprojetodaniel.apoio.DataBaseManager;

public class CadastroItem extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextNomeItem = null;
    private EditText editTextQuantidadeItem = null;
    private Button buttonSalvarItem = null;
    private Button buttonConsultarItens = null;

    private SQLiteDatabase bancoDados = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        initComponents();

        bancoDados = new DataBaseManager(this, "baseDados", 1).getWritableDatabase();
    }

    private void initComponents(){
        editTextNomeItem = (EditText) findViewById(R.id.editTextNomeItem);
        editTextQuantidadeItem =  (EditText) findViewById(R.id.editTextQuantidadeItem);
        buttonSalvarItem =  (Button) findViewById(R.id.buttonSalvarItem);
        buttonSalvarItem.setOnClickListener(this);
        buttonConsultarItens = (Button) findViewById(R.id.buttonVoltarMenu);
        buttonConsultarItens.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonSalvarItem){

            String nome = editTextNomeItem.getText().toString();
            String quantidade = editTextQuantidadeItem.getText().toString();

            if (nome.equals("") || quantidade.equals("")){
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else {
                ContentValues values = new ContentValues();
                values.put("descricao", editTextNomeItem.getText().toString());
                values.put("quantidade", editTextQuantidadeItem.getText().toString());

                long pos = bancoDados.insert("item", null, values);
                Toast.makeText(this, "Item " + editTextNomeItem.getText().toString() + " cadastrado! Item:" + pos, Toast.LENGTH_SHORT).show();

                //Atividade 03
                if (pos%10 == 0) {
                    Toast.makeText(this, "A quantidade de itens inseridos é múltiplo de 10", Toast.LENGTH_LONG).show();
                }

                editTextNomeItem.setText("");
                editTextQuantidadeItem.setText("");
                editTextNomeItem.requestFocus();
            }
        } else if (view.getId() == R.id.buttonVoltarMenu) {
            Intent intent = new Intent(getApplicationContext(), MenuOpcoes.class);
            startActivity(intent);
        }
    }
}