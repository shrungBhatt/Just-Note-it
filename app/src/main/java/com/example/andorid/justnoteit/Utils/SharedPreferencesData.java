package com.example.andorid.justnoteit.utils;

import android.content.Context;
import android.preference.PreferenceManager;


public class SharedPreferencesData {

    private static final String PREF_LOGIN_STATE = "login state";
    private static final String PREF_FLAG = "flag";
    private static final String PREF_ID = "id";


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

    public static int getPosition (Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getInt(PREF_FLAG,0);
    }

    public static void setPosition (Context context, int status){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putInt(PREF_FLAG,status)
                .apply();
    }

    public static String getId (Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(PREF_ID,null);
    }

    public static void setId (Context context, String id){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(PREF_ID,id)
                .apply();
    }
}
