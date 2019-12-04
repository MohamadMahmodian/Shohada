package com.example.shohada.meuNavigationDrawer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shohada.R;

public class Setting extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    public SwitchPreference Pref_qoran;
    public SwitchPreference Pref_music;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);
//        setBackgroundResource(R.drawable.image12);

        Pref_qoran = (SwitchPreference) findPreference("switch_qoran");
        Pref_music = (SwitchPreference) findPreference("switch_music");
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key)
    {

    }

}
