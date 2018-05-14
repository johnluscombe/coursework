package com.example.johnluscombe.domainavailabilitychecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DomainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domain);

        boolean available = getIntent().getBooleanExtra("available", false);
        TextView resultText1 = (TextView)findViewById(R.id.resultText1);
        TextView resultText2 = (TextView)findViewById(R.id.resultText2);
        ImageView resultIcon = (ImageView)findViewById(R.id.resultIcon);

        if (available) {
            resultText1.setText(R.string.congrats);
            resultText2.setText(R.string.domain_available);
            resultIcon.setImageResource(R.drawable.check);
        }
    }
}
