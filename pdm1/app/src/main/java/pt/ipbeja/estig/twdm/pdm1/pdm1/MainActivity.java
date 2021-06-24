package pt.ipbeja.estig.twdm.pdm1.pdm1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        this.adapter = new ChatAdapter(this);
        recyclerView.setAdapter(this.adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void goToNewChat(View view) {
        Intent intent = new Intent(this, NewChat.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.adapter.updateList(DataSource.getChatListOrdered(this));
    }
}