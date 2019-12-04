package com.example.shohada;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SplashActivity extends AppCompatActivity {

    MediaPlayer player;
    boolean is_play = true;

    @Override
    protected void attachBaseContext(Context newBase) {
        try {
            super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //<editor-fold desc="CalligraphyConfig">
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/iransans_regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        //</editor-fold>

    }

    private void config_sound_qoran()
    {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        boolean test = sharedPreferences.getBoolean("switch_qoran", true);

        if (test == true)
        {
            player = MediaPlayer.create(this, R.raw.aye);
            player.start();
            is_play = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    finish();
                }
            },15000);
        }
        else
            {
                is_play = false;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this,MainActivity.class));
                        finish();
                    }
                },5000);
            }

    }

    @Override
    protected void onResume() {
        super.onResume();
        config_sound_qoran();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (is_play == true)
        {
            player.stop();
        }
    }
}
