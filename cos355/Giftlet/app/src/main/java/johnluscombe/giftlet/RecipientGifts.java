package johnluscombe.giftlet;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipientGifts extends AppCompatActivity {
    private ArrayList<String> listValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipient_gifts);
        setToolbar();
        setNewGiftButton();
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.recipient_gifts_toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
    }

    private void setNewGiftButton() {
        Button newGiftButton = (Button)findViewById(R.id.addNewGift);
        newGiftButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent launchNewGiftActivity = new Intent(
                        getApplicationContext(), NewGift.class
                );
                startActivity(launchNewGiftActivity);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getDataFromDatabase();

        if (!listValues.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout)findViewById(R.id.recipient_gift_list_container);
            TextView noDataText = (TextView)findViewById(R.id.no_data_text);
            linearLayout.removeView(noDataText);
            setListAdapter();
        }
    }

    private void getDataFromDatabase() {
        listValues = new ArrayList<>();

        String databaseName = "GiftletDB";
        String tableName = "recipient_gifts";
        DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper(
                getApplicationContext(), databaseName, tableName
        );
        SQLiteDatabase sqLiteDatabase = databaseOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                String.format("SELECT recipient_gifts FROM %s", tableName), null
        );

        while (cursor.moveToNext()) {
            listValues.add(cursor.getString(0));
        }

        cursor.close();
        sqLiteDatabase.close();
    }

    private void setListAdapter() {
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.recipient_gift, listValues);
        ListView recipientGiftListView = (ListView)findViewById(R.id.recipient_gift_list_view);
        recipientGiftListView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
    }
}
