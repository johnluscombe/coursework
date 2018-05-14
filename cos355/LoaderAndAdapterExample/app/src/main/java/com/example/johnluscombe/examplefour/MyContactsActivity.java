package com.example.johnluscombe.examplefour;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MyContactsActivity extends AppCompatActivity {

    private SimpleCursorAdapter adapter;

    private LoaderManager.LoaderCallbacks<Cursor> contactsLoader = new LoaderManager.LoaderCallbacks<Cursor>() {
        @Override
        public Loader<Cursor> onCreateLoader(int id, Bundle args) {
            String[] fields = {
                    ContactsContract.Contacts._ID,
                    ContactsContract.Contacts.DISPLAY_NAME,
                    ContactsContract.CommonDataKinds.Email.ADDRESS
            };

            return new CursorLoader(getApplicationContext(), ContactsContract.Contacts.CONTENT_URI,
                    fields, null, null, null);
        }

        @Override
        public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
            adapter.swapCursor(data);
        }

        @Override
        public void onLoaderReset(Loader<Cursor> loader) {
            adapter.swapCursor(null);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_contacts);

        String[] from = {
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Email.ADDRESS
        };

        int[] to = { R.id.display_name, R.id.email };

        adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.contact_list_item,
                null, from, to, 0);

        ListView contact_list = (ListView)findViewById(R.id.contact_list);
        contact_list.setAdapter(adapter);

        getSupportLoaderManager().initLoader(42, new Bundle(), contactsLoader);
    }
}
