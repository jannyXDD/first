package pt.ipbeja.estig.twdm.pdm1.pdm1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    public static void startActivity(Context context, long id){
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_CHATPOSITION, id);
        context.startActivity(intent);
    }

    private static final String KEY_CHATPOSITION = "CHATPOSITION";
    private static final String TAG = "DetailsActivity";

    private ImageView imageViewCover;
    private TextView textViewName;
    private TextView textViewChat;
    private TextView textViewAuthor;
    private TextView textViewYear;
    private Chat chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.textViewName = findViewById(R.id.textViewName);
        this.textViewChat = findViewById(R.id.textViewChat);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            long id = bundle.getLong(KEY_CHATPOSITION, -1);
            if (id == -1){
                Log.e(TAG, "Invalid id found!");
                finish();
            }
            this.chat = DataSource.getChat(this, id);

            this.textViewName.setText(chat.getName());
            this.textViewChat.setText(chat.getMessage());
        } else{
            Log.e(TAG, "No position specified!");
            finish();
        }
    }
}