package com.example.johnluscombe.examplenine;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    LocationManager locationManager;
    Location current;
    TextView loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        loc = (TextView)findViewById(R.id.loc);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<String> providers = locationManager.getProviders(true);

        try {
            for (String provider : providers) {
                Location temporaryLocation = locationManager.getLastKnownLocation(provider);

                if (temporaryLocation != null) {
                    if (current == null || temporaryLocation.getAccuracy() < current.getAccuracy()) {
                        current = temporaryLocation;
                    }
                }
            }
        } catch(SecurityException e) {}

        if (current != null) {
            loc.setText(current.getLatitude() + ", " + current.getLongitude());
        }
    }

    public void mapIt(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse("geo:" + current.getLatitude() + "," + current.getLongitude());
        intent.setData(uri);
        startActivity(intent);
    }
}
