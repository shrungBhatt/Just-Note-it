package com.example.andorid.justnoteit.notes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.andorid.justnoteit.R;
import com.example.andorid.justnoteit.database.notesdata.NotesBaseHelper;
import com.example.andorid.justnoteit.database.notesdata.NotesLab;
import com.example.andorid.justnoteit.models.NotesData;
import com.example.andorid.justnoteit.utils.SharedPreferencesData;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class EditNoteFragment extends Fragment {


    private EditText mTitleEditText;
    private EditText mContentEditText;
    private int mPosition;
    private List<NotesData> mNotesDatas;
    private Date mDate;
    private NotesData mNotesData;
    private String mId;
    private NotesBaseHelper mHelper;


    DateFormat formatDate = DateFormat.getDateInstance(3);

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);


        mHelper = new NotesBaseHelper(getActivity());
        mDate = new Date();

        mPosition = SharedPreferencesData.getPosition(getActivity());
        mNotesDatas = NotesViewPagerActivity.getmNotesDatas();
        mId = mNotesDatas.get(mPosition).getId().toString();

        mNotesData = mHelper.getNotes(UUID.fromString(mId));
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle SavedInstanceState){
        View v = inflater.inflate(R.layout.fragment_edit_note,container,false);


        mTitleEditText = (EditText)v.findViewById(R.id.edit_note_title);
        mTitleEditText.setText(mNotesDatas.get(mPosition).getTitle());

        mContentEditText = (EditText)v.findViewById(R.id.edit_note_content);
        mContentEditText.setText(mNotesDatas.get(mPosition).getContent());

        return v;
    }

    @Override
    public void onCreateOptionsMenu (Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.notes_edit_fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.edit_fragment_save_edit:
                mNotesData.setTitle(mTitleEditText.getText().toString());
                mNotesData.setContent(mContentEditText.getText().toString());
                mNotesData.setDateTime(formatDate.format(mDate));
                NotesLab.get(getActivity()).updateNote(mId, mNotesData);
                Toast.makeText(getActivity(), "Note Edited", Toast.LENGTH_SHORT).show();
                return  true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPause(){
        super.onPause();

    }



}
