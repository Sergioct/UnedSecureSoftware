package sergiocrespotoubes.com.unedsecuredsoftware.register.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sergiocrespotoubes.com.unedsecuredsoftware.R;
import sergiocrespotoubes.com.unedsecuredsoftware.database.repository.UsersRepository;
import sergiocrespotoubes.com.unedsecuredsoftware.login.view.LoginActivity;
import sergiocrespotoubes.com.unedsecuredsoftware.main.view.MainActivity;
import sergiocrespotoubes.com.unedsecuredsoftware.register.interfaces.IRegisterView;
import sergiocrespotoubes.com.unedsecuredsoftware.register.presenter.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity implements IRegisterView {

    @BindView(R.id.toolbar)
    Toolbar toolbar_main;

    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.et_username)
    TextInputEditText et_username;

    @BindView(R.id.et_password1)
    TextInputEditText et_password1;

    @BindView(R.id.et_password2)
    TextInputEditText et_password2;

    @BindView(R.id.et_email)
    TextInputEditText et_email;

    @BindView(R.id.et_age)
    TextInputEditText et_age;

    @BindView(R.id.tv_error)
    TextView tv_error;

    RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        presenter = new RegisterPresenter(this, this);

        //init
        presenter.setupActionBar(toolbar_main);
        tv_title.setText(R.string.register);
    }

    @OnClick(R.id.bt_register)
    public void onRegisterClick(){
        presenter.createUser(et_username.getText().toString(), et_password1.getText().toString(), et_password2.getText().toString(), et_email.getText().toString(), et_age.getText().toString());
    }


    @Override
    public void showMessageError(String error) {
        tv_error.setText(error);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, LoginActivity.class);
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
