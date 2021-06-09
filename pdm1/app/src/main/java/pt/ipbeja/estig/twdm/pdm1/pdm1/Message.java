package pt.ipbeja.estig.twdm.pdm1.pdm1;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Message {
    @PrimaryKey (autoGenerate = true)
    private long id;
    @ForeignKey(entity = Chat.class, parentColumns = "id", childColumns = "chatId", onDelete = ForeignKey.CASCADE)
    private long chatId;
    private String content;

    public Message(long id, String content) {
        this.id = id;
        this.content = content;
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
}

