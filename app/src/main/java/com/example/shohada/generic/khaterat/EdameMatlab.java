package com.example.shohada.generic.khaterat;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shohada.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class EdameMatlab extends AppCompatActivity {


    TextView txt_titleKhatere,txt_ravi,txt_khatere;
    ImageView img_shahid_khaterat;

    String nameRavi,description,title;


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
        setContentView(R.layout.activity_edame_matlab);

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

        Bundle bundle = getIntent().getExtras();
        nameRavi = bundle.getString("name");
        description = bundle.getString("Description");
        title = bundle.getString("title");


        finds();
        setData();


    }

    private void setData() {

        txt_titleKhatere.setText(title);
        txt_ravi.setText(nameRavi);
        txt_khatere.setText(description);

    }

    private void finds() {

        txt_titleKhatere = (TextView)findViewById(R.id.txt_titleKhatere);
        txt_ravi = (TextView)findViewById(R.id.txt_ravi);
        txt_khatere = (TextView)findViewById(R.id.txt_khatere);
        img_shahid_khaterat = (ImageView) findViewById(R.id.img_shahid_khaterat);

    }
}
