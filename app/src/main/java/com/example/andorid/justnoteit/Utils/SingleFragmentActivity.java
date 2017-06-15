package com.example.andorid.justnoteit.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.andorid.justnoteit.R;


public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);


        FragmentManager fm = getSupportFragmentManager(); //calling fragmentManager to transact the fragments
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null)
        {
            fragment = createFragment(); //to instantiate the fragment
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();//If the fragment is null than add in the container and display(commit) it.
        }
    }
}
