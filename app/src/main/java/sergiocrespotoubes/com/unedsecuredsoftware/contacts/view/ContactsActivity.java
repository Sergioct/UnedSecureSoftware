package sergiocrespotoubes.com.unedsecuredsoftware.contacts.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sergiocrespotoubes.com.unedsecuredsoftware.R;
import sergiocrespotoubes.com.unedsecuredsoftware.contacts.presenter.ContactsPresenter;
import sergiocrespotoubes.com.unedsecuredsoftware.contacts.interfaces.IContactsView;
import sergiocrespotoubes.com.unedsecuredsoftware.main.view.MainActivity;

public class ContactsActivity extends AppCompatActivity implements IContactsView {

    @BindView(R.id.toolbar)
    Toolbar toolbar_main;

    @BindView(R.id.tv_title)
    TextView tv_title;
    ContactsPresenter presenter;

    @BindView(R.id.lv_contacts)
    ListView lv_contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        ButterKnife.bind(this);
        presenter = new ContactsPresenter(this, this);

        //init
        presenter.setupActionBar(toolbar_main);
        tv_title.setText(R.string.contacts);

        presenter.loadContacts(lv_contacts);
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

}