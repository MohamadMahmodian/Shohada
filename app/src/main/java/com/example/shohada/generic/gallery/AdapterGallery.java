package com.example.shohada.generic.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.shohada.R;

import java.util.ArrayList;

public class AdapterGallery extends RecyclerView.Adapter<AdapterGallery.ViewHolder> {

    ArrayList<Integer> arrayGallery = new ArrayList<>();
    Context context;
    Activity activity;


    public AdapterGallery(ArrayList<Integer> arrayGallery, Context context, Activity activity) {
        this.arrayGallery = arrayGallery;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gallery,viewGroup,false);
        return new AdapterGallery.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        viewHolder.img_shahid_gallery.setImageResource(arrayGallery.get(i));

        viewHolder.img_shahid_gallery.setTag(arrayGallery.get(i));
        viewHolder.img_shahid_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int position = (Integer) viewHolder.img_shahid_gallery.getTag();
                Intent intent = new Intent(activity.getApplicationContext(),PreviewImage.class);
                intent.putExtra("positionImage",position);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayGallery.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img_shahid_gallery;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_shahid_gallery = itemView.findViewById(R.id.img_select);

        }
    }
}
