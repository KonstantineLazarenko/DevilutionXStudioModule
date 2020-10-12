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


	public static native String GetString();




	public int Cat(){
		Log.e("JniHandler", "CAT WAS CALLED!!!");
		return 333;
	}


	public void updateTimer(){
		Log.e("JniHandler", "UPDATE TIMER CAT WAS CALLED!!!");
		//return 333;
	}



//    public void onResume() {
//        Log.e("DEBUG", "MADE IT HERE---");
//
//          if (!mHasMultiWindow) {
//            resumeNativeThread();
//        }
       // super.onResume();
        //hour = minute = second = 0;
        //((TextView)findViewById(R.id.hellojniMsg)).setText(stringFromJNI());

        //Log.e("DEBUG" , stringFromJNI());
        //startTicks();
   // }





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
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSIONS_GRANTED);

            String ExternalDirectory = "";
            getExternalFilesDir(ExternalDirectory);
            String baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                Log.v("DEBUG: ", "External Directory Mounted");

            }
            Log.v("DEBUG: External Directory", ExternalDirectory);
            Log.v("DEBUG: Base Directory", baseDir);
        }


		File yourAppDir = new File(Environment.getExternalStorageDirectory()+File.separator+"devilutionx");

		if(!yourAppDir.exists() && !yourAppDir.isDirectory())
		{
			// create empty directory
			if (yourAppDir.mkdirs())
			{
				Log.i("DEBUG","App dir created");
			}
			else
			{
				Log.w("DEBUG","Unable to create app dir!");
			}
		}
		else
		{
			Log.i("DEBUG","App dir already exists");
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
