package com.example.primeiroprojetodaniel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.primeiroprojetodaniel.R;

import java.util.Calendar;

public class CadastroPessoa extends AppCompatActivity {

    private Calendar calendar;
    private EditText editTextDateNasc;
    private String genero = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pessoa);

        EditText editTextNome = findViewById(R.id.editTextNome);
        EditText editTextCPF = findViewById(R.id.editTextCPF);
        EditText editTextEndereco = findViewById(R.id.editTextEndereco);
        EditText editTextNumero = findViewById(R.id.editTextNumero);
        EditText editTextBairro = findViewById(R.id.editTextBairro);
        editTextDateNasc = findViewById(R.id.editTextDateNasc);
        RadioButton radioButtonMasc = findViewById(R.id.radioButtonMasc);
        RadioButton radioButtonFem = findViewById(R.id.radioButtonFem);
        Button buttonSalvar = findViewById(R.id.buttonSalvar);
        Button buttonData = findViewById(R.id.buttonData);
        RadioGroup radioGroup = findViewById(R.id.radioGroupGenero);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Verificando qual RadioButton foi selecionado
                RadioButton selectedRadioButton = findViewById(checkedId);
                if (selectedRadioButton != null) {
                    genero = selectedRadioButton.getText().toString();
                }
            }
        });

        buttonData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirDatePicker();
            }
        });

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Toast.makeText(CadastroPessoa.this, "Cadastro salvo com sucesso! " +
                                    "\nNome: " + editTextNome.getText().toString() + "" +
                                    "\nCPF: " + editTextCPF.getText().toString() + "" +
                                    "\nDataNasc.: " + editTextDateNasc.getText().toString() +
                                    "\nGênero: " + genero,
                            Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void abrirDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // Definindo a data no EditText.
                        String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        editTextDateNasc.setText(selectedDate);
                    }
                },
                year,
                month,
                dayOfMonth
        );
        datePickerDialog.show();
    }
}