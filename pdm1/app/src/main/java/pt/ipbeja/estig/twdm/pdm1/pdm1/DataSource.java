package pt.ipbeja.estig.twdm.pdm1.pdm1;

import android.content.Context;

import java.util.List;

public class DataSource {

    private static List<Chat> chatList;
    private static List<Message> messageList;

    private DataSource() {

    }

    public static List<Chat> getChatList(Context context) {
        return AppDataBase.getInstance(context).getChatDao().getAll();
    }


    public static Chat getChat(Context context, long id) {
        return AppDataBase.getInstance(context).getChatDao().getById(id);
    }

    public static List<Message> getMessageListForChat(Context context, long chatId) {
        return AppDataBase.getInstance(context).getMessageDao().getAllForChat(chatId);
    }


    public static Message getMessage(Context context, long id) {
        return AppDataBase.getInstance(context).getMessageDao().getById(id);
    }


}
