package com.example.andorid.justnoteit.Register;

import android.support.v4.app.Fragment;

import com.example.andorid.justnoteit.Utils.SingleFragmentActivity;


public class UserSignUpActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment(){
        return new UserSignUpFragment();
    }
}
