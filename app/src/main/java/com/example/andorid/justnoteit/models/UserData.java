package com.example.andorid.justnoteit.models;


import java.util.UUID;

public class UserData {

    private UUID mUserId;
    private String mUserEmail;
    private String mUserPassword;

    public UUID getUserId () {
        mUserId = UUID.randomUUID();
        return mUserId;
    }


    public String getUserEmail () {
        return mUserEmail;
    }

    public void setUserEmail (String userEmail) {
        mUserEmail = userEmail;
    }

    public String getUserPassword () {
        return mUserPassword;
    }

    public void setUserPassword (String userPassword) {
        mUserPassword = userPassword;
    }
}
