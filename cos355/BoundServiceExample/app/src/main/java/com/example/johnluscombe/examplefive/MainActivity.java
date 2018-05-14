package com.example.johnluscombe.examplefive;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean is_bound = false;
    private MyService my_service;

    ServiceConnection my_connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBinder binder = (MyBinder)service;
            my_service = binder.getService();
            is_bound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            is_bound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is_bound) {
                    int x = my_service.getNext();
                    Toast.makeText(getApplicationContext(), "Number is: " + x, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Unbound", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(getApplicationContext(), MyService.class);
        bindService(intent, my_connection, Context.BIND_AUTO_CREATE);
    }
}
