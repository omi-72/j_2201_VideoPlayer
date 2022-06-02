package com.cit.j_2201_gallary.gallery;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cit.j_2201_gallary.R;

public class GalleryViewHolder extends RecyclerView.ViewHolder {

    ImageView g_image;
    TextView g_image_name;

    public GalleryViewHolder(@NonNull final View itemView) {
        super(itemView);


        g_image = itemView.findViewById(R.id.g_image);
        g_image_name = itemView.findViewById(R.id.g_image_name);


    }
}
