package pt.ipbeja.estig.twdm.pdm1.pdm1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Chat {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private long createdTime;
    private String lastMessage;

    public Chat(long id, String name, long createdTime, String lastMessage) {
        this.id = id;
        this.name = name;
        this.createdTime = createdTime;
        this.lastMessage = lastMessage;
    }

    @Ignore
    public Chat(String name, long createdTime, String lastMessage) {
        this.name = name;
        this.createdTime = createdTime;
        this.lastMessage = lastMessage;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}