package sergiocrespotoubes.com.unedsecuredsoftware.main.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sergiocrespotoubes.com.unedsecuredsoftware.R;
import sergiocrespotoubes.com.unedsecuredsoftware.main.interfaces.IMainView;
import sergiocrespotoubes.com.unedsecuredsoftware.main.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements IMainView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

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
        presenter.setupActionBar(toolbar);
        tv_title.setText(R.string.main);
    }

    @OnClick(R.id.bt_contacts)
    public void onContactsClick(){
        presenter.contactsClick();
    }

    @OnClick(R.id.bt_activities_memory)
    public void onActivitiesMemoryClick(){
        presenter.loadActivitiesMemory();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 124){
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED){
                presenter.openContacts();
            }else {
                Toast.makeText(getApplicationContext(), "Se necesita permisos para continuar", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
