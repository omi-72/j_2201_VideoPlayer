package com.cit.j_2201_gallary.audio;

import android.Manifest;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.cit.j_2201_gallary.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;
import java.util.List;

public class AudioMainActivity extends AppCompatActivity {

    List<Audio> audioList;
    RecyclerView recyclerView_image;

    ViewPager2 galleryViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimePerm();


    }

    private void runTimePerm() {
        Dexter.withContext(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        // permission is granted
                        Toast.makeText(AudioMainActivity.this, "Permission granted", Toast.LENGTH_SHORT).show();
                        // getDataAudio();

                        getDataVideo();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {

                        if (response.isPermanentlyDenied()) {

                            Toast.makeText(AudioMainActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();


    }

    private void getDataVideo() {

        audioList = new ArrayList<>();
        recyclerView_image = findViewById(R.id.recyclerView_image);
        galleryViewPager = findViewById(R.id.galleryViewPager);


        String[] projection = new String[]
                {
                        MediaStore.Video.Media._ID,
                        MediaStore.Video.Media.SIZE,
                        MediaStore.Video.Media.DATE_MODIFIED,
                        MediaStore.Video.Media.BUCKET_DISPLAY_NAME,
                        MediaStore.Video.Media.DISPLAY_NAME,

                };


        Uri contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

        Cursor cursor = getContentResolver().query(contentUri, projection, null, null, null);

        if (cursor != null) {
            cursor.moveToPosition(0);

            while (true) {

                long id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME));
                Uri audioUri = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, id);
                Uri imageUri = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, id);

                Bitmap bitmap = getThumbVideo(this, audioUri);

                Audio audio = new Audio(id, name, audioUri, bitmap);


                audioList.add(audio);


                Log.i("TAG", "Uri : " + audio.toString());


                if (!cursor.isLast()) {
                    cursor.moveToNext();
                } else {
                    break;
                }

            }

            AudioAdapter adapter = new AudioAdapter(AudioMainActivity.this, audioList);

            //galleryViewPager.setAdapter(adapter);

            recyclerView_image.setAdapter(adapter);


        }


    }

    private void getDataAudio() {

        audioList = new ArrayList<>();
        recyclerView_image = findViewById(R.id.recyclerView_image);
        galleryViewPager = findViewById(R.id.galleryViewPager);


        String[] projection = new String[]
                {
                        MediaStore.Audio.Media._ID,
                        MediaStore.Audio.Media.SIZE,
                        MediaStore.Audio.Media.DATE_MODIFIED,
                        MediaStore.Audio.Media.BUCKET_DISPLAY_NAME,
                        MediaStore.Audio.Media.DISPLAY_NAME,

                };


        Uri contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        Cursor cursor = getContentResolver().query(contentUri, projection, null, null, null);

        if (cursor != null) {
            cursor.moveToPosition(0);

            while (true) {

                long id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
                Uri audioUri = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id);
                Uri imageUri = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id);


                Audio audio = new Audio(id, name, imageUri, audioUri);


                audioList.add(audio);


                Log.i("TAG", "Uri : " + audio.toString());


                if (!cursor.isLast()) {
                    cursor.moveToNext();
                } else {
                    break;
                }

            }

            AudioAdapter adapter = new AudioAdapter(AudioMainActivity.this, audioList);

            //galleryViewPager.setAdapter(adapter);

            recyclerView_image.setAdapter(adapter);


        }


    }

    public Bitmap getThumbVideo(Context context, Uri videoUri) {
        Bitmap bitmap = null;
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(context, videoUri);
            bitmap = mediaMetadataRetriever.getFrameAtTime(1000, MediaMetadataRetriever.OPTION_CLOSEST_SYNC);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
        }
        return bitmap;
    }

}