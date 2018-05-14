package com.example.johnluscombe.lovecalculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.DonutProgress;

public class LoveActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);

        TextView name = (TextView)findViewById(R.id.name);
        TextView percentageTextView = (TextView)findViewById(R.id.percentage);
        DonutProgress percentageProgressBar = (DonutProgress) findViewById(R.id.percentage_meter);
        TextView resultTextView = (TextView)findViewById(R.id.result);

        String first_name = getIntent().getStringExtra("first_name");
        String last_name = getIntent().getStringExtra("last_name");
        String percentage = getIntent().getStringExtra("percentage");
        String result = getIntent().getStringExtra("result");

        name.setText(String.format("%s %s", first_name, last_name));
        percentageTextView.setText(percentage + "%");
        percentageProgressBar.setProgress(Integer.parseInt(percentage));
        percentageProgressBar.setRotation(270);
        resultTextView.setText(result);
    }
}
