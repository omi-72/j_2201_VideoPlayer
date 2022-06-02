package com.cit.j_2201_gallary.audio;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cit.j_2201_gallary.R;

import java.util.concurrent.TimeUnit;

public class SimpleAudioPlayerActivity extends AppCompatActivity {

    private ImageButton  pausebtn, playbtn;

    private TextView songName, startTime, songTime;

    private Handler hdlr = new Handler();

    Intent intent;
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_audio_player);
        intent = getIntent();

        playbtn = (ImageButton) findViewById(R.id.btnPlay);
        pausebtn = (ImageButton) findViewById(R.id.btnPause);
        songName = (TextView) findViewById(R.id.txtSname);
        startTime = (TextView) findViewById(R.id.txtStartTime);
        songTime = (TextView) findViewById(R.id.txtSongTime);
        songName.setText("Baitikochi Chuste");


        Uri myUri = Uri.parse(intent.getStringExtra("audio"));


        // initialize Uri here
        mPlayer = new MediaPlayer();


        pausebtn.setEnabled(false);

        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);


                try {
                    mPlayer.setDataSource(getApplicationContext(), myUri);
                    mPlayer.prepare();


                } catch (Exception exception) {


                }
                Toast.makeText(SimpleAudioPlayerActivity.this, "Playing Audio", Toast.LENGTH_SHORT).show();
                mPlayer.start();

            }
        });

        pausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.pause();
                pausebtn.setEnabled(false);
                playbtn.setEnabled(true);
                Toast.makeText(getApplicationContext(), "Pausing Audio", Toast.LENGTH_SHORT).show();
            }
        });


    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if (mPlayer!= null){
            mPlayer.pause();
            mPlayer.stop();



        }

    }
}