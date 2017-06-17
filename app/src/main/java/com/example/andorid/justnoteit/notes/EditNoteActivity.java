package com.example.andorid.justnoteit.notes;

import android.support.v4.app.Fragment;

import com.example.andorid.justnoteit.utils.SingleFragmentActivity;

/**
 * Created by Bhatt on 17-06-2017.
 */

public class EditNoteActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment () {
        return new EditNoteFragment();
    }
}
