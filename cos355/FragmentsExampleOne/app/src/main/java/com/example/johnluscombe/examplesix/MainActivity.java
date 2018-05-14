package com.example.johnluscombe.examplesix;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private ArrayList<String> listValues;
    private ArrayAdapter<String> listAdapter;
    private EditText editText;
    private static final String FILENAME = "storage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.newItem);

        listValues = new ArrayList<>();
        listAdapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.item, listValues);
        setListAdapter(listAdapter);
    }

    public void addItem(View v) {
        String newValue = editText.getText().toString();
        listValues.add(newValue);
        editText.setText("");
        listAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (listValues.isEmpty()) {
            try {
                FileInputStream fileInputStream = openFileInput(FILENAME);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                ArrayList<String> listFromStorage = (ArrayList<String>)objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
                listValues.addAll(listFromStorage);
                listAdapter.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (!listValues.isEmpty()) {
            try {
                FileOutputStream fileOutputStream = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(listValues);
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
