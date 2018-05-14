package edu.taylor.cse.jluscomb.examplethreedotone;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

public class MyIntentService extends IntentService {

    private static final String TAG = "MyIntentService";
    private ArrayList<String> backpack = new ArrayList<>();

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent");
        Log.d(TAG, "process ID: " + android.os.Process.myPid() + " thread ID: " + android.os.Process.myTid());
        String item = intent.getStringExtra("item");
        backpack.add(item);
        Log.d(TAG, backpackToString());
    }

    private String backpackToString() {
        StringBuilder result = new StringBuilder();

//        for (String tmp : backpack) {
//            result.append(tmp);
//            result.append(", ");
//        }

        Iterator i = backpack.iterator();
        while(i.hasNext()) {
            result.append(i.next());
            result.append(", ");
        }

        return result.toString();
    }
}
