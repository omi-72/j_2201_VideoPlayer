package com.cit.j_2201_gallary.gallery;

import android.net.Uri;

public class Gallery {

    long id;
    String name;
    Uri imageUri;

    public Gallery(final long id, final String name, final Uri imageUri) {
        this.id = id;
        this.name = name;
        this.imageUri = imageUri;
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

    @Override
    public String toString() {
        return "Gallery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUri=" + imageUri +
                '}';
    }
}
