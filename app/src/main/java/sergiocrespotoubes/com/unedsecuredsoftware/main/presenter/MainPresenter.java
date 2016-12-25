package sergiocrespotoubes.com.unedsecuredsoftware.main.presenter;


import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import sergiocrespotoubes.com.unedsecuredsoftware.SecureApplication;
import sergiocrespotoubes.com.unedsecuredsoftware.login.view.LoginActivity;
import sergiocrespotoubes.com.unedsecuredsoftware.main.interfaces.IMainView;

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

}
