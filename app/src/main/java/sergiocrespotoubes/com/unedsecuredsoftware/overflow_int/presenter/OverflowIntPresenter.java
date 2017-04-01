package sergiocrespotoubes.com.unedsecuredsoftware.overflow_int.presenter;


import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import sergiocrespotoubes.com.unedsecuredsoftware.contacts.utils.ContactsAdapter;
import sergiocrespotoubes.com.unedsecuredsoftware.objects.MyContact;
import sergiocrespotoubes.com.unedsecuredsoftware.overflow_int.interfaces.IOverflowIntView;

/**
 * Created by Sergio on 02-Oct-16.
 */

public class OverflowIntPresenter {

    AppCompatActivity activity;
    IOverflowIntView view;

    public OverflowIntPresenter(AppCompatActivity activity, IOverflowIntView view){
        this.activity = activity;
        this.view = view;
    }

    public void setupActionBar(Toolbar toolbar) {

        activity.setSupportActionBar(toolbar);
        ActionBar actionbar = activity.getSupportActionBar();

        if (actionbar != null) {
            actionbar.setDisplayShowCustomEnabled(true);
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeButtonEnabled(true);
            actionbar.setTitle(null);
            actionbar.setDisplayShowTitleEnabled(false);
        }
    }

    public void checkByte(String sByte) {
        try {
            byte value = Byte.parseByte(sByte);
            Toast.makeText(activity, "Value: " + value, Toast.LENGTH_SHORT).show();
        }catch (NumberFormatException e) {
            Toast.makeText(activity, "Parse error", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkShort(String sByte) {
        try {
            short value = Short.parseShort(sByte);
            Toast.makeText(activity, "Value: " + value, Toast.LENGTH_SHORT).show();
        }catch (NumberFormatException e) {
            Toast.makeText(activity, "Parse error", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkInt(String sInt) {
        try {
            int value = Integer.parseInt(sInt);
            Toast.makeText(activity, "Value: " + value, Toast.LENGTH_SHORT).show();
        }catch (NumberFormatException e) {
            Toast.makeText(activity, "Parse error", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkLong(String sLong) {
        try {
            long value = Integer.parseInt(sLong);
            Toast.makeText(activity, "Value: " + value, Toast.LENGTH_SHORT).show();
        }catch (NumberFormatException e) {
            Toast.makeText(activity, "Parse error", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkDouble(String sDouble) {
        try {
            double value = Double.parseDouble(sDouble);
            Toast.makeText(activity, "Value: " + value, Toast.LENGTH_SHORT).show();
        }catch (NumberFormatException e) {
            Toast.makeText(activity, "Parse error", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkFloat(String sFloat) {
        try {
            float value = Float.parseFloat(sFloat);
            Toast.makeText(activity, "Value: " + value, Toast.LENGTH_SHORT).show();
        }catch (NumberFormatException e) {
            Toast.makeText(activity, "Parse error", Toast.LENGTH_SHORT).show();
        }
    }

}
