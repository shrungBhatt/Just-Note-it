package com.example.andorid.justnoteit.Utils;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by Bhatt on 15-06-2017.
 */

public class SharedPreferencesData {

    private static final String PREF_LOGIN_STATE = "login state";


    public static Boolean getStoredLoginStatus (Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(PREF_LOGIN_STATE,false);
    }

    public static void setStoredLoginStatus (Context context, Boolean status){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(PREF_LOGIN_STATE,status)
                .apply();
    }
}
