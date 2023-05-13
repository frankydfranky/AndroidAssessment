package com.example.androidassessment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {

    private EditText mName;
    private EditText mTele;
    private EditText mEmail;
    private EditText mSuburb;
    private Button mOnlineServiceChatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        mName = findViewById(R.id.name_edittext);
        mTele = findViewById(R.id.tele_edittext);
        mEmail = findViewById(R.id.email_edittext);
        mSuburb = findViewById(R.id.suburb_edittext);
        mOnlineServiceChatButton = findViewById(R.id.online_service_chat_button);

        mOnlineServiceChatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click to pop up the function upgrade prompt
                Toast.makeText(SettingActivity.this, "Function upgrade, waiting for the next version", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

