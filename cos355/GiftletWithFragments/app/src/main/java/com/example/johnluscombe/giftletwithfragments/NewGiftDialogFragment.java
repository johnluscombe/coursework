package com.example.johnluscombe.giftletwithfragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class NewGiftDialogFragment extends DialogFragment {

    private NewGiftDialogListener mListener;
    private View view;

    protected interface NewGiftDialogListener {
        void onDialogPositiveClick(DialogFragment dialog);
    }

    public NewGiftDialogFragment() {}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (NewGiftDialogListener) getTargetFragment();
        } catch(ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement NewGiftDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.fragment_new_gift_dialog, null);

        alertDialogBuilder.setView(view);
        alertDialogBuilder.setTitle("New Gift");
        alertDialogBuilder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText nameField = (EditText)view.findViewById(R.id.new_gift_name);
                String name = nameField.getText().toString();

                EditText descriptionField = (EditText)view.findViewById(R.id.new_gift_description);
                String description = descriptionField.getText().toString();

                EditText urlField = (EditText)view.findViewById(R.id.new_gift_url);
                String url = urlField.getText().toString();

                EditText priceField = (EditText) view.findViewById(R.id.new_gift_price);
                String price = priceField.getText().toString();

                Gift gift = new Gift(getContext(), name, description, url, price);
                gift.save();

                mListener.onDialogPositiveClick(NewGiftDialogFragment.this);
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {}
        });

        return alertDialogBuilder.create();
    }
}
