package com.example.andorid.justnoteit.models;

/**
 * Created by Bhatt on 14-06-2017.
 */

public class NotesData {
    private String mTopicName;
    private int mId;
    private String mContent;
    private String mDateTime;

    public String getTopicName () {
        return mTopicName;
    }

    public void setTopicName (String topicName) {
        mTopicName = topicName;
    }

    public int getId () {
        return mId;
    }

    public void setId (int id) {
        mId = id;
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
