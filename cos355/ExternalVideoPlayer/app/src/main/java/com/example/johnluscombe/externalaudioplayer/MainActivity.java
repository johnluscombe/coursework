package com.example.johnluscombe.externalaudioplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback,
                                                               MediaPlayer.OnCompletionListener {

    private Button playButton, pauseButton;
    private MediaPlayer mediaPlayer;
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = (Button)findViewById(R.id.playButton);
        pauseButton = (Button)findViewById(R.id.pauseButton);
        pauseButton.setEnabled(false);
        surfaceView = (SurfaceView)findViewById(R.id.surfaceView);

        String url = "https://www.youtube.com/watch?v=AK-AjJzr2Z4";
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                playFile();
            }
        });

        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        mediaPlayer.setOnCompletionListener(this);
    }

    public void playFile() {
        mediaPlayer.start();
        pauseButton.setEnabled(true);
        playButton.setEnabled(false);
    }

    public void pauseFile() {
        mediaPlayer.pause();
        pauseButton.setEnabled(false);
        playButton.setEnabled(true);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        pauseButton.setEnabled(false);
        playButton.setEnabled(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mediaPlayer.setDisplay(surfaceHolder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mediaPlayer.release();
    }
}
