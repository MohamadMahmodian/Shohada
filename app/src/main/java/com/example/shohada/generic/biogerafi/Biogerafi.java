package com.example.shohada.generic.biogerafi;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.shohada.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Biogerafi extends AppCompatActivity {

    TextView txt_country,txt_city,txt_incity,txt_area,txt_birthdate,txt_deathdate,txt_degree,txt_areadeath,txt_zendeginame;

    @Override
    protected void attachBaseContext(Context newBase){
        try{
            super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biography_tahmily);

        //<editor-fold desc="back_page">
        ConstraintLayout txt_back = (ConstraintLayout)findViewById(R.id.toolbar_back);
        txt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                finish();
            }
        });
        //</editor-fold>

        finds();

    }

    private void finds() {

        txt_country = (TextView)findViewById(R.id.txt_country);
        txt_city = (TextView)findViewById(R.id.txt_city);
        txt_incity = (TextView)findViewById(R.id.txt_incity);
        txt_area = (TextView)findViewById(R.id.txt_area);
        txt_birthdate = (TextView)findViewById(R.id.txt_birthdate);
        txt_deathdate = (TextView)findViewById(R.id.txt_deathdate);
        txt_degree = (TextView)findViewById(R.id.txt_degree);
        txt_areadeath = (TextView)findViewById(R.id.txt_areadeath);
        txt_zendeginame = (TextView)findViewById(R.id.txt_zendeginame);

    }
}
