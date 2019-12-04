package com.example.shohada.generic.gallery;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.shohada.R;
import com.github.chrisbanes.photoview.PhotoView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class PreviewImage extends AppCompatActivity {


    String positionClikedImage;
    PhotoView photoView;
    ImageView btnSaveImage;
    ConstraintLayout card_btnSaveImage;


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

        try {

            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);

            setContentView(R.layout.activity_preview_image);
            finds();

//        Bundle extras = getIntent().getExtras();
//        positionClikedImage = extras.getString("positionImage");
//        img_clicked_gallery.setImageResource(Integer.parseInt(positionClikedImage));

          photoView.setImageResource(R.drawable.img_khamenei_two);
          onClicks();
        }catch(Exception e){
        }

    }

    private void onClicks() {
        card_btnSaveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
//                    Drawable drawable = getDrawable(R.drawable.img_chafie);
//                    Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
//                    String savedImageURL =  MediaStore.Images.Media.insertImage(
//                            getContentResolver(),
//                            bitmap,
//                            "شهید",
//                            ""
//                    );
//
//                    Uri savedImageURI = Uri.parse(savedImageURL);
//                    String s = "";
                }catch (Exception e){
                    String s = "";
                }
            }
        });
    }
    private void finds() {

        photoView = findViewById(R.id.img_clicked_gallery);
        btnSaveImage = (ImageView) findViewById(R.id.btnSaveImage);
        card_btnSaveImage = (ConstraintLayout) findViewById(R.id._card_btnSaveImage);

    }




}
