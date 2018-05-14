package com.example.johnluscombe.examplefive;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    private int current = 0;

    @Override
    public IBinder onBind(Intent intent) {
        MyBinder binder = new MyBinder();
        binder.setService(this);
        return binder;
    }

    public int getNext() {
        current++;
        return current;
    }
}
