package com.example.shohada.generic.gallery;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.preference.SwitchPreference;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.shohada.R;
import com.example.shohada.generic.gallery.selectedImage.AdapterSelectedImage;
import com.example.shohada.generic.gallery.selectedImage.ModelSelectedImage;
import com.example.shohada.imagePicker.ImagePickerActivity;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Gallery extends AppCompatActivity {

    public ArrayList<ModelSelectedImage> arraySelectedImage = new ArrayList<>();
    public AdapterSelectedImage adapterSelectedImage;
    public RecyclerView recyceler_selectedImages;
    public Button btn_sendSelectedImage;
    public ConstraintLayout cons1;


    public static final int REQUEST_IMAGE = 100;
    ConstraintLayout cons_addImage;
    RecyclerView recyceler_gallery;
    AdapterGallery adapterGallery;
    SharedPreferences.Editor checkPermission;
    SharedPreferences prfs;

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
        setContentView(R.layout.activity_gallery_tahmily);


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
        setDataToArrayList();
        onClicks();
        checkPermission = getSharedPreferences("Permission",MODE_PRIVATE).edit();
        prfs = getSharedPreferences("Permission",MODE_PRIVATE);

        //<editor-fold desc="setVisible">
        recyceler_selectedImages.setVisibility(View.GONE);
        cons1.setVisibility(View.GONE);
        btn_sendSelectedImage.setVisibility(View.GONE);
        //</editor-fold>

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == REQUEST_IMAGE) {
            if(resultCode == Activity.RESULT_OK){

                try {

                    cons1.setVisibility(View.VISIBLE);
                    recyceler_selectedImages.setVisibility(View.VISIBLE);
                    btn_sendSelectedImage.setVisibility(View.VISIBLE);

                    Uri uri = data.getParcelableExtra("path");
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), uri);
                    arraySelectedImage.add(new ModelSelectedImage(bitmap));
                    adapterSelectedImage = new AdapterSelectedImage(arraySelectedImage,getApplicationContext(),Gallery.this);
                    GridLayoutManager gridLayoutManager= new GridLayoutManager(getApplicationContext(),2);
                    recyceler_selectedImages.setAdapter(adapterSelectedImage);
                    recyceler_selectedImages.setLayoutManager(gridLayoutManager);
                }catch (Exception e){

                }

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void onClicks() {

        cons_addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String permission = prfs.getString("Permission","");
                        if(permission.equals("OK")){

                            checkPermission();
                        }else if(permission.equals("NO") || permission.equals("") || permission.equals(null)){
                            final android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(Gallery.this, R.style.AlertDialogCustom);
                            alertDialogBuilder.setMessage("برای انتخاب عکس, برنامه به مجوز شما نیاز دارد؟ ");
                            alertDialogBuilder.setPositiveButton("اجازه میدهم",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface arg0, int arg1) {

                                            checkPermission.putString("Permission","OK").apply();
                                            checkPermission();

                                        }
                                    });
                            alertDialogBuilder.setNegativeButton("اجازه نمیدهم",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                            checkPermission.putString("Permission","NO").apply();
                                        }
                                    });
                            android.app.AlertDialog alertDialog = alertDialogBuilder.create();
                            alertDialog.show();
                        }
                    }
                 catch (Exception e) {
                    String s = "";
                }
            }
        });

    }

    private void setDataToArrayList() {

        ArrayList<Integer> arrayImg = new ArrayList<>();
        arrayImg.add(R.drawable.splash_sameni);
        arrayImg.add(R.drawable.img_chafie);
        arrayImg.add(R.drawable.img_alert_exit);
        arrayImg.add(R.drawable.img_rahbar);
        arrayImg.add(R.drawable.img_back_btn);
        arrayImg.add(R.drawable.splash_sameni);
        arrayImg.add(R.drawable.img_chafie);
        arrayImg.add(R.drawable.img_alert_exit);
        arrayImg.add(R.drawable.img_rahbar);
        arrayImg.add(R.drawable.img_back_btn);
        arrayImg.add(R.drawable.splash_sameni);
        arrayImg.add(R.drawable.img_chafie);
        arrayImg.add(R.drawable.img_alert_exit);
        arrayImg.add(R.drawable.img_rahbar);
        arrayImg.add(R.drawable.img_back_btn);

        adapterGallery = new AdapterGallery(arrayImg,getApplicationContext(), Gallery.this);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(getApplicationContext(),3);
        recyceler_gallery.setAdapter(adapterGallery);
        recyceler_gallery.setLayoutManager(gridLayoutManager);
    }

    private void finds() {

        recyceler_gallery = (RecyclerView)findViewById(R.id.recyceler_gallery);
        recyceler_selectedImages = (RecyclerView)findViewById(R.id.recyceler_selectedImages);
        cons_addImage = (ConstraintLayout) findViewById(R.id.cons_addImage);
        cons1 = (ConstraintLayout) findViewById(R.id.cons1);
        btn_sendSelectedImage = (Button) findViewById(R.id.btn_sendSelectedImage);



    }

    private void checkPermission() {
        Dexter.withActivity(Gallery.this)
                .withPermissions(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {

                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {
                            showImagePickerOptions();

                        }
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();

    }

    private void showImagePickerOptions() {
        ImagePickerActivity.showImagePickerOptions(this, new ImagePickerActivity.PickerOptionListener() {
            @Override
            public void onTakeCameraSelected() {
                launchCameraIntent();
            }

            @Override
            public void onChooseGallerySelected() {
                launchGalleryIntent();
            }
        });
    }

    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.dialog_permission_title));
        builder.setMessage(getString(R.string.dialog_permission_message));
        builder.setPositiveButton(getString(R.string.go_to_settings), (dialog, which) -> {
            dialog.cancel();
            openSettings();
        });
        builder.setNegativeButton(getString(android.R.string.cancel), (dialog, which) -> dialog.cancel());
        builder.show();

    }

    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getApplicationContext().getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }

    private void launchGalleryIntent() {
        Intent intent = new Intent(this, ImagePickerActivity.class);
        intent.putExtra(ImagePickerActivity.INTENT_IMAGE_PICKER_OPTION, ImagePickerActivity.REQUEST_GALLERY_IMAGE);

        // setting aspect ratio
        intent.putExtra(ImagePickerActivity.INTENT_LOCK_ASPECT_RATIO, true);
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_X, 1); // 16x9, 1x1, 3:4, 3:2
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_Y, 1);
        startActivityForResult(intent, REQUEST_IMAGE);
    }

    private void launchCameraIntent() {
        Intent intent = new Intent(getApplicationContext(), ImagePickerActivity.class);
        intent.putExtra(ImagePickerActivity.INTENT_IMAGE_PICKER_OPTION, ImagePickerActivity.REQUEST_IMAGE_CAPTURE);

        // setting aspect ratio
        intent.putExtra(ImagePickerActivity.INTENT_LOCK_ASPECT_RATIO, true);
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_X, 1); // 16x9, 1x1, 3:4, 3:2
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_Y, 1);

        // setting maximum bitmap width and height
        intent.putExtra(ImagePickerActivity.INTENT_SET_BITMAP_MAX_WIDTH_HEIGHT, true);
        intent.putExtra(ImagePickerActivity.INTENT_BITMAP_MAX_WIDTH, 1000);
        intent.putExtra(ImagePickerActivity.INTENT_BITMAP_MAX_HEIGHT, 1000);

        startActivityForResult(intent, REQUEST_IMAGE);
    }

}
