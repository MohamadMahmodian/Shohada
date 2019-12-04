package com.example.shohada;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.Button;

import com.bumptech.glide.request.RequestOptions;
import com.example.shohada.menu.menu.modafeaneHaram.HaramActivity;
import com.example.shohada.menu.menu.Khordad.KhordadActivity;
import com.example.shohada.menu.menu.tahmily.TahmiliActivity;
import com.example.shohada.meuNavigationDrawer.AboutMe;
import com.example.shohada.meuNavigationDrawer.Setting;
import com.glide.slider.library.Animations.DescriptionAnimation;
import com.glide.slider.library.SliderLayout;
import com.glide.slider.library.SliderTypes.BaseSliderView;
import com.glide.slider.library.SliderTypes.TextSliderView;
import com.glide.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener,
         NavigationView.OnNavigationItemSelectedListener {

    private SliderLayout mDemoSlider;
    MediaPlayer player;

    boolean is_play = true;

    Button btn_openNavigation;
    Button btn_mute,btn_voice;
    CardView btn_modafeaneHaram,btn_jangeTahmili,btn_15Khordad;

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
        setContentView(R.layout.activity_main);

        finds();
        //startActivity(new Intent(MainActivity.this,SplashActivity.class));
        player = MediaPlayer.create(getApplicationContext(),R.raw.boye_pirahan_yousef);
        onClicks();
        slideShow();


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        btn_voice.setVisibility(View.GONE);
        animation_btn();

    }

    private void animation_btn()
    {
        CountDownTimer downTimer = new CountDownTimer(3500,500)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                int time = (int) millisUntilFinished / 500;


                switch(time)
                {
                    case 3:

                        btn_jangeTahmili.setVisibility(View.VISIBLE);
                        break;
                    case 2:

                        btn_modafeaneHaram.setVisibility(View.VISIBLE);
                        break;
                    case 1:

                        btn_15Khordad.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onFinish()
            {

            }
        }.start();
    }
    private void onClicks() {

        btn_openNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                if (!drawer.isDrawerOpen(GravityCompat.END)) {
                    drawer.openDrawer(GravityCompat.END);
                }
            }
        });


        btn_voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_mute.setVisibility(View.VISIBLE);
                btn_voice.setVisibility(View.GONE);
                player = MediaPlayer.create(getApplicationContext(),R.raw.boye_pirahan_yousef);
                player.start();
                is_play = true;

            }
        });

        btn_mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_mute.setVisibility(View.GONE);
                btn_voice.setVisibility(View.VISIBLE);
                player.stop();
                is_play = false;
            }
        });

        btn_jangeTahmili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, TahmiliActivity.class));
            }
        });
        btn_modafeaneHaram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, HaramActivity.class));
            }
        });
        btn_15Khordad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, KhordadActivity.class));
            }
        });
    }

    private void finds()
    {
        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        btn_modafeaneHaram = (CardView) findViewById(R.id.btn_Menu_modafeaneHaram);
        btn_jangeTahmili = (CardView) findViewById(R.id.btn_Menu_tahmili);
        btn_15Khordad = (CardView) findViewById(R.id.btn_Menu_15khordad);
        btn_openNavigation = (Button) findViewById(R.id.btn_openNavigation);
        btn_voice = (Button) findViewById(R.id.btn_voice);
        btn_mute = (Button) findViewById(R.id.btn_mute);
    }

    private void slideShow()
    {

        ArrayList<Integer> listUrl = new ArrayList<>();
        ArrayList<String> listName = new ArrayList<>();

        listUrl.add(R.drawable.img_chafie);
        listName.add("چفیه");

        listUrl.add(R.drawable.splash_sameni);
        listName.add("شهید ثامنی راد");

        listUrl.add(R.drawable.img_khamenei_two);
        listName.add("ایت الله خامنه ای");


        RequestOptions options = new RequestOptions();
        options.centerCrop();

        for (int i = 0; i < listUrl.size(); i++)
        {
            TextSliderView sliderView = new TextSliderView(this);
            // if you want show image only / without description text use DefaultSliderView instead

            // initialize SliderLayout
            sliderView
                    .image(listUrl.get(i))
                    .description(listName.get(i))
                    .setRequestOption(options)

                    .setProgressBarVisible(true)
                    .setOnSliderClickListener(this);

            //add your extra information
            sliderView.bundle(new Bundle());
            sliderView.getBundle().putString("extra", listName.get(i));
            mDemoSlider.addSlider(sliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Tablet);

        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
    }

    @Override
    public void onBackPressed() {
        dialogExit();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_setting) {

            startActivity(new Intent(MainActivity.this, Setting.class));

        } else if (id == R.id.nav_aboutme) {

            startActivity(new Intent(MainActivity.this, AboutMe.class));

        } else if (id == R.id.nav_exit) {

            dialogExit();

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.END);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        config_music();
    }

    private void config_music()
    {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        boolean test = sharedPreferences.getBoolean("switch_music", true);

        if (test == true)
        {
            player = MediaPlayer.create(getApplicationContext(),R.raw.boye_pirahan_yousef);
            player.start();
            is_play = true;
        }
        else
        {
            is_play = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onPause() {
        super.onPause();

        if (is_play == true)
        {
            player.stop();
        }
    }

    void dialogExit()
    {
       final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

       builder
               .setTitle("خروج از برنامه")
               .setCancelable(true)
               .setMessage("آیا میخواهید از برنامه خارج شوید؟")
               .setPositiveButton("بله", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i)
                   {
                        finish();
                   }
               })
               .setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i)
                   {
                       dialogInterface.cancel();
                   }
               });

       AlertDialog alertDialog = builder.create();
       alertDialog.show();

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
