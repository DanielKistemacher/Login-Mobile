package com.example.primeiroprojetodaniel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroItem extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextNomeItem = null;
    private EditText editTextQuantidadeItem = null;
    private Button buttonSalvarItem = null;

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
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonSalvarItem){
            ContentValues values = new ContentValues();
            values.put("descricao", editTextNomeItem.getText().toString());
            values.put("quantidade", editTextQuantidadeItem.getText().toString());
            //Opção 1
            long pos = bancoDados.insert("item", null, values);
            Toast.makeText(this, "Item " + editTextNomeItem.getText().toString() + " cadastrado! Item:" + pos, Toast.LENGTH_SHORT).show();
        }
    }
}