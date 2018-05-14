package com.example.johnluscombe.giftletwithfragments;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipientAdapter extends ArrayAdapter<Recipient> implements Filterable {

    private Recipient[] mRecipients;
    private Recipient[] mFilteredRecipients;
    private String[] mFilteredRecipientNames;
    private RecipientFilter recipientFilter;

    public RecipientAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Recipient[] objects) {
        super(context, resource, objects);
        mRecipients = objects;
        mFilteredRecipients = objects;
        setFilteredRecipientNames();
        getFilter();
    }

    private void setFilteredRecipientNames() {
        mFilteredRecipientNames = new String[mFilteredRecipients.length];

        for (int i = 0; i < mFilteredRecipients.length; i++) {
            mFilteredRecipientNames[i] = String.format("%s %s",
                    mFilteredRecipients[i].mFirstName, mFilteredRecipients[i].mLastName);
        }
    }

    @Override
    public int getCount() {
        return mFilteredRecipients.length;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_view_items, null);
        TextView textView = (TextView) view.findViewById(R.id.item_text);
        ImageView imageView = (ImageView) view.findViewById(R.id.delete_icon);
        textView.setText(mFilteredRecipientNames[position]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFilteredRecipients[position].destroy();
                RecipientAdapter.this.update();
            }
        });

        return view;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        if (recipientFilter == null) {
            recipientFilter = new RecipientFilter();
        }

        return recipientFilter;
    }

    public void update() {
        mRecipients = Recipient.all(getContext());
        mFilteredRecipients = Recipient.all(getContext());
        setFilteredRecipientNames();
        this.notifyDataSetChanged();
    }

    private class RecipientFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                ArrayList<Recipient> tempList = new ArrayList<>();
                ArrayList<Integer> processedIds = new ArrayList<>();

                for (Recipient recipient : mRecipients) {
                    String constraintString = constraint.toString().toLowerCase();
                    int length = constraintString.length();
                    String recipientFirstName;
                    String recipientLastName;

                    if (length < recipient.mFirstName.length()) {
                        recipientFirstName = recipient.mFirstName.substring(0, length).toLowerCase();
                    } else {
                        recipientFirstName = recipient.mFirstName.toLowerCase();
                    }

                    if (length < recipient.mLastName.length()) {
                        recipientLastName = recipient.mLastName.substring(0, length).toLowerCase();
                    } else {
                        recipientLastName = recipient.mLastName.toLowerCase();
                    }

                    if (constraintString.contains(" ")) {
                        int spaceIndex = constraint.toString().indexOf(' ');
                        String constraintFirstName = constraintString.substring(0, spaceIndex);
                        String constraintLastName = constraintString.substring(
                                spaceIndex, constraintString.length());

                        if (recipientFirstName.equals(constraintFirstName) &&
                                !processedIds.contains(recipient.mId)) {

                            tempList.add(recipient);
                            processedIds.add(recipient.mId);
                        }

                        if (recipientLastName.equals(constraintLastName) &&
                                !processedIds.contains(recipient.mId)) {

                            tempList.add(recipient);
                            processedIds.add(recipient.mId);
                        }
                    } else {
                        if (recipientFirstName.equals(constraintString) &&
                                !processedIds.contains(recipient.mId)) {

                            tempList.add(recipient);
                            processedIds.add(recipient.mId);
                        }

                        if (recipientLastName.equals(constraintString) &&
                                !processedIds.contains(recipient.mId)) {

                            tempList.add(recipient);
                            processedIds.add(recipient.mId);
                        }
                    }
                }

                filterResults.count = tempList.size();
                filterResults.values = convertArrayListToArray(tempList);
            } else {
                filterResults.count = mRecipients.length;
                filterResults.values = mRecipients;
            }

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mFilteredRecipients = (Recipient[]) results.values;

            if (mFilteredRecipients == null) {
                mFilteredRecipients = new Recipient[0];
            }

            setFilteredRecipientNames();
            notifyDataSetChanged();
        }

        private Recipient[] convertArrayListToArray(ArrayList<Recipient> arrayList) {
            Recipient[] recipients = new Recipient[arrayList.size()];

            for (int i = 0; i < arrayList.size(); i++) {
                recipients[i] = arrayList.get(i);
            }

            return recipients;
        }
    }
}
