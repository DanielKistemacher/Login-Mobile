package com.example.primeiroprojetodaniel.apoio;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    private SQLiteDatabase database;
    private static final String TABLE_ITEM = "item";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_DESCRICAO = "descricao";
    private static final String COLUMN_QUANTIDADE = "quantidade";

    public DatabaseHelper(Context context) {
        database = context.openOrCreateDatabase("baseDados", Context.MODE_PRIVATE, null);
    }

    public List<Item> consultaTodosItens() {
        List<Item> itemList = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_ITEM, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
                String descricao = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRICAO));
                int quantidade = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_QUANTIDADE));

                Item item = new Item(id, descricao, quantidade);
                itemList.add(item);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return itemList;
    }
}
