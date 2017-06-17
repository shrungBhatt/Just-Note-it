package com.example.andorid.justnoteit.notes;

import android.support.v4.app.Fragment;

import com.example.andorid.justnoteit.utils.SingleFragmentActivity;



public class AddNewNoteActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new AddNewNoteFragment();
    }


}
