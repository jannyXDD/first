package pt.ipbeja.estig.twdm.pdm1.pdm1;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Chat.class, Message.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract ChatDao getChatDao();
    public abstract MessageDao getMessageDao();

    private static AppDataBase INSTANCE;

    public static AppDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDataBase.class,
                    "myAppDB")
                    .allowMainThreadQueries() // n deve ser usado em PROD
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            //db.execSQL("INSERT INTO Chat (name, createdTime) VALUES ('Osvaldo', 222)");
                            //db.execSQL("INSERT INTO Chat (name, createdTime) VALUES ('Dja', 222222)");
                            //db.execSQL("INSERT INTO Message (chatId, content, date, fromBot) VALUES ('1', 'dasdsdsdsds', '2', false)");
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
}