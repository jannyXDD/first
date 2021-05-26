package com.example.recyclerviewtest;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Country.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract CountryDao getCountryDao();
    private static AppDataBase INSTANCE;

    public static AppDataBase getInstance(Context context) {
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDataBase.class, "countryDB")
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            db.execSQL("INSERT INTO Country (name, flag) VALUES ('Austria', 'https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-austria.jpg')");
                            db.execSQL("INSERT INTO Country (name, flag) VALUES ('Belgium', 'https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-belgium.jpg')");
                            db.execSQL("INSERT INTO Country (name, flag) VALUES ('Bulgaria', 'https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-bulgaria.jpg')");
                            db.execSQL("INSERT INTO Country (name, flag) VALUES ('Croatia', 'https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-croatia.jpg')");
                            db.execSQL("INSERT INTO Country (name, flag) VALUES ('Cyprus', 'https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-cyprus.jpg')");
                            db.execSQL("INSERT INTO Country (name, flag) VALUES ('Czechia', 'https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-czech-republic.jpg')");
                            db.execSQL("INSERT INTO Country (name, flag) VALUES ('Denmark', 'https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-denmark.jpg')");

                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
}
