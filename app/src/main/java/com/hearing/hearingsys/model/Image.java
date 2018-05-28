package com.hearing.hearingsys.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;

public class Image {
    public String IMAGES_ID = "images_id";
    public String IMAGES_Path = "images_text";

    public Bitmap img;

    public Image(String IMAGES_ID, String IMAGES_Path) {
        this.IMAGES_ID = IMAGES_ID;
        this.IMAGES_Path = IMAGES_Path;
        load_img();
    }

    private void load_img() {
        File sd = Environment.getExternalStorageDirectory();
        File image = new File(sd+IMAGES_Path, IMAGES_ID+".jpg");
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        img = BitmapFactory.decodeFile(image.getAbsolutePath(),bmOptions);
        img = Bitmap.createScaledBitmap(img,500,500,true);
    }



}
