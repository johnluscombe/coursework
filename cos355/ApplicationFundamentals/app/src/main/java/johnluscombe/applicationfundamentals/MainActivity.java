package johnluscombe.applicationfundamentals;

import android.app.WallpaperManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import layout.MyService;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setJokeButton();
        setUselessWebsiteButton();
        setWallpaperButton();
    }

    protected void setJokeButton() {
        Button startServiceButton = (Button)findViewById(R.id.startService);
        startServiceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent startJokeServiceIntent = new Intent(getApplicationContext(), MyService.class);
                startService(startJokeServiceIntent);
            }
        });
    }

    protected void setUselessWebsiteButton() {
        Button launchUselessWebsiteButton = (Button)findViewById(R.id.openWebsite);
        launchUselessWebsiteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url = "http://www.theuselessweb.com";
                Intent launchUselessWebsiteIntent = new Intent(Intent.ACTION_VIEW);
                launchUselessWebsiteIntent.setData(Uri.parse(url));
                startActivity(launchUselessWebsiteIntent);
            }
        });
    }

    protected void setWallpaperButton() {
        Button setWallpaperButton = (Button)findViewById(R.id.setWallpaper);
        setWallpaperButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

                try {
                    wallpaperManager.setResource(+ R.drawable.best_stanley_photo);
                } catch (IOException error) {
                    Log.e(TAG, error.getMessage());
                }
            }
        });
    }
}
