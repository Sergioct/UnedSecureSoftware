package sergiocrespotoubes.com.unedsecuredsoftware;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import net.danlew.android.joda.JodaTimeAndroid;
import net.sqlcipher.database.SQLiteDatabase;

import sergiocrespotoubes.com.unedsecuredsoftware.database.DbHelper;
import sergiocrespotoubes.com.unedsecuredsoftware.database.entities.User;

/**
 * Created by Sergio on 03-Oct-16.
 */

public class SecureApplication extends Application {

    final public static String DB_PASSWORD = "Un3D!2017";

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

}