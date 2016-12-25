package sergiocrespotoubes.com.unedsecuredsoftware.database;

import android.content.Context;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

import sergiocrespotoubes.com.unedsecuredsoftware.SecureApplication;
import sergiocrespotoubes.com.unedsecuredsoftware.database.repository.UsersRepository;

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Secure.db";

    //DATABASE TYPES
    public static final String TEXT = " TEXT";
    public static final String INTEGER = " INTEGER";
    public static final String DATE = " DATE";
    public static final String REAL = " REAL";
    public static final String UNIQUE = " UNIQUE";

    public static SQLiteDatabase db;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = getWritableDatabase(SecureApplication.DB_PASSWORD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsersRepository.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch(oldVersion){
            case 0:

            break;
            case 1:

            break;
            default:
                db.execSQL("DROP TABLE IF EXISTS " + UsersRepository.TABLE_NAME);
                onCreate(db);
            break;
        }
    }

    public void onDestroy() {
        close();
    }

}