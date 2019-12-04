package com.example.shohada.generic.gallery.selectedImage;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.shohada.R;
import com.example.shohada.generic.gallery.AdapterGallery;
import com.example.shohada.generic.gallery.Gallery;

import java.util.ArrayList;

public class AdapterSelectedImage extends RecyclerView.Adapter<AdapterSelectedImage.ViewHolder>{


    ArrayList<ModelSelectedImage>  selectedImagesList = new ArrayList<>();
    Context context;
    Gallery activity;

    public AdapterSelectedImage(ArrayList<ModelSelectedImage> selectedImagesList, Context context, Gallery activity) {
        this.selectedImagesList = selectedImagesList;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gallery_selectedimage,viewGroup,false);
        return new AdapterSelectedImage.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {


        viewHolder.img_select.setImageBitmap(selectedImagesList.get(i).getImg());

        viewHolder.cons_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedImagesList.remove(i);
                activity.adapterSelectedImage.notifyDataSetChanged();
                if (selectedImagesList.size() == 0){
                    activity.recyceler_selectedImages.setVisibility(View.GONE);
                    activity.btn_sendSelectedImage.setVisibility(View.GONE);
                    activity.cons1.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return selectedImagesList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img_select;
        ConstraintLayout cons_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_select = itemView.findViewById(R.id.img_select);
            cons_delete = itemView.findViewById(R.id.cons_delete);

        }
    }
}
