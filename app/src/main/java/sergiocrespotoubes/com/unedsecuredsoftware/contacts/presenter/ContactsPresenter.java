package sergiocrespotoubes.com.unedsecuredsoftware.contacts.presenter;


import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import sergiocrespotoubes.com.unedsecuredsoftware.R;
import sergiocrespotoubes.com.unedsecuredsoftware.SecureApplication;
import sergiocrespotoubes.com.unedsecuredsoftware.contacts.interfaces.IContactsView;
import sergiocrespotoubes.com.unedsecuredsoftware.contacts.utils.ContactsAdapter;
import sergiocrespotoubes.com.unedsecuredsoftware.database.entities.User;
import sergiocrespotoubes.com.unedsecuredsoftware.database.repository.UsersRepository;
import sergiocrespotoubes.com.unedsecuredsoftware.main.view.MainActivity;
import sergiocrespotoubes.com.unedsecuredsoftware.objects.MyContact;
import sergiocrespotoubes.com.unedsecuredsoftware.register.view.RegisterActivity;

/**
 * Created by Sergio on 02-Oct-16.
 */

public class ContactsPresenter {

    AppCompatActivity activity;
    IContactsView view;

    public ContactsPresenter(AppCompatActivity activity, IContactsView view){
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

    public void loadContacts(ListView lv_contacts) {

        List<MyContact> lContacts = new ArrayList<>();
        ContentResolver cr = activity.getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);
        MyContact myContact;

        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                myContact = new MyContact();

                String id = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME));

                myContact.setName(name);

                if (cur.getInt(cur.getColumnIndex(
                        ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    Cursor pCur = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?",
                            new String[]{id}, null);
                    if (pCur.moveToNext()) {
                        String phoneNo = pCur.getString(pCur.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER));
                        myContact.setNumber(phoneNo);
                    }
                    pCur.close();
                }
                lContacts.add(myContact);
            }
        }
        lv_contacts.setAdapter(new ContactsAdapter(activity, lContacts));
    }

}
