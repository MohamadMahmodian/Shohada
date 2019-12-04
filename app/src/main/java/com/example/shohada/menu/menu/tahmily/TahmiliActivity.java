package com.example.shohada.menu.menu.tahmily;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.example.shohada.R;
import com.example.shohada.generic.AdapterListShahidan;
import com.example.shohada.generic.ModelShahid;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class TahmiliActivity extends AppCompatActivity {

    ConstraintLayout consSearch,img_search_tahmily,consBack,toolbar;
    EditText editSearch;
    RecyclerView list_nameShohada;

    ArrayList<ModelShahid> modelTahmiliesi;
    AdapterListShahidan adapterTahmily;

    RecyclerView recyclerView;


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
        setContentView(R.layout.activity_tahmili);

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
        modelTahmiliesi = new ArrayList<>();
        set_Data();

        adapterTahmily = new AdapterListShahidan(modelTahmiliesi, TahmiliActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(TahmiliActivity.this));
        recyclerView.setAdapter(adapterTahmily);

        handelSearch();
    }

    private void set_Data()
    {
        modelTahmiliesi.add(new ModelShahid("مهدی","حسینی","جعفر","جوادآباد"));
        modelTahmiliesi.add(new ModelShahid("حسین","جعفری","غلام","حسین آباد"));
        modelTahmiliesi.add(new ModelShahid("علی","غلامی","محسن","ورامین"));
        modelTahmiliesi.add(new ModelShahid("محسن","رسولی","سعید","ورامین"));
        modelTahmiliesi.add(new ModelShahid("مهدی","حسینی","جعفر","جوادآباد"));
        modelTahmiliesi.add(new ModelShahid("مهدی","حسینی","جعفر","جوادآباد"));
        modelTahmiliesi.add(new ModelShahid("مهدی","حسینی","جعفر","جوادآباد"));
        modelTahmiliesi.add(new ModelShahid("حسین","جعفری","غلام","حسین آباد"));
        modelTahmiliesi.add(new ModelShahid("علی","غلامی","محسن","ورامین"));
        modelTahmiliesi.add(new ModelShahid("محسن","رسولی","سعید","ورامین"));
        modelTahmiliesi.add(new ModelShahid("مهدی","حسینی","جعفر","جوادآباد"));
        modelTahmiliesi.add(new ModelShahid("مهدی","حسینی","جعفر","جوادآباد"));
        modelTahmiliesi.add(new ModelShahid("مهدی","حسینی","جعفر","جوادآباد"));
        modelTahmiliesi.add(new ModelShahid("حسین","جعفری","غلام","حسین آباد"));
        modelTahmiliesi.add(new ModelShahid("علی","غلامی","محسن","ورامین"));
        modelTahmiliesi.add(new ModelShahid("محسن","رسولی","سعید","ورامین"));
        modelTahmiliesi.add(new ModelShahid("مهدی","حسینی","جعفر","جوادآباد"));
        modelTahmiliesi.add(new ModelShahid("مهدی","حسینی","جعفر","جوادآباد"));
        modelTahmiliesi.add(new ModelShahid("مهدی","حسینی","جعفر","جوادآباد"));
        modelTahmiliesi.add(new ModelShahid("حسین","جعفری","غلام","حسین آباد"));
        modelTahmiliesi.add(new ModelShahid("علی","غلامی","محسن","ورامین"));
        modelTahmiliesi.add(new ModelShahid("محسن","رسولی","سعید","ورامین"));
        modelTahmiliesi.add(new ModelShahid("مهدی","حسینی","جعفر","جوادآباد"));
        modelTahmiliesi.add(new ModelShahid("مهدی","حسینی","جعفر","جوادآباد"));
        modelTahmiliesi.add(new ModelShahid("مهدی","حسینی","جعفر","جوادآباد"));
        modelTahmiliesi.add(new ModelShahid("حسین","جعفری","غلام","حسین آباد"));
        modelTahmiliesi.add(new ModelShahid("علی","غلامی","محسن","ورامین"));
        modelTahmiliesi.add(new ModelShahid("محسن","رسولی","سعید","ورامین"));
        modelTahmiliesi.add(new ModelShahid("مهدی","حسینی","جعفر","جوادآباد"));
        modelTahmiliesi.add(new ModelShahid("مهدی","حسینی","جعفر","جوادآباد"));
        modelTahmiliesi.add(new ModelShahid("مهدی","حسینی","جعفر","جوادآباد"));
        modelTahmiliesi.add(new ModelShahid("حسین","جعفری","غلام","حسین آباد"));
        modelTahmiliesi.add(new ModelShahid("علی","غلامی","محسن","ورامین"));
        modelTahmiliesi.add(new ModelShahid("محسن","رسولی","سعید","ورامین"));
        modelTahmiliesi.add(new ModelShahid("مهدی","حسینی","جعفر","جوادآباد"));
        modelTahmiliesi.add(new ModelShahid("مهدی","حسینی","جعفر","جوادآباد"));

    }

    private void finds()
    {
        recyclerView = (RecyclerView) findViewById(R.id.list_nameShohada);
        toolbar = (ConstraintLayout) findViewById(R.id.toolbar);
        img_search_tahmily = (ConstraintLayout) findViewById(R.id.img_search);
        consSearch = (ConstraintLayout) findViewById(R.id.includeSearch);
        consBack = (ConstraintLayout) findViewById(R.id.cons_back);
        editSearch = (EditText) findViewById(R.id.editSearch);
        list_nameShohada = (RecyclerView) findViewById(R.id.list_nameShohada);

    }

    private void handelSearch() {

        consSearch.setVisibility(View.INVISIBLE);
        img_search_tahmily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toolbar.setVisibility(View.INVISIBLE);
                consSearch.setVisibility(View.VISIBLE);
            }
        });
        consBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consSearch.setVisibility(View.INVISIBLE);
                toolbar.setVisibility(View.VISIBLE);
            }
        });

    }
}
