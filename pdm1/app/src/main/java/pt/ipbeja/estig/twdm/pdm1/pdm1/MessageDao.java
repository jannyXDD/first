package pt.ipbeja.estig.twdm.pdm1.pdm1;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MessageDao {

    @Query("SELECT * FROM Message")
    List<Message> getAll();

    @Query("SELECT * FROM Message WHERE chatId = :chatId")
    List<Message> getAllForChat(long chatId);

    @Query("SELECT * FROM Message WHERE id = :id")
    Message getById(long id);

    @Insert
    void add(Message message);

    @Insert
    void add(List<Message> messageList);

    @Delete
    void delete(Message message);

    @Update
    void update(Message message);
}
