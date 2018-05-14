package com.example.johnluscombe.giftletwithfragments;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GiftAdapter extends ArrayAdapter<Gift> {

    private Gift[] mGifts;
    private String[] mGiftNames;


    public GiftAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Gift[] objects) {
        super(context, resource, objects);
        mGifts = objects;
        setGiftNames();
    }

    private void setGiftNames() {
        mGiftNames = new String[mGifts.length];

        for (int i = 0; i < mGifts.length; i++) {
            mGiftNames[i] = mGifts[i].mName;
        }
    }

    @Override
    public int getCount() {
        return mGifts.length;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_view_items, null);
        TextView textView = (TextView)view.findViewById(R.id.item_text);
        ImageView imageView = (ImageView)view.findViewById(R.id.delete_icon);
        textView.setText(mGiftNames[position]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGifts[position].destroy();
                GiftAdapter.this.update();
            }
        });

        return view;
    }

    public void update() {
        mGifts = Gift.all(getContext());
        setGiftNames();
        this.notifyDataSetChanged();
    }
}
