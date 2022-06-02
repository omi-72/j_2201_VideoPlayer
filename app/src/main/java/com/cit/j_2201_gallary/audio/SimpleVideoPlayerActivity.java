package com.cit.j_2201_gallary.audio;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.cit.j_2201_gallary.R;

public class SimpleVideoPlayerActivity extends AppCompatActivity {


    Intent intent;

    VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        intent = getIntent();
        videoView = findViewById(R.id.videoView);
        Uri myUri = Uri.parse(intent.getStringExtra("audio"));

        videoView.setVideoURI(myUri);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(final MediaPlayer mediaPlayer) {

                mediaPlayer.start();
            }


        });

        videoView.setMediaController(new MediaController(this));




    }


}