package com.example.andorid.justnoteit.database.userdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.andorid.justnoteit.database.userdata.UserDbSchema.UserTable;
import com.example.andorid.justnoteit.models.UserData;


public class UserLab {

    private static UserLab sUserLab;
    private SQLiteDatabase mDatabase;
    private Context mContext;


    public static UserLab get(Context context) {
        if (sUserLab == null) {
            sUserLab = new UserLab(context);
        }
        return sUserLab;
    }

    //Constructor of this class to get values initialised to be used in this class
    //and get a writable access to store the values into the database.
    private UserLab (Context context) {

        mContext = context.getApplicationContext();
        mDatabase = new UserBaseHelper(mContext).getWritableDatabase();

    }

    //This method is used to fetch the user values and store it in the database.
    public void addUser (UserData userData) {

        ContentValues values = getContentValues(userData);
        mDatabase.insert(UserTable.NAME, null, values);



    }

    //This method is used to store the values into the database.
    private static ContentValues getContentValues (UserData userData) {
        ContentValues values = new ContentValues();

        values.put(UserTable.Cols.ID, userData.getUserId().toString());
        values.put(UserTable.Cols.EMAIL_ID, userData.getUserEmail());
        values.put(UserTable.Cols.PASSWORD, userData.getUserPassword());

        return values;
    }
}
