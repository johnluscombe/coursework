package com.example.johnluscombe.giftletwithfragments;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showRecipients();
    }

    private void showRecipients() {
        RecipientFragment recipientFragment = new RecipientFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.vertical_and_horizontal_left_pane, recipientFragment);
        fragmentTransaction.commit();
    }
}