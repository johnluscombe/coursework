package com.example.johnluscombe.giftletwithfragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Gift {
    private Context mContext;

    private String mTableName;

    protected int mId;
    protected String mName;
    protected String mDescription;
    protected String mUrl;
    protected String mPrice;

    protected Gift(Context context, String name, String description, String url, String price) {
        this(context, 0, name, description, url, price);
    }

    protected Gift(Context context, int id, String name, String description, String url, String price) {

        mContext = context;

        DatabaseHelper databaseHelper = new DatabaseHelper(mContext);
        mTableName = databaseHelper.getGiftsTableName();

        mId = id;
        mName = name;
        mDescription = description;
        mUrl = url;
        mPrice = price;
    }

    private int assignId() {
        DatabaseHelper databaseHelper = new DatabaseHelper(mContext);
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery(
                String.format("SELECT ID FROM %s WHERE ID = (SELECT MAX(ID) FROM %s);",
                        mTableName, mTableName), null);

        if (cursor.moveToNext()) {
            int idx = cursor.getInt(0) + 1;
            cursor.close();
            database.close();
            return idx;
        } else {
            return 1;
        }
    }

    protected static Gift find(Context context, int id) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        String tableName = databaseHelper.getGiftsTableName();
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        Cursor cursor = database.rawQuery(
                String.format("SELECT * FROM %s WHERE ID = %s;", tableName, id), null
        );

        int nameColumnIndex = cursor.getColumnIndex(DatabaseHelper.NAME);
        int descriptionColumnIndex = cursor.getColumnIndex(DatabaseHelper.DESCRIPTION);
        int urlColumnIndex = cursor.getColumnIndex(DatabaseHelper.URL);
        int priceColumnIndex = cursor.getColumnIndex(DatabaseHelper.PRICE);

        cursor.moveToNext();
        String name = cursor.getString(nameColumnIndex);
        String description = cursor.getString(descriptionColumnIndex);
        String url = cursor.getString(urlColumnIndex);
        String price = cursor.getString(priceColumnIndex);

        cursor.close();
        database.close();
        return new Gift(context, id, name, description, url, price);
    }

    protected static Gift[] all(Context context) {
        ArrayList<Gift> gifts = new ArrayList<>();
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        String tableName = databaseHelper.getGiftsTableName();
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        Gift gift;
        int id;

        Cursor cursor = database.rawQuery(
                String.format("SELECT ID FROM %s;", tableName), null
        );

        while (cursor.moveToNext()) {
            id = cursor.getInt(0);
            gift = find(context, id);
            gifts.add(gift);
        }

        cursor.close();
        database.close();
        return gifts.toArray(new Gift[gifts.size()]);
    }

    protected boolean destroy() {
        DatabaseHelper databaseHelper = new DatabaseHelper(mContext);
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        String selection = DatabaseHelper.ID + " LIKE ?";
        String[] selectionArgs = {Integer.toString(mId)};
        long result = database.delete(mTableName, selection, selectionArgs);
        database.close();
        return result != 0;
    }

    protected boolean save() {
        if (!validatesPresence()) {
            return false;
        } else {
            DatabaseHelper databaseHelper = new DatabaseHelper(mContext);
            SQLiteDatabase database = databaseHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            mId = assignId();
            values.put(DatabaseHelper.ID, mId);
            values.put(DatabaseHelper.NAME, mName);
            values.put(DatabaseHelper.DESCRIPTION, mDescription);
            values.put(DatabaseHelper.URL, mUrl);
            values.put(DatabaseHelper.PRICE, mPrice);
            long result = database.insert(mTableName, null, values);
            database.close();
            return result != -1;
        }
    }

    private boolean validatesPresence() {
        String[] attributes = {mName};

        for (String string: attributes) {
            if (isAllSpaces(string)) {
                return false;
            }
        }

        return true;
    }

    private boolean isAllSpaces(String string) {
        for (char c : string.toCharArray()) {
            if (c != ' ') {
                return false;
            }
        }

        return true;
    }
}
