package sergiocrespotoubes.com.unedsecuredsoftware.register.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import sergiocrespotoubes.com.unedsecuredsoftware.R;
import sergiocrespotoubes.com.unedsecuredsoftware.register.interfaces.IRegisterView;
import sergiocrespotoubes.com.unedsecuredsoftware.register.presenter.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity implements IRegisterView {

    @BindView(R.id.toolbar)
    Toolbar toolbar_main;

    RegisterPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter = new RegisterPresenter(this, this);
    }

}
