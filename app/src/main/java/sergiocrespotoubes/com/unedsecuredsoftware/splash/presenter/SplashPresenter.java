package sergiocrespotoubes.com.unedsecuredsoftware.splash.presenter;

import android.app.Activity;
import android.content.Intent;

import java.util.Timer;
import java.util.TimerTask;

import sergiocrespotoubes.com.unedsecuredsoftware.login.view.LoginActivity;
import sergiocrespotoubes.com.unedsecuredsoftware.main.view.MainActivity;
import sergiocrespotoubes.com.unedsecuredsoftware.splash.interfaces.ISplashView;


/**
 * Created by Sergio on 03-Oct-16.
 */

public class SplashPresenter {

    private static final long SPLASH_SCREEN_DELAY = 3000;

    Activity activity;
    ISplashView view;

    public SplashPresenter(Activity activity, ISplashView splashView){
        this.activity = activity;
        view = splashView;
    }

    public void startApplication() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(activity, LoginActivity.class);
                activity.startActivity(intent);
                activity.finish();
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

}
