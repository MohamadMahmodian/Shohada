package com.example.shohada.generic.khaterat;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.shohada.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class AddKhatere extends AppCompatActivity {


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
        setContentView(R.layout.activity_add_khatere);

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
    }
}
