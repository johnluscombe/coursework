package edu.taylor.cse.jluscomb.examplethreedotone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(getApplicationContext(), MyIntentService.class);
        intent.putExtra("item", "trail mix");
        startService(intent);

        intent.putExtra("item", "water bottle");
        startService(intent);

        intent.putExtra("item", "granola bar");
        startService(intent);
    }
}
