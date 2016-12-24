package sergiocrespotoubes.com.unedsecuredsoftware.splash.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import sergiocrespotoubes.com.unedsecuredsoftware.R;
import sergiocrespotoubes.com.unedsecuredsoftware.splash.interfaces.ISplashView;
import sergiocrespotoubes.com.unedsecuredsoftware.splash.presenter.SplashPresenter;

/**
 * Created by Sergio on 03-Oct-16.
 */

public class SplashActivity extends AppCompatActivity implements ISplashView {

    //vars
    SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);
        splashPresenter = new SplashPresenter(this, this);

        startApplication();
    }

    @Override
    public void startApplication() {
        splashPresenter.startApplication();
    }

}
