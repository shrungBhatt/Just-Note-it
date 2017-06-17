package com.example.andorid.justnoteit.database.notesdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.andorid.justnoteit.database.notesdata.NotesDbSchema.NotesTable;
import com.example.andorid.justnoteit.models.NotesData;



public class NotesLab {
    private static NotesLab sNotesLab;
    private SQLiteDatabase mDatabase;
    private Context mContext;


    public static NotesLab get(Context context) {
        if (sNotesLab == null) {
            sNotesLab = new NotesLab(context);
        }
        return sNotesLab;
    }

    //Constructor of this class to get values initialised to be used in this class
    //and get a writable access to store the values into the database.
    private NotesLab(Context context) {

        mContext = context.getApplicationContext();
        mDatabase = new NotesBaseHelper(mContext).getWritableDatabase();

    }

    //This method is used to fetch the user values and store it in the database.
    public void addNote(NotesData notesData) {

        ContentValues values = getContentValues(notesData);
        mDatabase.insert(NotesTable.NAME, null, values);

    }

    public void updateNote(String id,NotesData notesData){
        ContentValues values = getContentValues(notesData);

        mDatabase.update(NotesTable.NAME, values,
                NotesTable.Cols.ID + " = ?",
                new String[]{id});
    }

    //This method is used to store the values into the database.
    private static ContentValues getContentValues (NotesData notesData) {
        ContentValues values = new ContentValues();

        values.put(NotesTable.Cols.ID, notesData.getId().toString());
        values.put(NotesTable.Cols.TITLE, notesData.getTitle());
        values.put(NotesTable.Cols.CONTENTS, notesData.getContent());
        values.put(NotesTable.Cols.DATE,notesData.getDateTime());

        return values;
    }

}
