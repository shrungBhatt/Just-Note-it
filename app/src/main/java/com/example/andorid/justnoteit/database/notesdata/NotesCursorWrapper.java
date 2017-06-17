package com.example.andorid.justnoteit.database.notesdata;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.andorid.justnoteit.database.notesdata.NotesDbSchema.NotesTable;
import com.example.andorid.justnoteit.models.NotesData;

import java.util.UUID;


public class NotesCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public NotesCursorWrapper (Cursor cursor) {
        super(cursor);
    }


    public NotesData getNotes(){
        String id = getString(getColumnIndex(NotesTable.Cols.ID));
        String title = getString(getColumnIndex(NotesTable.Cols.TITLE));
        String content = getString(getColumnIndex(NotesTable.Cols.CONTENTS));
        String date = getString(getColumnIndex(NotesTable.Cols.DATE));

        NotesData notesData = new NotesData(UUID.fromString(id));
        notesData.setTitle(title);
        notesData.setContent(content);
        notesData.setDateTime(date);

        return notesData;
    }
}
