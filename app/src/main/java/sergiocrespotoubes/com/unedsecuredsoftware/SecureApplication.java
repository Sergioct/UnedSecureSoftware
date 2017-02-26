package sergiocrespotoubes.com.unedsecuredsoftware;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import net.danlew.android.joda.JodaTimeAndroid;
import net.sqlcipher.database.SQLiteDatabase;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sergiocrespotoubes.com.unedsecuredsoftware.database.DbHelper;
import sergiocrespotoubes.com.unedsecuredsoftware.database.entities.User;

/**
 * Created by Sergio on 03-Oct-16.
 */

public class SecureApplication extends Application {

    final public static String DB_PASSWORD = "Un3D!2017";
    final static String SALT = "Un3D!";

    static Context context;

    //statics
    public static User user;
    public static DbHelper dbHelper;

    public static long timeUnblock;

    public void onCreate(){

        context = this;

        SQLiteDatabase.loadLibs(context);
        dbHelper = new DbHelper(this);

        //Initialize JodaTimeAndroid
        JodaTimeAndroid.init(this);
    }

    public static void userLogged(User auxUser){
        user = auxUser;
    }

    public static String generatePassword(String passwordToHash){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(SALT.getBytes("UTF-8"));
            byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        return generatedPassword;
    }

}