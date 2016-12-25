package sergiocrespotoubes.com.unedsecuredsoftware.main.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sergiocrespotoubes.com.unedsecuredsoftware.R;
import sergiocrespotoubes.com.unedsecuredsoftware.main.interfaces.IMainView;
import sergiocrespotoubes.com.unedsecuredsoftware.main.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements IMainView {

    @BindView(R.id.main_toolbar)
    Toolbar toolbar_main;

    @BindView(R.id.tv_title)
    TextView tv_title;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this, this);

        //init
        presenter.setupActionBar(toolbar_main);
        tv_title.setText(R.string.main);
    }

}
