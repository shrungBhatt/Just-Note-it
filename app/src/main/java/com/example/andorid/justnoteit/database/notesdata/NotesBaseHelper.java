package com.example.andorid.justnoteit.database.notesdata;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.andorid.justnoteit.database.notesdata.NotesDbSchema.NotesTable;
import com.example.andorid.justnoteit.models.NotesData;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class NotesBaseHelper extends SQLiteOpenHelper {


    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "notesBase.db";

    private SQLiteDatabase mDatabase;
    private Context context;


    public NotesBaseHelper (Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }


    @Override
    public void onCreate (SQLiteDatabase db) {
        db.execSQL("create table " + NotesTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                NotesTable.Cols.ID + ", " +
                NotesTable.Cols.TITLE + ", " +
                NotesTable.Cols.CONTENTS +", " +
                NotesTable.Cols.DATE +
                ")"
        );

    }


    public List<NotesData> getNotes () {
        List<NotesData> notes = new ArrayList<>();

        mDatabase = this.getReadableDatabase();
        NotesCursorWrapper cursor = queryNotes(null,null);

        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                notes.add(cursor.getNotes());
                cursor.moveToNext();
            }
        }finally{
            cursor.close();
        }
        return notes;
    }

    public NotesData getNotes (UUID id) {

        mDatabase = this.getReadableDatabase();
        NotesCursorWrapper cursor = queryNotes(
                NotesTable.Cols.ID +" = ?",
                new String[]{id.toString()}
        );

        try{
            if(cursor.getCount() == 0){
                return null;
            }
            cursor.moveToFirst();
            return cursor.getNotes();
        }finally{
            cursor.close();
        }
    }


    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    private NotesCursorWrapper queryNotes (String selection, String[] selectionArgs) {
        Cursor cursor = mDatabase.query(
                NotesTable.NAME,
                null,//Columns - null select columns
                selection,
                selectionArgs,
                null,//groupBy
                null,//having
                null //orderBy
        );
        return new NotesCursorWrapper(cursor);
    }
}
