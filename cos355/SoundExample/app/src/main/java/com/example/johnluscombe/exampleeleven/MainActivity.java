package com.example.johnluscombe.exampleeleven;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button play, pause;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = (Button)findViewById(R.id.play);
        pause = (Button)findViewById(R.id.pause);
        mp = MediaPlayer.create(getApplicationContext(), R.raw.great_escape);
    }

    public void playFile(View view) {
        mp.start();
        play.setEnabled(false);
        pause.setEnabled(true);
    }

    public void pauseFile(View view) {
        mp.pause();
        play.setEnabled(true);
        pause.setEnabled(false);
    }
}
