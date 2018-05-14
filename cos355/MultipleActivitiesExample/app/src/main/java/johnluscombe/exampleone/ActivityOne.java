package johnluscombe.exampleone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ActivityOne extends Activity {
    private static final String TAG = "ActivityOne";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        Log.d(TAG, "onCreate called");
    }

    protected void goToNextActivity(View v) {
        Log.d(TAG, "goToNextActivity called");

        Intent launchNextActivity = new Intent(getApplicationContext(), ActivityTwo.class);
        startActivity(launchNextActivity);
    }
}
