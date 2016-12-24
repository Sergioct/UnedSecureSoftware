package sergiocrespotoubes.com.unedsecuredsoftware.login.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import sergiocrespotoubes.com.unedsecuredsoftware.R;
import sergiocrespotoubes.com.unedsecuredsoftware.login.interfaces.ILoginView;
import sergiocrespotoubes.com.unedsecuredsoftware.login.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @BindView(R.id.toolbar)
    Toolbar toolbar_main;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this, this);
    }

}