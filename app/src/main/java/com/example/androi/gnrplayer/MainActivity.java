package com.example.androi.gnrplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private ImageButton playView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.gnr_you_could_be_mine);

        playView = (ImageButton) findViewById(R.id.play);
        playView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    Toast.makeText(MainActivity.this, "Pause", Toast.LENGTH_SHORT).show();
                    mediaPlayer.pause();
                    playView.setImageResource(R.drawable.ic_av_play_arrow);

                } else {
                    Toast.makeText(MainActivity.this, "Play", Toast.LENGTH_SHORT).show();
                    mediaPlayer.start();
                    playView.setImageResource(R.drawable.ic_av_pause);
                }
            }
        });

        ImageButton ffView = (ImageButton) findViewById(R.id.ff);
        ffView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Fast Foward", Toast.LENGTH_SHORT).show();
                if (mediaPlayer.getCurrentPosition() + 1000 < mediaPlayer.getDuration()) {
                    mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 1000);
                }
            }
        });

        ImageButton rewView = (ImageButton) findViewById(R.id.rew);
        rewView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Rewind", Toast.LENGTH_SHORT).show();
                if (mediaPlayer.getCurrentPosition() > 1000) {
                    mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() - 1000);
                }
            }
        });
    }
}
