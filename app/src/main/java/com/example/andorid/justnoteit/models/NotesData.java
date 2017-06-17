package com.example.andorid.justnoteit.models;


import java.util.UUID;

public class NotesData {
    private String mTitle;
    private UUID mId;
    private String mNoteId;
    private String mContent;
    private String mDateTime;

    public NotesData(){
        this(UUID.randomUUID());
    }

    public NotesData(UUID id){
        mId = id;
    }


    public NotesData(String id,String title,String content,String dateTime){
        mNoteId = id;
        mTitle = title;
        mContent = content;
        mDateTime = dateTime;
    }


    public UUID getId () {
        return mId;
    }


    public String getTitle () {
        return mTitle;
    }

    public void setTitle (String title) {
        mTitle = title;
    }




    public String getContent () {
        return mContent;
    }

    public void setContent (String content) {
        mContent = content;
    }

    public String getDateTime () {
        return mDateTime;
    }

    public void setDateTime (String dateTime) {
        mDateTime = dateTime;
    }
}
