package com.cit.j_2201_gallary.audio;

import android.graphics.Bitmap;
import android.net.Uri;



public class Audio {

    private long id;
    private String name;
    private Uri imageUri;
    private Uri audioUri;

    private Bitmap bitmap;

    public Audio(final long id, final String name, final Uri audioUri, final Bitmap bitmap) {
        this.id = id;
        this.name = name;
        this.audioUri = audioUri;
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(final Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Audio(final long id, final String name, final Uri imageUri, final Uri audioUri) {
        this.id = id;
        this.name = name;
        this.imageUri = imageUri;
        this.audioUri = audioUri;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(final Uri imageUri) {
        this.imageUri = imageUri;
    }

    public Uri getAudioUri() {
        return audioUri;
    }

    public void setAudioUri(final Uri audioUri) {
        this.audioUri = audioUri;
    }
}
