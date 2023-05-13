package com.example.androidassessment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    private ListView mContactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        mContactList = findViewById(R.id.contact_listview);

        // Construct a contact list
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(R.drawable.contact1, "John", "1234567890"));
        contacts.add(new Contact(R.drawable.contact2, "Mary", "0987654321"));

        ContactAdapter adapter = new ContactAdapter(this, contacts);
        mContactList.setAdapter(adapter);
    }
}

public class Contact {
    private int mImageId;
    private String mName;
    private String mPhoneNumber;

    public Contact(int imageId, String name, String phoneNumber) {
        mImageId = imageId;
        mName = name;
        mPhoneNumber = phoneNumber;
    }

    public int getImageId() {
        return mImageId;
    }

    public String getName() {
        return mName;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }
}

public class ContactAdapter extends ArrayAdapter<Contact> {

    private Context mContext;

    public ContactAdapter(Context context, ArrayList<Contact> contacts) {
        super(context, 0, contacts);
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.contact_item, parent, false);
        }

        Contact contact = getItem(position);

        ImageView imageView = convertView.findViewById(R.id.contact_imageview);
        TextView nameTextView = convertView.findViewById(R.id.contact_name_textview);
        TextView phoneNumberTextView = convertView.findViewById(R.id.contact_phonenumber_textview);

        imageView.setImageResource(contact.getImageId());
        nameTextView.setText(contact.getName());
        phoneNumberTextView.setText(contact.getPhoneNumber());

        return convertView;
    }
}

