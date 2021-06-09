package pt.ipbeja.estig.twdm.pdm1.pdm1;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Chat.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract ChatDao getChatDao();

    private static AppDataBase INSTANCE;

    public static AppDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDataBase.class,
                    "myAppDB")
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            db.execSQL("INSERT INTO Chat (name, message) VALUES ('Osvaldo', 'Olá és fixe')");
                            db.execSQL("INSERT INTO Chat (name, message) VALUES ('Inês', 'Sou burra')");
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
}