package sergiocrespotoubes.com.unedsecuredsoftware.database.repository;

import android.content.ContentValues;
import android.support.annotation.NonNull;

import net.sqlcipher.Cursor;

import sergiocrespotoubes.com.unedsecuredsoftware.database.DbHelper;
import sergiocrespotoubes.com.unedsecuredsoftware.database.entities.Usuario;

/**
 * Created by SCrespo on 04/05/2016.
 */
public class UsuariosRepository {

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

    private static Usuario cursorToResult(@NonNull final Cursor cursor) {

        Usuario usuario = new Usuario();

        usuario.setId(cursor.getLong(0));
        usuario.setUsername(cursor.getString(1));
        usuario.setPassword(cursor.getString(2));

        return usuario;
    }

    public static Usuario getFirst() {
        Usuario usuario = null;

        String selectQuery =  "SELECT * " +
                " FROM " + TABLE_NAME + " LIMIT 1";

        Cursor cursor = DbHelper.db.rawQuery(selectQuery, null );

        if(cursor.moveToFirst()){
            usuario = cursorToResult(cursor);
        }

        cursor.close();

        return usuario;
    }

    public static Usuario find_byId(long usuarioId) {
        Usuario usuario = null;

        String selectQuery =  "SELECT * " +
                " FROM " + TABLE_NAME
                + " WHERE " +
                COLUMN_ID + " = ?";

        Cursor cursor = DbHelper.db.rawQuery(selectQuery, new String[] { String.valueOf(usuarioId) } );
        if(cursor.moveToFirst()) {
            usuario = cursorToResult(cursor);
        }

        cursor.close();

        return usuario;
    }

    private static Usuario insert(@NonNull final Usuario usuario) {
        Usuario auxUsuario;

        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, usuario.getUsername());
        values.put(COLUMN_PASSWORD, usuario.getPassword());

        final long insertId = DbHelper.db.insert(TABLE_NAME, null, values);

        if(insertId != -1){
            Cursor cursor = DbHelper.db.query(TABLE_NAME,
                    allColumns, COLUMN_ID + " = " + insertId, null, null, null, null);
            cursor.moveToFirst();

            auxUsuario = cursorToResult(cursor);
            cursor.close();
        }else{
            return null;
        }

        return auxUsuario;
    }

    private static void update(@NonNull final Usuario usuario) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, usuario.getUsername());
        values.put(COLUMN_PASSWORD, usuario.getPassword());

        DbHelper.db.update(TABLE_NAME, values, COLUMN_ID + "= ?", new String[] { String.valueOf(usuario.getId()) });
    }

    public static Usuario save(@NonNull final Usuario usuario) {

        Usuario auxUsuario;

        if(usuario.getId() != 0){
            update(usuario);
            auxUsuario = usuario;
        }else{
            auxUsuario = insert(usuario);
        }

        return auxUsuario;
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

    public static void delete(Usuario usuario) {
        String select =  COLUMN_ID + " = "+usuario.getId();
        DbHelper.db.delete(TABLE_NAME, select, null);
    }

}
