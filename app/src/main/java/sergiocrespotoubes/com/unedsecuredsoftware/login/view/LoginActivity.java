package sergiocrespotoubes.com.unedsecuredsoftware.login.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sergiocrespotoubes.com.unedsecuredsoftware.R;
import sergiocrespotoubes.com.unedsecuredsoftware.login.interfaces.ILoginView;
import sergiocrespotoubes.com.unedsecuredsoftware.login.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @BindView(R.id.toolbar)
    Toolbar toolbar_main;

    @BindView(R.id.tv_title)
    TextView tv_title;

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this, this);

        //init
        presenter.setupActionBar(toolbar_main);
        tv_title.setText(R.string.login);
    }

    @OnClick(R.id.tv_register)
    public void onRegisterClick(){
        presenter.loadRegister();
    }

}