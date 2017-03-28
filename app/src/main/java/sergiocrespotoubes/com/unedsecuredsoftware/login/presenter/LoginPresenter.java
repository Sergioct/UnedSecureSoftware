package sergiocrespotoubes.com.unedsecuredsoftware.login.presenter;


import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.joda.time.DateTime;

import java.util.Arrays;

import butterknife.BindView;
import sergiocrespotoubes.com.unedsecuredsoftware.R;
import sergiocrespotoubes.com.unedsecuredsoftware.SecureApplication;
import sergiocrespotoubes.com.unedsecuredsoftware.database.entities.User;
import sergiocrespotoubes.com.unedsecuredsoftware.database.repository.UsersRepository;
import sergiocrespotoubes.com.unedsecuredsoftware.login.interfaces.ILoginView;
import sergiocrespotoubes.com.unedsecuredsoftware.login.view.LoginActivity;
import sergiocrespotoubes.com.unedsecuredsoftware.main.view.MainActivity;
import sergiocrespotoubes.com.unedsecuredsoftware.register.view.RegisterActivity;

/**
 * Created by Sergio on 02-Oct-16.
 */

public class LoginPresenter {

    //const
    long MILLIS_IN_HOUR = 3600000;
    long MILLIS_IN_MINUTE = 60000;
    long TIME_BLOCK = 30000;

    AppCompatActivity activity;
    ILoginView view;
    int count = 0;

    public LoginPresenter(AppCompatActivity activity, ILoginView view){
        this.activity = activity;
        this.view = view;

        DateTime now = new DateTime();
        long timeDiff = SecureApplication.timeUnblock - now.getMillis();
        if(timeDiff > 0){
            startCounter(timeDiff);
        }
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

    public void loadRegister() {
        Intent intent = new Intent(activity, RegisterActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public void login(String username, char[] password) {
        if(username != null && !username.trim().equals("")
                && password != null){
            User user = UsersRepository.find_byUsername_andPassword(username,
                    SecureApplication.generatePassword(password.toString()));

            Arrays.fill(password, ' ');

            if(user != null){
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
                activity.finish();
            }else{
                count++;
                view.errorLogin(activity.getString(R.string.username_password_incorrect) + " (" + count + ")");
                if(count > 2){
                    DateTime now = new DateTime();
                    SecureApplication.timeUnblock = now.getMillis() + TIME_BLOCK;
                    startCounter(TIME_BLOCK);
                }
            }
        }else{
            view.errorLogin(activity.getString(R.string.complete_username_password));
        }
    }

    private void startCounter(long time){
        view.enableForm(false);

        new CountDownTimer(time, 1000) {

            public void onTick(long millisUntilFinished) {
                if(millisUntilFinished > MILLIS_IN_HOUR){
                    view.errorLogin(activity.getString(R.string.blocked_time) + " " + new DateTime(millisUntilFinished).toString("HH'H' mm'm' ss's'"));
                }else if(millisUntilFinished > MILLIS_IN_MINUTE){
                    view.errorLogin(activity.getString(R.string.blocked_time) + " " + new DateTime(millisUntilFinished).toString("mm'm' ss's'"));
                }else{
                    view.errorLogin(activity.getString(R.string.blocked_time) + " " + new DateTime(millisUntilFinished).toString("ss's'"));
                }
            }

            public void onFinish() {
                view.errorLogin("");
                view.enableForm(true);
            }

        }.start();
    }

}
