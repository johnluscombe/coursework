package com.example.johnluscombe.exampleseven;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    public static DetailsFragment newInstance(int index) {
        Bundle args = new Bundle();
        DetailsFragment fragment = new DetailsFragment();
        args.putInt("index", index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ScrollView scroller = new ScrollView(getActivity());
        TextView text = new TextView(getActivity());
        text.setText(Rock.DESCRIPTION[getArguments().getInt("index", 0)]);
        scroller.addView(text);
        return scroller;
    }
}
