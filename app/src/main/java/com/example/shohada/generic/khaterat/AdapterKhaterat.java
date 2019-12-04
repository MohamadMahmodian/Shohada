package com.example.shohada.generic.khaterat;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.shohada.R;
import com.example.shohada.generic.gallery.AdapterGallery;

import java.util.ArrayList;

public class AdapterKhaterat extends RecyclerView.Adapter<AdapterKhaterat.ViewHolder> {


    ArrayList<ModelKhaterat> arrayListKhaterat = new ArrayList<>();
    Context context;
    Khaterat khaterat;

    public AdapterKhaterat(ArrayList<ModelKhaterat> arrayListKhaterat, Context context, Khaterat khaterat) {
        this.arrayListKhaterat = arrayListKhaterat;
        this.context = context;
        this.khaterat = khaterat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_khaterat,viewGroup,false);
        return new AdapterKhaterat.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {


        String s = arrayListKhaterat.get(i).getDescription().substring(0,70);
        viewHolder.txt_khatere.setText(s + "...");
        viewHolder.txt_ravi.setText(arrayListKhaterat.get(i).getName_ravi());
        viewHolder.txt_titleKhatere.setText(arrayListKhaterat.get(i).getTitle());

        viewHolder.btn_edameMatlab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,EdameMatlab.class);
                intent.putExtra("title",arrayListKhaterat.get(i).getTitle());
                intent.putExtra("name",arrayListKhaterat.get(i).getName_ravi());
                intent.putExtra("Description",arrayListKhaterat.get(i).getDescription());
                khaterat.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayListKhaterat.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView txt_titleKhatere,txt_ravi,txt_khatere;
        Button  btn_edameMatlab;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_khatere = itemView.findViewById(R.id.txt_khatere);
            txt_ravi = itemView.findViewById(R.id.txt_ravi);
            txt_titleKhatere = itemView.findViewById(R.id.txt_titleKhatere);
            btn_edameMatlab = itemView.findViewById(R.id.btn_edameMatlab);

        }
    }
}
