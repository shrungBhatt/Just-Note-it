package com.example.andorid.justnoteit.models;


import java.util.UUID;

public class NotesData {
    private String mTitle;
    private String mId;
    private String mContent;
    private String mDateTime;

    public NotesData(){}

    public NotesData(String id,String title,String content,String dateTime){
        mId = id;
        mTitle = title;
        mContent = content;
        mDateTime = dateTime;
    }

    public String getTitle () {
        return mTitle;
    }

    public void setTitle (String title) {
        mTitle = title;
    }

    public String getId () {
        mId = UUID.randomUUID().toString();
        return mId;
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
