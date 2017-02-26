package sergiocrespotoubes.com.unedsecuredsoftware.memory_activities.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sergiocrespotoubes.com.unedsecuredsoftware.R;
import sergiocrespotoubes.com.unedsecuredsoftware.contacts.interfaces.IContactsView;
import sergiocrespotoubes.com.unedsecuredsoftware.contacts.presenter.ContactsPresenter;
import sergiocrespotoubes.com.unedsecuredsoftware.main.view.MainActivity;
import sergiocrespotoubes.com.unedsecuredsoftware.memory_activities.interfaces.IMemoryActivitiesView;
import sergiocrespotoubes.com.unedsecuredsoftware.memory_activities.presenter.MemoryActivitiesPresenter;

public class MemoryActivitiesActivity extends AppCompatActivity implements IMemoryActivitiesView {

    @BindView(R.id.toolbar)
    Toolbar toolbar_main;

    @BindView(R.id.tv_title)
    TextView tv_title;
    MemoryActivitiesPresenter presenter;

    @BindView(R.id.tv_stack_value)
    TextView tv_stack_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_activities);
        ButterKnife.bind(this);
        presenter = new MemoryActivitiesPresenter(this, this);

        //init
        presenter.setupActionBar(toolbar_main);
        tv_title.setText(R.string.contacts);

        //load stack number
        if(savedInstanceState != null){
            presenter.loadStackNumber(savedInstanceState.getInt("ACTIVITIES_STACK", 1));
        }else{
            presenter.loadStackNumber(1);
        }
    }

    @Override
    public void changeStackValue(int stackNumber) {
        tv_stack_value.setText(stackNumber);
    }

    @OnClick(R.id.bt_add_activity)
    public void onActivityClick(){
        presenter.addActivity();
    }

    @OnClick(R.id.bt_clear_activity)
    public void onActivityClearClick(){
        presenter.clearActivity();
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