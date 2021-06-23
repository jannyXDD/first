package pt.ipbeja.estig.twdm.pdm1.pdm1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class NewChat extends AppCompatActivity {

    private TextView name;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_chat);

        name = findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date currentDate = new Date();
                Chat chat = new Chat(name.getText() + "", currentDate.getTime(), "Não tem mensagens com este chat");
                AppDataBase.getInstance(NewChat.this).getChatDao().add(chat);
                startActivity(new Intent (NewChat.this, MainActivity.class));
            }
        });


    }


}