package sergiocrespotoubes.com.unedsecuredsoftware.overflow_int.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sergiocrespotoubes.com.unedsecuredsoftware.R;
import sergiocrespotoubes.com.unedsecuredsoftware.main.view.MainActivity;
import sergiocrespotoubes.com.unedsecuredsoftware.overflow_int.interfaces.IOverflowIntView;
import sergiocrespotoubes.com.unedsecuredsoftware.overflow_int.presenter.OverflowIntPresenter;

public class OverflowIntActivity extends AppCompatActivity implements IOverflowIntView {

    @BindView(R.id.toolbar)
    Toolbar toolbar_main;

    @BindView(R.id.tv_title)
    TextView tv_title;
    OverflowIntPresenter presenter;

    @BindView(R.id.et_byte)
    EditText et_byte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overflow_int);
        ButterKnife.bind(this);
        presenter = new OverflowIntPresenter(this, this);

        //init
        presenter.setupActionBar(toolbar_main);
        tv_title.setText(R.string.contacts);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.bt_byte)
    public void onByteClick(){
        presenter.checkByte(et_byte.getText().toString());
    }

}