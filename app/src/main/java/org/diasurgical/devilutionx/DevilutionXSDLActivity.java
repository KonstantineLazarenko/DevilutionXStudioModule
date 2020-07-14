package org.diasurgical.devilutionx;

import org.libsdl.app.SDLActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.os.Environment;



import android.content.Context;
import android.content.res.AssetManager;
import java.io.*;
import android.util.Log;





public class DevilutionXSDLActivity extends SDLActivity {

private static final int PERMISSIONS_GRANTED = 1;


    protected String[] getLibraries() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) ||
                ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            // Show an explanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.

        }
        else {
            // No explanation needed, we can request the permission.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSIONS_GRANTED);


            String foo = "";
            String aaa = "";
            getExternalFilesDir(foo);
            String baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                Log.v("DEBUG: ", "MOUNTED---------------------------\n");

            }




            //getExternalStorageDirectory();
            Log.v("DEBUG: ", "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");

            Log.v("DEBUG: ", foo);
            Log.v("DEBUG: ", baseDir);


        }


        return new String[] {
            "SDL2",
            "SDL2_mixer",
            "SDL2_image",
            "SDL2_ttf",
            "devilutionx"
        };
    }
}
