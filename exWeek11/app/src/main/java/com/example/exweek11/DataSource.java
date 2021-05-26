package com.example.exweek11;

import android.content.Context;

import java.util.List;

public class DataSource {

    private static List<Item> itemList;

    private DataSource() {

    }

    public static List<Item> getItemList(Context context) {
        return AppDataBase.getInstance(context).getItemDao().getAll();
    }

    public static Item getItem(Context context, long id) {
        //return getCountryList().get(position);
        return AppDataBase.getInstance(context).getItemDao().getById(id);
    }
}
