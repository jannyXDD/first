package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class DetailsActivity extends AppCompatActivity {

    public static void startActivity(Context context, long id) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_COUNTRYID, id);
        context.startActivity(intent);
    }

    private static final String KEY_COUNTRYID = "COUNTRYPOSITION";
    private static final String TAG = "DetailsActivity";

    private ImageView imageViewFlag;
    private TextView textViewName;
    private TextView textViewPopulation;
    private TextView textViewDescription;

    private Country country;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.imageViewFlag = findViewById(R.id.imageView);
        this.textViewName = findViewById(R.id.textViewName);
        this.textViewPopulation = findViewById(R.id.textViewPopulation);
        this.textViewDescription = findViewById(R.id.textViewDescription);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            long id = bundle.getLong(KEY_COUNTRYID, -1);
            if (id == -1) {
                Log.e(TAG, "Invalid id found!");
                finish();
            }

            this.country = DataSource.getCountry(this, id);

            Glide.with(this).load(country.getFlag()).into(this.imageViewFlag);
            this.textViewName.setText(country.getName());
        } else {
            Log.e(TAG, "No position specified!");
            finish();
        }
    }
}