package com.example.androidassessment;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;

public class SignUpActivity extends AppCompatActivity {

    private EditText mUsername;
    private EditText mPassword;
    private EditText mConfirmPassword;
    private Button mSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mUsername = findViewById(R.id.username_edittext);
        mPassword = findViewById(R.id.password_edittext);
        mConfirmPassword = findViewById(R.id.confirm_password_edittext);
        mSignUpButton = findViewById(R.id.signup_button);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Registration logic processing
            }
        });
    }
}

