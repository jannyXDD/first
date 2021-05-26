package com.example.recyclerviewtest;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Country {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String flag;

    public Country(long id, String name, String flag) {
        this.id = id;
        this.name = name;
        this.flag = flag;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFlag() {
        return flag;
    }
}
