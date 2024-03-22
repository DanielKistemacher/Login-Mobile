package com.example.primeiroprojetodaniel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import com.example.primeiroprojetodaniel.R;
import com.example.primeiroprojetodaniel.apoio.DataBaseManager;

public class EditarItem extends AppCompatActivity {

    private EditText editTextIdItemEdit = null;
    private EditText editTextNomeItemEdit = null;
    private EditText editTextQtdItemEdit = null;
    private Button buttonSalvarItemEdit = null;
    private SQLiteDatabase bancoDados = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_item);

        bancoDados = new DataBaseManager(this, "baseDados", 1).getWritableDatabase();

        editTextIdItemEdit = (EditText) findViewById(R.id.editTextIdItemEdit);
        editTextIdItemEdit.setEnabled(false);
        editTextNomeItemEdit = (EditText) findViewById(R.id.editTextNomeItemEdit);
        editTextQtdItemEdit = (EditText) findViewById(R.id.editTextQtdItemEdit);
        buttonSalvarItemEdit = (Button) findViewById(R.id.buttonSalvarItemEdit);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String id = bundle.getString("id");
            int idInt = Integer.parseInt(id);
            String nome = bundle.getString("nome");
            String qtd = bundle.getString("quantidade");
            int qtdInt = Integer.parseInt(qtd);


            // Preencher os Edittext
            editTextIdItemEdit.setText(id);
            editTextNomeItemEdit.setText(nome);
            editTextQtdItemEdit.setText(qtd);

            buttonSalvarItemEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String novoNome = editTextNomeItemEdit.getText().toString();
                    String novaQtd = editTextQtdItemEdit.getText().toString();
                    int novaQtdInt = Integer.parseInt(novaQtd);

                    ContentValues values = new ContentValues();
                    values.put("descricao", editTextNomeItemEdit.getText().toString());
                    values.put("quantidade", editTextQtdItemEdit.getText().toString());
                    bancoDados.execSQL("UPDATE item SET descricao = '"+ novoNome+"', quantidade="+
                            novaQtdInt+" where id = "+idInt+";");
                    bancoDados.close();

                    Intent intent = new Intent(EditarItem.this, MenuOpcoes.class);
                    startActivity(intent);
                }
            });

        }
    }
}