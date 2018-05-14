package johnluscombe.exampleone;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ActivityThree extends Activity {
    private static final String TAG = "ActivityThree";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
    }

    protected void goToNextActivity() {
        Log.d(TAG, "goToNextActivity called");
    }
}
