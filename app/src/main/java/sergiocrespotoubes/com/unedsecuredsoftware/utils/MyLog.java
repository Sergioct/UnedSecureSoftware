package sergiocrespotoubes.com.unedsecuredsoftware.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import org.joda.time.DateTime;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import sergiocrespotoubes.com.unedsecuredsoftware.BuildConfig;

/**
 * Debug logs.
 */
public class MyLog {

    final static String APP_NAME = "UnedSecureSoftware";

    public MyLog(){

    }

    public static void i(Context context, String message){
        if(BuildConfig.DEBUG) {
            Log.i(APP_NAME, message);
        }
        myLog(context, message);
    }

    public static void e(Context context, String message){
        if(BuildConfig.DEBUG) {
            Log.e(APP_NAME, message);
        }
        myLog(context, message);
    }

    public static void d(Context context, String message){
        if(BuildConfig.DEBUG) {
            Log.d(APP_NAME, message);
        }
        myLog(context, message);
    }

    public static void w(Context context, String message){
        if(BuildConfig.DEBUG) {
            Log.w(APP_NAME, message);
        }
        myLog(context, message);
    }

    public static void v(Context context, String message) {
        if(BuildConfig.DEBUG) {
            Log.v(APP_NAME, message);
        }
        myLog(context, message);
    }

    public static void myLog(Context context, String message) {
        String text = "*** " + new DateTime().toString("HH:mm:ss, dd MMM yyyy") + " Jangel: " + message;
        boolean created = true;
        File dir = new File(Environment.getExternalStorageDirectory(), "UnedSecureSoftware");
        if(!dir.exists()){
            created = dir.mkdir();
        }

        if(created){
            File file;
            file = new File(dir, "UnedLog.txt");

            try {
                BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsolutePath(), file.exists()));
                out.write(text);
                out.write("\n");
                out.close();
            }
            catch (IOException e) {

            }
        }
    }

}
