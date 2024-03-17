package com.example.primeiroprojetodaniel.apoio;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Item implements Serializable {
    private Integer id;
    private String nomeItem;
    private Integer quantidadeItem;

    public Item(Integer id, String nomeItem, Integer quantidadeItem) {
        this.id = id;
        this.nomeItem = nomeItem;
        this.quantidadeItem = quantidadeItem;
    }

    public Item() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public Integer getQuantidadeItem() {
        return quantidadeItem;
    }

    public void setQuantidadeItem(Integer quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }
}
