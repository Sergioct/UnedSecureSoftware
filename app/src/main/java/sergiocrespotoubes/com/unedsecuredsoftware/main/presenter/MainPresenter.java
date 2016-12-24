package sergiocrespotoubes.com.unedsecuredsoftware.main.presenter;


import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import sergiocrespotoubes.com.unedsecuredsoftware.R;
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
