package com.example.andorid.justnoteit.database.userdata;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.andorid.justnoteit.database.userdata.UserDbSchema.UserTable;


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
        db.execSQL("create table " + UserTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                UserTable.Cols.ID + ", " +
                UserTable.Cols.EMAIL_ID + ", " +
                UserTable.Cols.PASSWORD +
                ")"
        );

    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String fetchUserPass (String emailId) {

        mDatabase = this.getReadableDatabase();


        Cursor c = queryUsers(new String[]{UserTable.Cols.EMAIL_ID, UserTable.Cols.PASSWORD},
                UserTable.Cols.EMAIL_ID + " = ?", new String[]{emailId});


        String uName, pass;
        pass = "not found";
        try {
            c.moveToFirst();
            while (!c.isAfterLast()) {
                uName = c.getString(c.getColumnIndex(UserTable.Cols.EMAIL_ID));
                if (uName.equals(emailId)) {
                    pass = c.getString(c.getColumnIndex(UserTable.Cols.PASSWORD));
                }
                c.moveToNext();
            }
        } finally {
            c.close();
        }
        return pass;
    }


    private Cursor queryUsers (String[] projection, String whereClause, String[] whereArgs) {
        return mDatabase.query(
                UserTable.NAME,
                projection,//Columns - null select columns
                whereClause,
                whereArgs,
                null,//groupBy
                null,//having
                null //orderBy
        );
    }


}
