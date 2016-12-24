package sergiocrespotoubes.com.unedsecuredsoftware.main.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import sergiocrespotoubes.com.unedsecuredsoftware.R;
import sergiocrespotoubes.com.unedsecuredsoftware.main.interfaces.IMainView;
import sergiocrespotoubes.com.unedsecuredsoftware.main.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements IMainView {

    @BindView(R.id.toolbar_main)
    Toolbar toolbar_main;

    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenter(this, this);
    }

}