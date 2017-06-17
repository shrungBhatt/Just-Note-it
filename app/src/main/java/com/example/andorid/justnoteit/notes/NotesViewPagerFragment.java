package com.example.andorid.justnoteit.notes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andorid.justnoteit.R;
import com.example.andorid.justnoteit.models.NotesData;

import java.util.List;



public class NotesViewPagerFragment extends Fragment {

    private static final String ARG_POSITION = "position";
    private int mPosition;
    private List<NotesData> mNotesDatas;
    private TextView mTitleTextView;
    private TextView mContentTextView;



    public static NotesViewPagerFragment newInstance(int position){
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION,position);
        NotesViewPagerFragment fragment = new NotesViewPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        mPosition = getArguments().getInt(ARG_POSITION);

        mNotesDatas = NotesViewPagerActivity.getmNotesDatas();

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_notes_view_pager,container,false);

        mTitleTextView = (TextView)v.findViewById(R.id.note_topic_name);
        mTitleTextView.setText(mNotesDatas.get(mPosition).getTitle());


        mContentTextView = (TextView)v.findViewById(R.id.home_screen_note_content);
        mContentTextView.setText(mNotesDatas.get(mPosition).getContent());

        return v;
    }


}
