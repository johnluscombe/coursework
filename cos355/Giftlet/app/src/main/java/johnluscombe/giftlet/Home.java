package johnluscombe.giftlet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setToolbar();
        setRecipientClickListeners();
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.home_toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
    }

    private void setRecipientClickListeners() {
        ListView recipients = (ListView)findViewById(R.id.recipients);
        recipients.setOnItemClickListener(new ListView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
                Intent launchRecipientGiftsActivity = new Intent(
                        getApplicationContext(), RecipientGifts.class
                );
                startActivity(launchRecipientGiftsActivity);
            }
        });
    }
}
