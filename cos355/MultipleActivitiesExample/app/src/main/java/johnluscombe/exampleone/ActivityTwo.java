package johnluscombe.exampleone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityTwo extends Activity {
    private static final String TAG = "ActivityTwo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Button startActivityThree = (Button)findViewById(R.id.startActivityThree);
        startActivityThree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToNextActivity();
            }
        });
    }

    protected void goToNextActivity() {
        Log.d(TAG, "goToNextActivity called");

        Intent launchNextActivity = new Intent(getApplicationContext(), ActivityThree.class);
        startActivity(launchNextActivity);
    }
}
