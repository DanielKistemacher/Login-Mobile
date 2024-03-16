package com.example.primeiroprojetodaniel;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private String[] usuarios = {"joao", "maria", "jose"};
    private String[] senhas = {"gremio", "inter", "house"};
    private String[] dicasSenha = {"Melhor time do RS.", "Pior time do RS.", "Casa em inglês"};

    EditText usuarioDigitado;
    EditText senhadigitada;
    Button botaoEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioDigitado = findViewById(R.id.editTextLogin);
        senhadigitada = findViewById(R.id.editTextSenha);
        botaoEntrar = findViewById(R.id.buttonEntrar);

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Método que irá autenticar o login
                //autenticarLogin(usuarioDigitado.getText().toString(), senhadigitada.getText().toString());
                Intent intent = new Intent (getApplicationContext(), CadastroItem.class);
                startActivity(intent);
            }
        });
    }

    private void autenticarLogin(String usuarioDigitado, String senhaDigitada){
        boolean achou = false;
        int posicao = 0;

        if (usuarioDigitado.equals("") || senhaDigitada.equals("")) {
            mostrarToast("Preencha usuário e senha",1);
        } else {
            //Percorrendo lista de usuários
            for (int x=0; x<usuarios.length; x++){
                if (usuarioDigitado.equals(usuarios[x])) {
                    achou = true;
                    posicao = x;
                    break;
                }
            }

            if (!achou) {
                mostrarToast("Usuário inexistente", 1);
            }

            if (achou) {
                if (senhaDigitada.equals(senhas[posicao])) {
                    mostrarToast("Usuário logado", 0);
                } else {
                    mostrarToast("Senha incorreta", 0);
                    mostrarToastPergunta(MainActivity.this, "Gostaria de ver uma dica de senha?", posicao);
                }
            }
        }
    }

    private void mostrarToast(String texto, int duracao) {
        Context context = getApplicationContext();
        //Montando o texto do toast
        Toast toast = Toast.makeText(context, texto, duracao);
        //Exibindo o toast no app
        toast.show();
    }

    private void mostrarToastPergunta(Context context, String pergunta, int posicao) {
        // Adicionando botões sim e não ao toast

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage(pergunta)
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        // Ação quando o usuário clicar em "Sim"
                        String dica = dicasSenha[posicao];
                        Toast.makeText(context, dica, Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        // Ação quando o usuário clicar em "Não"
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

}