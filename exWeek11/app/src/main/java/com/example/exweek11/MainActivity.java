package com.example.exweek11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        this.adapter = new ItemAdapter(this, DataSource.getItemList(this));
        recyclerView.setAdapter(this.adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void addActivity(View view) {
        Intent intent = new Intent(this, AddNewActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.adapter.updateList(DataSource.getItemList(this));
    }
}