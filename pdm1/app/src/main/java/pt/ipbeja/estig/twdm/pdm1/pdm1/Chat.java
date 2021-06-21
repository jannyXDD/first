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

    public Chat(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Ignore
    public Chat(String name) {
        this.name = name;
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