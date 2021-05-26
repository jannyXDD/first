package com.example.recyclerviewtest;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CountryDao {
    @Query("SELECT * FROM Country")
    List<Country>getAll();

    @Query("SELECT * FROM Country WHERE id = :id")
    Country getById(long id);

    @Insert
    void add(Country country);

    @Insert
    void add(List<Country> countries);

    @Delete
    void delete(Country country);

    @Update
    void update(Country country);
}
