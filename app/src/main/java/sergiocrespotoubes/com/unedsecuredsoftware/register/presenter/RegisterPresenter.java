package sergiocrespotoubes.com.unedsecuredsoftware.register.presenter;


import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import sergiocrespotoubes.com.unedsecuredsoftware.register.interfaces.IRegisterView;

/**
 * Created by Sergio on 02-Oct-16.
 */

public class RegisterPresenter {

    AppCompatActivity activity;
    IRegisterView view;

    public RegisterPresenter(AppCompatActivity activity, IRegisterView view){
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
