package com.example.johnluscombe.exampleeight;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends Activity {
    private ImageView imageView;
    private String imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.mug);
    }

    @Override
    protected void onResume() {
        super.onResume();
        imageView.setImageBitmap(BitmapFactory.decodeFile(imagePath));
        imageView.invalidate();
    }

    private File createImageFile() throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File storageDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(timestamp, ".jpg", storageDirectory);
        imagePath = image.getAbsolutePath();
        return image;
    }

    public void activateCamera(View v) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File photoFile = null;

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            try {
                photoFile = createImageFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (photoFile != null) {
                Uri imageUri = FileProvider.getUriForFile(
                        getApplicationContext(), "com.example.fileprovider", photoFile
                );
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(takePictureIntent, 1);
            }
        }
    }
}
