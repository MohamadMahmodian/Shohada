package com.example.shohada.generic.gallery.selectedImage;

import android.graphics.Bitmap;

public class ModelSelectedImage {


    Bitmap img;

    public ModelSelectedImage(Bitmap img) {
        this.img = img;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }
}
