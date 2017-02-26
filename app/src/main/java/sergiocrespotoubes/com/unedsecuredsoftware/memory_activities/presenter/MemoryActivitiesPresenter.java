package sergiocrespotoubes.com.unedsecuredsoftware.memory_activities.presenter;


import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import sergiocrespotoubes.com.unedsecuredsoftware.contacts.interfaces.IContactsView;
import sergiocrespotoubes.com.unedsecuredsoftware.memory_activities.interfaces.IMemoryActivitiesView;
import sergiocrespotoubes.com.unedsecuredsoftware.memory_activities.view.MemoryActivitiesActivity;
import sergiocrespotoubes.com.unedsecuredsoftware.objects.MyContact;

/**
 * Created by Sergio on 02-Oct-16.
 */

public class MemoryActivitiesPresenter {

    AppCompatActivity activity;
    IMemoryActivitiesView view;

    int activitiesLoaded = 1;

    public MemoryActivitiesPresenter(AppCompatActivity activity, IMemoryActivitiesView view){
        this.activity = activity;
        this.view = view;
    }

    public void setupActionBar(Toolbar toolbar) {

        activity.setSupportActionBar(toolbar);
        ActionBar actionbar = activity.getSupportActionBar();

        if (actionbar != null) {
            actionbar.setDisplayShowCustomEnabled(true);
            //actionbar.setDisplayHomeAsUpEnabled(true);
            //actionbar.setHomeButtonEnabled(true);
            actionbar.setTitle(null);
            actionbar.setDisplayShowTitleEnabled(false);
        }
    }

    public void loadStackNumber(int activityStack) {
        activitiesLoaded = activityStack;
    }

    public void addActivity() {
        Intent intent = new Intent(activity, MemoryActivitiesActivity.class);
        activity.startActivity(intent);
    }

    public void clearActivity() {
        Intent intent = new Intent(activity, MemoryActivitiesActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
        activity.startActivity(intent);
    }

}
