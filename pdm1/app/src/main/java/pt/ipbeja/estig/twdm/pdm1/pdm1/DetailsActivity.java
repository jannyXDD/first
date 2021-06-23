package pt.ipbeja.estig.twdm.pdm1.pdm1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd || HH:mm");

    public static void startActivity(Context context, long id){
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_CHATID, id);
        context.startActivity(intent);
    }

    private static final String KEY_CHATID = "CHATPOSITION";
    private static final String TAG = "DetailsActivity";

    private MessageAdapter adapter;
    private ImageView imageViewCover;
    private TextView textViewName;
    private TextView textViewMessage;
    private TextView textViewChat;
    private TextView delete;
    private TextView textViewDate;
    private Chat chat;
    private Button button;
    private Message message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.textViewName = findViewById(R.id.textViewName);
        this.textViewDate = findViewById(R.id.textViewDate);
        this.textViewMessage = findViewById(R.id.editTextType);
        this.button = findViewById(R.id.button);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            long id = bundle.getLong(KEY_CHATID, -1);
            if (id == -1) {
                Log.e(TAG, "Invalid id found!");
                finish();
            }
            this.chat = DataSource.getChat(this, id);
            this.textViewName.setText(chat.getName());

            // this.textViewChat.setText(chat.getMessage());
            chat = AppDataBase.getInstance(this).getChatDao().getById(id);
            Date createDateTime = new Date(chat.getCreatedTime());
        } else {
            Log.e(TAG, "No position specified!");
            finish();
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView2);
        adapter = new MessageAdapter(this, DataSource.getMessageListForChat(this, this.chat.getId()));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = textViewMessage.getText().toString();

                if (message.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Escreva a Mensagem", Toast.LENGTH_SHORT).show();
                } else {
                    AppDataBase dataBase = AppDataBase.getInstance(getApplicationContext());
                    MessageDao messageDao = dataBase.getMessageDao();
                    ChatDao chatDao = dataBase.getChatDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Date newDate = new Date();
                                    Message newMessage = new Message(chat.getId(), textViewMessage.getText() + "" ,newDate.getTime() , false);
                                    AppDataBase.getInstance(DetailsActivity.this).getMessageDao().add(newMessage);
                                    List<Message> newList = messageDao.getAllForChat(DetailsActivity.this.chat.getId());
                                    DetailsActivity.this.adapter.updateList(newList);
                                    textViewMessage.setText("");
                                    Toast.makeText(getApplicationContext(),"Mensagem enviada com Sucesso", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();
                }

            }
        });
    }
}