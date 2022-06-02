package com.cit.j_2201_gallary.audio;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cit.j_2201_gallary.R;

import java.util.List;

public class AudioAdapter extends RecyclerView.Adapter<AudioViewHolder> {
    Context context;

    List<Audio> audioList;


    public AudioAdapter(final Context context, final List<Audio> audioList) {
        this.context = context;
        this.audioList = audioList;
    }

    @NonNull
    @Override
    public AudioViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_audio, parent, false);

        return new AudioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AudioViewHolder holder, final int position) {

        Audio audio = audioList.get(position);

        holder.g_image_name.setText(audio.getName());

        holder.g_image.setImageBitmap(audio.getBitmap());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {


                Intent intent = new Intent(context, SimpleVideoPlayerActivity.class);
                intent.putExtra("audio", "" + audio.getAudioUri());

                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return audioList.size();
    }
}
