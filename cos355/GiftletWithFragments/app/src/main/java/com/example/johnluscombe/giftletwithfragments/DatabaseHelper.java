package com.example.johnluscombe.giftletwithfragments;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "giftlet";

    private static final String TABLE_USERS = "users";
    private static final String TABLE_GIFTS = "gifts";

    protected static final String ID = "ID";
    protected static final String FIRST_NAME = "first_name";
    protected static final String LAST_NAME = "last_name";
    protected static final String USERNAME = "username";
    protected static final String PASSWORD_DIGEST = "password_digest";

    protected static final String NAME = "name";
    protected static final String DESCRIPTION = "description";
    protected static final String URL = "url";
    protected static final String PRICE = "price";
    protected static final String PURCHASED = "purchased";
    protected static final String DATE_PURCHASED = "date_purchased";
    protected static final String USER_ID = "user_id";
    protected static final String PURCHASER_ID = "purchaser_id";

    private static final String CREATE_TABLE_USERS =
            String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, " +
                    "%s TEXT)", TABLE_USERS, ID, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD_DIGEST);

    private static final String CREATE_TABLE_GIFTS =
            String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, " +
                    "%s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", TABLE_GIFTS, ID, NAME,
                    DESCRIPTION, URL, PRICE, PURCHASED, DATE_PURCHASED, USER_ID, PURCHASER_ID);

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_GIFTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_GIFTS);
        onCreate(db);
    }

    public String getDbName() {
        return DATABASE_NAME;
    }

    public String getUsersTableName() {
        return TABLE_USERS;
    }

    public String getGiftsTableName() {
        return TABLE_GIFTS;
    }
}
