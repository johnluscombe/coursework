package com.example.johnluscombe.giftletwithfragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DetailsFragment extends Fragment {

    public DetailsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.details_layout, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        setActionBar(getActivity());
    }

    private void setActionBar(Activity activity) {
        ActionBar actionBar = ((AppCompatActivity)activity).getSupportActionBar();
        actionBar.setTitle("Details");
    }
}
