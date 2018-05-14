package com.example.johnluscombe.examplefive;

import android.os.Binder;

public class MyBinder extends Binder {
    private MyService service;

    public MyService getService() {
        return service;
    }

    public void setService(MyService service) {
        this.service = service;
    }
}
