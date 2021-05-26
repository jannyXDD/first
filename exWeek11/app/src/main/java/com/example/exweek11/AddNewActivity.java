package com.example.exweek11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddNewActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private TextView textViewDesc;
    private FloatingActionButton button;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_new);

            textViewTitle = findViewById(R.id.editTitle);
            textViewDesc = findViewById(R.id.editDescription);
            button = findViewById(R.id.floatingActionButton2);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Item item = new Item(textViewTitle.getText() + "", textViewDesc.getText() + "", false);
                    AppDataBase.getInstance(AddNewActivity.this).getItemDao().add(item);

                }
            });

        }




}