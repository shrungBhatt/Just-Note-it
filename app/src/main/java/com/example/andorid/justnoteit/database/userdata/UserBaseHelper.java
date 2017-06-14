package com.example.andorid.justnoteit.database.userdata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bhatt on 14-06-2017.
 */

public class UserBaseHelper extends SQLiteOpenHelper {



    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "userBase.db";


    //variable to call the write and readable methods of SQLiteDatabase.
    private SQLiteDatabase mDatabase;
    private Context context;

    //Constructor used to get the instance of this class in other classes to get the use of
    //readable and writable tasks carried out.
    public UserBaseHelper (Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }


    //Method used to create the structure of the database.
    @Override
    public void onCreate (SQLiteDatabase db) {
        db.execSQL("create table " + UserDbSchema.UserTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                UserDbSchema.UserTable.Cols.ID + ", " +
                UserDbSchema.UserTable.Cols.EMAIL_ID + ", " +
                UserDbSchema.UserTable.Cols.PASSWORD +
                ")"
        );

    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
