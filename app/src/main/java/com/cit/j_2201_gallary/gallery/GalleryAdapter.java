package com.cit.j_2201_gallary.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cit.j_2201_gallary.R;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryViewHolder> {
    Context context;

    List<Gallery> galleryList;


    public GalleryAdapter(final Context context, final List<Gallery> galleryList) {
        this.context = context;
        this.galleryList = galleryList;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);

        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GalleryViewHolder holder, final int position) {

        Gallery gallery= galleryList.get(position);

        holder.g_image_name.setText(gallery.getName());
        holder.g_image.setImageURI(gallery.getImageUri());





    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }
}
