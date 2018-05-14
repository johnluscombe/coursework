package com.example.johnluscombe.exampletwelve;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback,
                                                               MediaPlayer.OnCompletionListener {

    private Button play, pause;
    private MediaPlayer mp;
    private SurfaceView canvas;
    private SurfaceHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button)findViewById(R.id.play);
        pause = (Button)findViewById(R.id.pause);
        pause.setEnabled(false);
        canvas = (SurfaceView)findViewById(R.id.surfaceView);

        mp = MediaPlayer.create(getApplicationContext(), R.raw.me);
        holder = canvas.getHolder();
        holder.addCallback(this);
        mp.setOnCompletionListener(this);
    }

    public void playFile(View v) {
        mp.start();
        pause.setEnabled(true);
        play.setEnabled(false);
    }

    public void pauseFile(View v) {
        mp.pause();
        pause.setEnabled(false);
        play.setEnabled(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mp.setDisplay(holder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {}

    @Override
    public void onCompletion(MediaPlayer mp) {
        pause.setEnabled(false);
        play.setEnabled(true);
    }
}
