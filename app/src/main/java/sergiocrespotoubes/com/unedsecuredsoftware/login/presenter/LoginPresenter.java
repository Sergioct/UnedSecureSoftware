package sergiocrespotoubes.com.unedsecuredsoftware.login.presenter;


import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import sergiocrespotoubes.com.unedsecuredsoftware.login.interfaces.ILoginView;

/**
 * Created by Sergio on 02-Oct-16.
 */

public class LoginPresenter {

    AppCompatActivity activity;
    ILoginView view;

    public LoginPresenter(AppCompatActivity activity, ILoginView view){
        this.activity = activity;
        this.view = view;
    }

    public void setupActionBar(Toolbar toolbar, ActionBar actionbar, DrawerLayout drawer_layout) {
        if (actionbar != null) {
            actionbar.setDisplayShowCustomEnabled(true);
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeButtonEnabled(true);
            actionbar.setTitle(null);
            actionbar.setDisplayShowTitleEnabled(false);
        }
    }

}
