package com.example.exweek11;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemDao {
    @Query("SELECT * FROM Item")
    List<Item> getAll();

    @Query("SELECT * FROM Item WHERE id = :id")
    Item getById(long id);

    @Insert
    void add(Item item);

    @Insert
    void add(List<Item> Items);

    @Delete
    void delete(Item item);

    @Update
    void update(Item item);
}
