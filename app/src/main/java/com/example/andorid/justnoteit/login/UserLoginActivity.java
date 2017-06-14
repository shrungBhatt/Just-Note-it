package com.example.andorid.justnoteit.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.andorid.justnoteit.R;
import com.example.andorid.justnoteit.Register.UserSignUpActivity;
import com.example.andorid.justnoteit.notes.NotesViewPagerActivity;


public class UserLoginActivity extends AppCompatActivity {


    private EditText mUserEmail;
    private EditText mUserPassword;
    private Button mLoginButton;
    private Button mSignUpButton;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        mUserEmail = (EditText)findViewById(R.id.user_email);

        mUserPassword = (EditText)findViewById(R.id.user_password);

        mLoginButton = (Button)findViewById(R.id.email_sign_in_button);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent i = NotesViewPagerActivity.newIntent(UserLoginActivity.this);
                startActivity(i);
            }
        });

        mSignUpButton = (Button)findViewById(R.id.user_sign_up_button);
        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent i = new Intent(UserLoginActivity.this, UserSignUpActivity.class);
                startActivity(i);

            }
        });

    }


}

