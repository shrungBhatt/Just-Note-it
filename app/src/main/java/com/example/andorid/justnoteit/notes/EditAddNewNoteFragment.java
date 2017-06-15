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
import com.example.andorid.justnoteit.database.notesdata.NotesLab;
import com.example.andorid.justnoteit.models.NotesData;

import java.text.DateFormat;
import java.util.Date;


public class EditAddNewNoteFragment extends Fragment {

    private EditText mTitleEditText;
    private EditText mContentEditText;
    private Date date;


    DateFormat formatDate = DateFormat.getDateInstance(3);


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);


    }

    public static Fragment newInstance(){
        return new EditAddNewNoteFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_edit_add_new_note,container,false);

        date = new Date();

        mTitleEditText = (EditText)v.findViewById(R.id.add_note_title);

        mContentEditText = (EditText)v.findViewById(R.id.add_note_content);

        return v;
    }

    @Override
    public void onCreateOptionsMenu (Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.notes_add_edit_fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.save_note:
                addNote();
                Toast.makeText(getActivity(),"Note Saved",Toast.LENGTH_SHORT).show();
                //Intent i = new Intent(getActivity(),NotesViewPagerActivity.class);
                //startActivity(i);
                return  true;
            case R.id.edit_note_fragment_delete_note:

                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addNote(){
        NotesData notesData = new NotesData();
        String title = mTitleEditText.getText().toString();
        notesData.setTitle(title);
        String content = mContentEditText.getText().toString();
        notesData.setContent(content);
        String Date = formatDate.format(date);
        notesData.setDateTime(Date);
        if(!title.isEmpty()){
            notesData.getId();
            notesData.getTitle();
            notesData.getContent();
            notesData.getDateTime();
            NotesLab.get(getActivity()).addNote(notesData);
        }else{
            Toast.makeText(getActivity(), "Enter Title", Toast.LENGTH_SHORT).show();
        }
    }


}
