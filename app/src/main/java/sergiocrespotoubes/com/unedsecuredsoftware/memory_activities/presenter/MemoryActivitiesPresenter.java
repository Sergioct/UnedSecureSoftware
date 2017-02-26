package sergiocrespotoubes.com.unedsecuredsoftware.memory_activities.presenter;


import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import sergiocrespotoubes.com.unedsecuredsoftware.memory_activities.interfaces.IMemoryActivitiesView;
import sergiocrespotoubes.com.unedsecuredsoftware.memory_activities.view.MemoryActivitiesActivity;

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
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeButtonEnabled(true);
            actionbar.setTitle(null);
            actionbar.setDisplayShowTitleEnabled(false);
        }
    }

    public void loadStackNumber(int activityStack) {
        activitiesLoaded = activityStack;
        view.changeStackValue(activitiesLoaded);
    }

    public void addActivity() {
        Intent intent = new Intent(activity, MemoryActivitiesActivity.class);
        intent.putExtra("ACTIVITIES_STACK", (activitiesLoaded + 1));
        activity.startActivity(intent);
    }

    public void clearActivity() {
        Intent intent = new Intent(activity, MemoryActivitiesActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

}
