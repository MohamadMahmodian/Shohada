package com.example.shohada.generic;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shohada.R;
import com.example.shohada.generic.gallery.Gallery;
import com.example.shohada.generic.biogerafi.Biogerafi;
import com.example.shohada.generic.khaterat.Khaterat;

import java.util.ArrayList;

import static com.example.shohada.R.drawable.img_rahbar;

public class AdapterListShahidan extends RecyclerView.Adapter<AdapterListShahidan.MyViewHolder>{


    ArrayList<ModelShahid> modelTahmilyList;
    Context context;
    public AdapterListShahidan(ArrayList<ModelShahid> modelTahmilyList, Context context)
    {
        this.context = context;
        this.modelTahmilyList = modelTahmilyList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_tahmily,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i)
    {
        try
        {
            final ModelShahid modelTahmily = modelTahmilyList.get(i);

            myViewHolder.img_shahid.setBackgroundResource(img_rahbar);

            myViewHolder.name.setText(modelTahmily.getName());
            myViewHolder.family.setText(modelTahmily.getFamily());
            myViewHolder.nameFather.setText(modelTahmily.getFatherName());
            myViewHolder.type.setText(modelTahmily.getTaypee());

            myViewHolder.img_shahid.setImageResource(R.drawable.splash_sameni);

            myViewHolder.biography.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    context.startActivity(new Intent(context, Biogerafi.class));
                }
            });
            myViewHolder.gallery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    context.startActivity(new Intent(context, Gallery.class));
                }
            });
            myViewHolder.khaterat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    context.startActivity(new Intent(context, Khaterat.class));
                }
            });
        }
        catch (Exception e)
        {

        }

    }

    @Override
    public int getItemCount()
    {
        return modelTahmilyList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        Button biography, gallery, khaterat;
        TextView name, family, nameFather, type;
        ImageView img_shahid;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.txt_name);
            family = (TextView) itemView.findViewById(R.id.txt_family);
            nameFather = (TextView) itemView.findViewById(R.id.txt_name_father);
            type = (TextView) itemView.findViewById(R.id.txt_type);
            biography = (Button) itemView.findViewById(R.id.btn_zendeginame);
            gallery = (Button) itemView.findViewById(R.id.btn_gallery);
            khaterat = (Button) itemView.findViewById(R.id.btn_khaterat);

            img_shahid = (ImageView) itemView.findViewById(R.id.img_shahid_tahmily);
        }
    }

}
