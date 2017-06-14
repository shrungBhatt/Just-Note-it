package com.example.andorid.justnoteit.notes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andorid.justnoteit.R;

/**
 * Created by Bhatt on 14-06-2017.
 */

public class NotesViewPagerFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_notes_view_pager,container,false);

        return v;
    }
}
