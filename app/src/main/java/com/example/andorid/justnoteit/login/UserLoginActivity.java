package com.example.andorid.justnoteit.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.andorid.justnoteit.R;
import com.example.andorid.justnoteit.Register.UserSignUpActivity;
import com.example.andorid.justnoteit.Utils.SharedPreferencesData;
import com.example.andorid.justnoteit.database.userdata.UserBaseHelper;
import com.example.andorid.justnoteit.notes.NotesViewPagerActivity;


public class UserLoginActivity extends AppCompatActivity {


    private EditText mUserEmail;
    private EditText mUserPassword;
    private Button mLoginButton;
    private Button mSignUpButton;
    private UserBaseHelper mHelper;
    public static Activity mActivity;
    public static Boolean mActive;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        mActivity = this;

        boolean status = SharedPreferencesData.getStoredLoginStatus(UserLoginActivity.this);
        if(status){
            Intent i = new Intent(UserLoginActivity.this,NotesViewPagerActivity.class);
            startActivity(i);
        }

        mHelper = new UserBaseHelper(this);

        mUserEmail = (EditText)findViewById(R.id.user_email);

        mUserPassword = (EditText)findViewById(R.id.user_password);

        mLoginButton = (Button)findViewById(R.id.email_sign_in_button);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                String emailId = mUserEmail.getText().toString();
                String pass = mUserPassword.getText().toString();
                String checkPass = mHelper.fetchUserPass(emailId);
                if(!emailId.isEmpty() && !checkPass.isEmpty()) {
                    if (checkPass.equals(pass)) {
                        SharedPreferencesData.setStoredLoginStatus(UserLoginActivity.this,true);
                        Intent i = NotesViewPagerActivity.newIntent(UserLoginActivity.this);
                        startActivity(i);
                    }else{
                        Toast.makeText(UserLoginActivity.this, "Wrong Username or Password",
                                Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(UserLoginActivity.this,"Enter Your Credentials",
                            Toast.LENGTH_SHORT).show();
                }
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

    @Override
    public void onStart() {
        super.onStart();
        mActive = true;
    }

    @Override
    public void onStop() {
        super.onStop();
        mActive = false;
    }


}

