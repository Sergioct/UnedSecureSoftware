package sergiocrespotoubes.com.unedsecuredsoftware.register.presenter;


import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sergiocrespotoubes.com.unedsecuredsoftware.R;
import sergiocrespotoubes.com.unedsecuredsoftware.database.entities.User;
import sergiocrespotoubes.com.unedsecuredsoftware.database.repository.UsersRepository;
import sergiocrespotoubes.com.unedsecuredsoftware.main.view.MainActivity;
import sergiocrespotoubes.com.unedsecuredsoftware.register.interfaces.IRegisterView;

/**
 * Created by Sergio on 02-Oct-16.
 */

public class RegisterPresenter {

    final String SALT = "Un3D!";

    AppCompatActivity activity;
    IRegisterView view;

    public RegisterPresenter(AppCompatActivity activity, IRegisterView view){
        this.activity = activity;
        this.view = view;
    }

    public void setupActionBar(Toolbar toolbar) {

        activity.setSupportActionBar(toolbar);
        ActionBar actionbar = activity.getSupportActionBar();

        if (actionbar != null) {
            actionbar.setDisplayShowCustomEnabled(true);
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeButtonEnabled(true);
            actionbar.setTitle(null);
            actionbar.setDisplayShowTitleEnabled(false);
        }
    }

    public void createUser(String username, String password1, String password2, TextView tv_error) {
        UsersRepository usersRepository = new UsersRepository();

        if(username != null && !username.trim().equals("")
                && password1 != null && !password1.trim().equals("")
                && password2 != null && !password2.trim().equals("")){
            if(password1.equals(password2)){
                User user = usersRepository.find_byUsername(username);

                if(user != null){
                    view.showMessageError(activity.getString(R.string.error_user_exist));
                }else{
                    String password;

                    password = generatePassword(password1);

                    if(password != null){
                        user = new User();

                        user.setUsername(username);
                        user.setPassword(password);
                        user.save();

                        Intent intent = new Intent(activity, MainActivity.class);
                        activity.startActivity(intent);
                    }else{
                        view.showMessageError(activity.getString(R.string.error_register));
                    }
                }
            }else{
                view.showMessageError(activity.getString(R.string.error_password_different));
            }
        }else{
            view.showMessageError(activity.getString(R.string.form_uncomplete));
        }
    }

    public String generatePassword(String passwordToHash){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(SALT.getBytes("UTF-8"));
            byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        return generatedPassword;
    }

}
