package sergiocrespotoubes.com.unedsecuredsoftware.contacts.utils;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import sergiocrespotoubes.com.unedsecuredsoftware.R;
import sergiocrespotoubes.com.unedsecuredsoftware.objects.MyContact;

public class ContactsAdapter extends BaseAdapter {
 
    private Context context;
    private List<MyContact> items;
 
    public ContactsAdapter(Context context, List<MyContact> items) {
        this.context = context;
        this.items = items;
    }
 
    @Override
    public int getCount() {
        return this.items.size();
    }
 
    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
 
        View rowView = convertView;
 
        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_contact, parent, false);
        }
 
        // Set data into the view.
        TextView tv_name = (TextView) rowView.findViewById(R.id.tv_name);
        TextView tv_number = (TextView) rowView.findViewById(R.id.tv_number);

        MyContact myContact = this.items.get(position);

        if(myContact.getName() != null){
            tv_name.setText(myContact.getName());
        }

        if(myContact.getNumber() != null){
            tv_number.setText(myContact.getNumber());
        }

        return rowView;
    }
 
}