package com.example.exweek11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    public static void startActivity(Context context, long id) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_ITEMID, id);
        context.startActivity(intent);
    }

    private static final String KEY_ITEMID = "ITEMPOSITION";
    private static final String TAG = "DetailsActivity";

    private TextView textViewTitle;
    private TextView textViewDescription;
    private CheckBox checkBox;
    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        this.checkBox = findViewById(R.id.checkBox2);
        this.textViewTitle = findViewById(R.id.textViewTitle);
        this.textViewDescription = findViewById(R.id.textViewDescription);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            long id = bundle.getLong(KEY_ITEMID, -1);
            if (id == -1) {
                Log.e(TAG, "Invalid id found!");
                finish();
            }

            this.item = DataSource.getItem(this, id);
            this.textViewTitle.setText(item.getTitle());
            this.textViewDescription.setText(item.getDescription());
            this.checkBox.setChecked(this.item.isCompleted());
            this.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    DetailsActivity.this.item.setCompleted(isChecked);
                    AppDataBase.getInstance(DetailsActivity.this).getItemDao().update(DetailsActivity.this.item);
                }
            });

        } else {
            Log.e(TAG, "No position specified!");
            finish();
        }
    }
}