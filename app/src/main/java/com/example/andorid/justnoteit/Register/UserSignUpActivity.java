package com.example.andorid.justnoteit.register;

import android.support.v4.app.Fragment;

import com.example.andorid.justnoteit.utils.SingleFragmentActivity;


public class UserSignUpActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment(){
        return new UserSignUpFragment();
    }
}
