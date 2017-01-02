package sergiocrespotoubes.com.unedsecuredsoftware.database.repository;

import android.content.ContentValues;
import android.support.annotation.NonNull;

import net.sqlcipher.Cursor;

import sergiocrespotoubes.com.unedsecuredsoftware.database.DbHelper;
import sergiocrespotoubes.com.unedsecuredsoftware.database.entities.User;

/**
 * Created by SCrespo on 04/05/2016.
 */
public class UsersRepository {

    //Columns
    public static final String TABLE_NAME = "USERS";
    public static final String COLUMN_ID = "_ID";
    public static final String COLUMN_USERNAME = "USERNAME";
    public static final String COLUMN_PASSWORD = "PASSWORD";

    private static String[] allColumns = {
            COLUMN_ID,
            COLUMN_USERNAME,
            COLUMN_PASSWORD
    };

    public static String createTable(){
        return "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_USERNAME + DbHelper.TEXT + DbHelper.UNIQUE +"," +
                COLUMN_PASSWORD + DbHelper.TEXT +
                " )";
    }

    private static User cursorToResult(@NonNull final Cursor cursor) {

        User user = new User();

        user.setId(cursor.getLong(0));
        user.setUsername(cursor.getString(1));
        user.setPassword(cursor.getString(2));

        return user;
    }

    public static User getFirst() {
        User user = null;

        String selectQuery =  "SELECT * " +
                " FROM " + TABLE_NAME + " LIMIT 1";

        Cursor cursor = DbHelper.db.rawQuery(selectQuery, null );

        if(cursor.moveToFirst()){
            user = cursorToResult(cursor);
        }

        cursor.close();

        return user;
    }

    public static User find_byId(long usuarioId) {
        User user = null;

        String selectQuery =  "SELECT * " +
                " FROM " + TABLE_NAME
                + " WHERE " +
                COLUMN_ID + " = ?";

        Cursor cursor = DbHelper.db.rawQuery(selectQuery, new String[] { String.valueOf(usuarioId) } );
        if(cursor.moveToFirst()) {
            user = cursorToResult(cursor);
        }

        cursor.close();

        return user;
    }

    private static User insert(@NonNull final User user) {
        User auxUser;

        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_PASSWORD, user.getPassword());

        final long insertId = DbHelper.db.insert(TABLE_NAME, null, values);

        if(insertId != -1){
            Cursor cursor = DbHelper.db.query(TABLE_NAME,
                    allColumns, COLUMN_ID + " = " + insertId, null, null, null, null);
            cursor.moveToFirst();

            auxUser = cursorToResult(cursor);
            cursor.close();
        }else{
            return null;
        }

        return auxUser;
    }

    private static void update(@NonNull final User user) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_PASSWORD, user.getPassword());

        DbHelper.db.update(TABLE_NAME, values, COLUMN_ID + "= ?", new String[] { String.valueOf(user.getId()) });
    }

    public static User save(@NonNull final User user) {

        User auxUser;

        if(user.getId() != 0){
            update(user);
            auxUser = user;
        }else{
            auxUser = insert(user);
        }

        return auxUser;
    }

    public static int count() {
        int count = 0;

        String selectQuery =  "SELECT COUNT (*) " +
                " FROM " + TABLE_NAME;

        Cursor cursor = DbHelper.db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }

        cursor.close();

        return count;
    }

    public static void delete(User user) {
        String select =  COLUMN_ID + " = "+ user.getId();
        DbHelper.db.delete(TABLE_NAME, select, null);
    }

    public User find_byUsername(String username) {
        User user = null;

        String selectQuery =  "SELECT * " +
                " FROM " + TABLE_NAME
                + " WHERE " +
                COLUMN_USERNAME + " = ?";

        Cursor cursor = DbHelper.db.rawQuery(selectQuery, new String[] { String.valueOf(username) } );

        if(cursor.moveToFirst()) {
            user = cursorToResult(cursor);
        }

        cursor.close();

        return user;
    }
}
