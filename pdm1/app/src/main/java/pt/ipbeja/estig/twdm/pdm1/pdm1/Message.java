package pt.ipbeja.estig.twdm.pdm1.pdm1;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = Chat.class,
        parentColumns = "id",
        childColumns = "chatId",
        onDelete = ForeignKey.CASCADE)})
public class Message {
    @PrimaryKey (autoGenerate = true)
    private long id;
    private long chatId;
    private String content;
    private long date;
    private boolean fromBot;

    public Message(long chatId, String content, long date, boolean fromBot) {
        this.chatId = chatId;
        this.content = content;
        this.date = date;
        this.fromBot = fromBot;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public boolean isFromBot() {
        return fromBot;
    }

    public void setFromBot(boolean fromBot) {
        this.fromBot = fromBot;
    }
}

