package sergiocrespotoubes.com.unedsecuredsoftware.main.presenter;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import sergiocrespotoubes.com.unedsecuredsoftware.SecureApplication;
import sergiocrespotoubes.com.unedsecuredsoftware.contacts.view.ContactsActivity;
import sergiocrespotoubes.com.unedsecuredsoftware.login.view.LoginActivity;
import sergiocrespotoubes.com.unedsecuredsoftware.main.interfaces.IMainView;
import sergiocrespotoubes.com.unedsecuredsoftware.memory_activities.view.MemoryActivitiesActivity;
import sergiocrespotoubes.com.unedsecuredsoftware.overflow_int.view.OverflowIntActivity;

/**
 * Created by Sergio on 02-Oct-16.
 */

public class MainPresenter {

    AppCompatActivity activity;
    IMainView view;

    public MainPresenter(AppCompatActivity activity, IMainView view){
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

    public void logout(){
        SecureApplication.user = null;
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
    }

    public void contactsClick() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_CONTACTS}, 124);
            }else{
                openContacts();
            }
        }else{
            openContacts();
        }
    }

    public void openContacts(){
        Intent intent = new Intent(activity, ContactsActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public void loadActivitiesMemory() {
        Intent intent = new Intent(activity, MemoryActivitiesActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public void loadOverflowInt() {
        Intent intent = new Intent(activity, OverflowIntActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

}