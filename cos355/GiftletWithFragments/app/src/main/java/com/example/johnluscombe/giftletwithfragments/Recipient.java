package com.example.johnluscombe.giftletwithfragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Recipient {
    private Context mContext;

    private String mTableName;

    protected int mId;
    protected String mFirstName;
    protected String mLastName;

    protected Recipient(Context context, String firstName, String lastName) {
        this(context, 0, firstName, lastName);
    }

    protected Recipient(Context context, int id, String firstName, String lastName) {

        mContext = context;

        DatabaseHelper databaseHelper = new DatabaseHelper(mContext);
        mTableName = databaseHelper.getUsersTableName();

        mId = id;
        mFirstName = firstName;
        mLastName = lastName;
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

    protected static Recipient find(Context context, int id) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        String tableName = databaseHelper.getUsersTableName();
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        Cursor cursor = database.rawQuery(
                String.format("SELECT * FROM %s WHERE ID = %s;", tableName, id), null
        );

        int firstNameColumnIndex = cursor.getColumnIndex(DatabaseHelper.FIRST_NAME);
        int lastNameColumnIndex = cursor.getColumnIndex(DatabaseHelper.LAST_NAME);

        cursor.moveToNext();
        String firstName = cursor.getString(firstNameColumnIndex);
        String lastName = cursor.getString(lastNameColumnIndex);

        cursor.close();
        database.close();
        return new Recipient(context, id, firstName, lastName);
    }

    protected static Recipient[] all(Context context) {
        ArrayList<Recipient> recipients = new ArrayList<>();
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        String tableName = databaseHelper.getUsersTableName();
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        Recipient recipient;
        int id;

        Cursor cursor = database.rawQuery(
                String.format("SELECT ID FROM %s;", tableName), null
        );

        while (cursor.moveToNext()) {
            id = cursor.getInt(0);
            recipient = find(context, id);
            recipients.add(recipient);
        }

        cursor.close();
        database.close();
        return recipients.toArray(new Recipient[recipients.size()]);
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
            values.put(DatabaseHelper.FIRST_NAME, mFirstName);
            values.put(DatabaseHelper.LAST_NAME, mLastName);
            long result = database.insert(mTableName, null, values);
            database.close();
            return result != -1;
        }
    }

    private boolean validatesPresence() {
        String[] attributes = {mFirstName, mLastName};

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
