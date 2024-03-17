package com.example.primeiroprojetodaniel.apoio;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DataBaseManager extends SQLiteOpenHelper {

    public DataBaseManager(Context context, String nomeBancoDados, int versao) {
        super(context, nomeBancoDados, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE item (id INTEGER PRIMARY KEY AUTOINCREMENT, descricao TEXT, quantidade integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE item");
        onCreate(db);
    }
}
