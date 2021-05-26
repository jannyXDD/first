package com.example.exweek11;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Item.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract ItemDao getItemDao();
    private static AppDataBase INSTANCE;

    public static AppDataBase getInstance(Context context) {
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDataBase.class, "itemDB")
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            db.execSQL("INSERT INTO Item (title, description, completed) VALUES ('Tarefa', 'Esta é a Tarefa', false)");
                            db.execSQL("INSERT INTO Item (title, description, completed) VALUES ('Tarefa', 'Esta é a Tarefa', false)");
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
}
