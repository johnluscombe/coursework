package com.example.johnluscombe.exampleten;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView greeting = (TextView) findViewById(R.id.greeting);
        img = (ImageView)findViewById(R.id.myimg);

        Intent intent = getIntent();
        String urlstr = intent.getStringExtra(Intent.EXTRA_TEXT);

        if (urlstr != null) {
            greeting.setText(urlstr);
            new DownloadTask().execute(urlstr);
        }
    }

    private class DownloadTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            img.setImageBitmap(bitmap);
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                URLConnection connection = url.openConnection();
                connection.connect();

                InputStream inputStream = connection.getInputStream();
                return BitmapFactory.decodeStream(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
