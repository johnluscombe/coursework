package com.example.johnluscombe.audioplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public final static File DOWNLOADS_URI = Environment
            .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

    public Button fileButton;
    public Button storageButton;
    public ArrayList<File> musicFiles;
    public MediaPlayer mediaPlayerForFile;
    public MediaPlayer mediaPlayerForStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fileButton = (Button)findViewById(R.id.fileSound);
        storageButton = (Button)findViewById(R.id.storageSound);
        musicFiles = new ArrayList<>();
        mediaPlayerForFile = MediaPlayer.create(getApplicationContext(), R.raw.audio);
        mediaPlayerForStorage = new MediaPlayer();
        mediaPlayerForStorage.setAudioStreamType(AudioManager.STREAM_MUSIC);
        setFileSoundButton();
        setRandomSoundButton();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayerForFile.release();
        mediaPlayerForStorage.release();
    }

    private void setFileSoundButton() {
        fileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playFileMusicFile();
            }
        });
    }

    private void setRandomSoundButton() {
        for (File file : DOWNLOADS_URI.listFiles()) {
            String type = null;
            String extension = MimeTypeMap.getFileExtensionFromUrl(file.getPath());
            if (extension != null) {
                type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            }
            if (type != null && type.substring(0,5).equals("audio")) {
                musicFiles.add(file);
            }
        }

        if (DOWNLOADS_URI.listFiles().length == 0) {
            storageButton.setEnabled(false);
        } else {
            File file = getRandomFile(musicFiles);

            try {
                mediaPlayerForStorage.setDataSource(getApplicationContext(),
                        Uri.parse(file.getPath()));
                mediaPlayerForStorage.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }

            storageButton.setText(R.string.play_random_sound);
            storageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playStorageMusicFile();
                }
            });
        }
    }

    private File getRandomFile(ArrayList<File> musicFiles) {
        Random random = new Random();
        int num = random.nextInt(musicFiles.size());
        return musicFiles.get(num);
    }

    private void playFileMusicFile() {
        mediaPlayerForFile.start();
        fileButton.setText(R.string.pause);
        fileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseFileMusicFile();
            }
        });
    }

    private void playStorageMusicFile() {
        mediaPlayerForStorage.start();
        storageButton.setText(R.string.pause);
        storageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseStorageMusicFile();
            }
        });
    }

    private void pauseFileMusicFile() {
        mediaPlayerForFile.pause();
        fileButton.setText(R.string.play_sound_from_resource_file);
        fileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playFileMusicFile();
            }
        });
    }

    private void pauseStorageMusicFile() {
        mediaPlayerForStorage.pause();
        storageButton.setText(R.string.play_random_sound);
        storageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playStorageMusicFile();
            }
        });
    }
}
