package sergiocrespotoubes.com.unedsecuredsoftware.overflow_int.presenter;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import sergiocrespotoubes.com.unedsecuredsoftware.overflow_int.interfaces.IOverflowIntView;

/**
 * Created by Sergio on 02-Oct-16.
 */
public class OverflowIntPresenter {

    AppCompatActivity activity;
    IOverflowIntView view;

    public OverflowIntPresenter(AppCompatActivity activity, IOverflowIntView view){
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

    public void checkByte(String sByte) {
        try {
            byte value = Byte.parseByte(sByte);
            view.showToast("Value: " + value);
        }catch (NumberFormatException e) {
            view.showToast("Parse error");
        }
    }

    public void checkShort(String sByte) {
        try {
            short value = Short.parseShort(sByte);
            view.showToast("Value: " + value);
        }catch (NumberFormatException e) {
            view.showToast("Parse error");
        }
    }

    public void checkInt(String sInt) {
        try {
            int value = Integer.parseInt(sInt);
            view.showToast("Value: " + value);
        }catch (NumberFormatException e) {
            view.showToast("Parse error");
        }
    }

    public void checkLong(String sLong) {
        try {
            long value = Integer.parseInt(sLong);
            view.showToast("Value: " + value);
        }catch (NumberFormatException e) {
            view.showToast("Parse error");
        }
    }

    public void checkDouble(String sDouble) {
        try {
            double value = Double.parseDouble(sDouble);
            view.showToast("Value: " + value);
        }catch (NumberFormatException e) {
            view.showToast("Parse error");
        }
    }

    public void checkFloat(String sFloat) {
        try {
            float value = Float.parseFloat(sFloat);
            view.showToast("Value: " + value);
        }catch (NumberFormatException e) {
            view.showToast("Parse error");
        }
    }

}
