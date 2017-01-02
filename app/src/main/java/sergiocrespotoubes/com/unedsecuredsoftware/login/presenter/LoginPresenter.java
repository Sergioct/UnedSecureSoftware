package sergiocrespotoubes.com.unedsecuredsoftware.login.presenter;


import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import sergiocrespotoubes.com.unedsecuredsoftware.R;
import sergiocrespotoubes.com.unedsecuredsoftware.login.interfaces.ILoginView;
import sergiocrespotoubes.com.unedsecuredsoftware.login.view.LoginActivity;
import sergiocrespotoubes.com.unedsecuredsoftware.register.view.RegisterActivity;

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

    public void loadRegister() {
        Intent intent = new Intent(activity, RegisterActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public void login(String username, String password) {
        if(username != null && !username.trim().equals("")
                && password != null && !password.trim().equals("")){

        }else{
            view.errorLogin("Error"); //todo
        }
    }

}
