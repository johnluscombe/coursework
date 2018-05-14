package com.example.johnluscombe.giftletwithfragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class NewRecipientDialogFragment extends DialogFragment {

    private NewRecipientDialogListener mListener;
    private View view;

    protected interface NewRecipientDialogListener {
        void onDialogPositiveClick(DialogFragment dialog);
    }

    public NewRecipientDialogFragment() {}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (NewRecipientDialogListener) getTargetFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement NewRecipientDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.fragment_new_recipient_dialog, null);

        alertDialogBuilder.setView(view);
        alertDialogBuilder.setTitle("New Recipient");
        alertDialogBuilder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText firstNameField = (EditText)view.findViewById(R.id.new_recipient_first_name);
                String firstName = firstNameField.getText().toString();

                EditText lastNameField = (EditText)view.findViewById(R.id.new_recipient_last_name);
                String lastName = lastNameField.getText().toString();

                Recipient recipient = new Recipient(getContext(), firstName, lastName);
                recipient.save();

                mListener.onDialogPositiveClick(NewRecipientDialogFragment.this);
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {}
        });

        return alertDialogBuilder.create();
    }
}
