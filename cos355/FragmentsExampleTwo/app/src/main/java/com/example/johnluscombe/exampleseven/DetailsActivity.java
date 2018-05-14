package com.example.johnluscombe.exampleseven;

import android.app.Activity;
import android.os.Bundle;

public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DetailsFragment details = new DetailsFragment();
        details.setArguments(getIntent().getExtras());
        getFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
    }
}
