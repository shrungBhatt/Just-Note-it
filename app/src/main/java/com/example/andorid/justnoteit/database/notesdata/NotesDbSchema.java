package com.example.andorid.justnoteit.database.notesdata;


public class NotesDbSchema {
    public static final class NotesTable{
        public static final String NAME = "notes";

        public static final class Cols{
            public static final String ID = "uuid";
            public static final String TITLE = "title";
            public static final String CONTENTS = "contents";
            public static final String DATE = "date";
        }
    }
}
