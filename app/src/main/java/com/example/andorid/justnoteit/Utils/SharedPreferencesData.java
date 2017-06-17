package com.example.andorid.justnoteit.utils;

import android.content.Context;
import android.preference.PreferenceManager;


public class SharedPreferencesData {

    private static final String PREF_LOGIN_STATE = "login state";
    private static final String PREF_FLAG = "flag";


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

    public static Boolean getFlag (Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(PREF_FLAG,false);
    }

    public static void setFlag (Context context, Boolean status){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(PREF_FLAG,status)
                .apply();
    }
}
