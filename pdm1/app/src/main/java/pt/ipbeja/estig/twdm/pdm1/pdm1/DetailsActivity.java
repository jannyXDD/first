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

import java.util.List;

public class DetailsActivity extends AppCompatActivity {


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
    private TextView messageTV;
    private TextView textViewAuthor;
    private TextView textViewYear;
    private Chat chat;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.textViewName = findViewById(R.id.textViewName);
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
                    AppDataBase messageDataBase = AppDataBase.getInstance(getApplicationContext());
                    MessageDao messageDao = messageDataBase.getMessageDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Message newMessage = new Message(chat.getId(), message, 2, false);
                            AppDataBase.getInstance(DetailsActivity.this).getMessageDao().add(newMessage);
                            List<Message> newList = messageDao.getAllForChat(DetailsActivity.this.chat.getId());
                            DetailsActivity.this.adapter.updateList(newList);
                            finish();
                            startActivity(getIntent());
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
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