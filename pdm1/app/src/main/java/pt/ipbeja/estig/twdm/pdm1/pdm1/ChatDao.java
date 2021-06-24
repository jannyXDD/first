package pt.ipbeja.estig.twdm.pdm1.pdm1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ChatDao {

    @Query("SELECT * FROM Chat")
    List<Chat> getAll();

    @Query("SELECT * FROM Chat ORDER BY lastMessageTime DESC")
    List<Chat> getAllOrderedByLastMessage();

    @Query("SELECT * FROM Chat WHERE id = :id")
    Chat getById(long id);

    @Insert
    void add(Chat chat);

    @Insert
    void add(List<Chat> chatList);

    @Delete
    void delete(Chat chat);

    @Update
    void update(Chat chat);
}
