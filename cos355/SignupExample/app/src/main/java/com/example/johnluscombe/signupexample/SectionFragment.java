package com.example.johnluscombe.signupexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SectionFragment extends Fragment {

    public static final String ARG_SECTION_NUMBER = "section_number";

    public SectionFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        int section = getArguments().getInt(ARG_SECTION_NUMBER);

        switch(section) {
            case 0:
                return inflater.inflate(R.layout.login_details_layout, container, false);
            case 1:
                return inflater.inflate(R.layout.personal_details_layout, container, false);
            case 2:
                return inflater.inflate(R.layout.address_layout, container, false);
            default:
                return null;
        }
    }
}
