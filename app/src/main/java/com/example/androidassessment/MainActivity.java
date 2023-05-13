package com.example.androidassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.widget.ImageView;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView mEpidemicMap;
    private ImageView mPersonalPage;
    private ImageView mChat;
    private ImageView mSetting;
    private ImageView mForum;
    private ImageView mContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEpidemicMap = findViewById(R.id.epidemic_map_imageview);
        mPersonalPage = findViewById(R.id.personal_page_imageview);
        mChat = findViewById(R.id.chat_imageview);
        mSetting = findViewById(R.id.setting_imageview);
        mForum = findViewById(R.id.forum_imageview);
        mContact = findViewById(R.id.contact_imageview);

        mEpidemicMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click to jump to the Epidemic Map interface
                // Create a Uri object specifying the location coordinates in Google Maps

                Uri gmmIntentUri = Uri.parse("geo:0,0?q=151.2112,-33.87305");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                // Check if the device has the Google Maps app installed
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "Please install the Google Maps app first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mPersonalPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click to jump to Personal Page interface
            Intent intent = new Intent(MainActivity.this, PersonalPageActivity.class);
            startActivity(intent);
            }
        });

        mChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click to jump to Chat interface
            }
        });

        mSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        mForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click to pop up the function upgrade prompt
                Toast.makeText(MainActivity.this, "Function upgrade, waiting for the next version", Toast.LENGTH_SHORT).show();
            }
        });

        mContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent);
            }
        });
    }
}

