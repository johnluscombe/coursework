package johnluscombe.giftlet;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewGift extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_gift);
        setToolbar();
        setSaveButton();
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.new_gift_toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
    }

    private void setSaveButton() {
        Button saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText giftNameEditText = (EditText)findViewById(R.id.gift_name);
                String giftName = giftNameEditText.getText().toString();
                addGiftToDatabase(giftName);
                finish();
            }
        });
    }

    private void addGiftToDatabase(String giftName) {
        String databaseName = "GiftletDB";
        String tableName = "recipient_gifts";
        DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper(
                getApplicationContext(), databaseName, tableName
        );
        SQLiteDatabase sqLiteDatabase = databaseOpenHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("recipient_gifts", giftName);
        sqLiteDatabase.insert(tableName, null, values);
        sqLiteDatabase.close();
    }
}
