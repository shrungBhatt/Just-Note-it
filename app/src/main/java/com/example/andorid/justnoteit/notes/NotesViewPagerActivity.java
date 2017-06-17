package com.example.andorid.justnoteit.notes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.andorid.justnoteit.R;
import com.example.andorid.justnoteit.database.notesdata.NotesBaseHelper;
import com.example.andorid.justnoteit.database.notesdata.NotesLab;
import com.example.andorid.justnoteit.login.UserLoginActivity;
import com.example.andorid.justnoteit.models.NotesData;
import com.example.andorid.justnoteit.utils.SharedPreferencesData;

import java.util.List;


public class NotesViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    public static List<NotesData> mNotesDatas;
    private NotesBaseHelper mHelper;
    private int mPosition;
    private ImageView mImageView;

    public static Intent newIntent (Context packageContext) {
        return new Intent(packageContext, NotesViewPagerActivity.class);
    }


    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_viewpager);

        mHelper = new NotesBaseHelper(this);

        mNotesDatas = mHelper.getNotes();

        mImageView = (ImageView)findViewById(R.id.add_note_imageView);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(NotesViewPagerActivity.this, AddNewNoteActivity.class);
                startActivity(intent);
            }
        });


        if (SharedPreferencesData.getStoredLoginStatus(NotesViewPagerActivity.this) &&
                UserLoginActivity.mActive) {
            UserLoginActivity.mActivity.finish();
            UserLoginActivity.mActivity = null;
        } else {
            return;
        }


        mViewPager = (ViewPager) findViewById(R.id.assignment_viewPager);
        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {

            @Override
            public int getItemPosition (Object object) {
                return POSITION_NONE;
            }

            @Override
            public Fragment getItem (int position) {

                NotesData notesData = mNotesDatas.get(position);
                return NotesViewPagerFragment.newInstance(position);
            }

            @Override
            public int getCount () {
                if(mNotesDatas.size()== 0){
                    mImageView.setVisibility(View.VISIBLE);
                }else{
                    mImageView.setVisibility(View.GONE);
                }
                return mNotesDatas.size();
            }
        });


        updateUI();

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.notes_home_screen_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.logout:
                SharedPreferencesData.setStoredLoginStatus(NotesViewPagerActivity.this, false);
                intent = new Intent(NotesViewPagerActivity.this, UserLoginActivity.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.add_note:
                intent = new Intent(NotesViewPagerActivity.this, AddNewNoteActivity.class);
                startActivity(intent);
                return true;
            case R.id.edit_note:
                if(mNotesDatas.size() != 0) {
                    mPosition = mViewPager.getCurrentItem();
                    SharedPreferencesData.setPosition(this, mPosition);
                    Intent i = new Intent(NotesViewPagerActivity.this, EditNoteActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(this, "NoteBook is Empty", Toast.LENGTH_SHORT).show();
                }
                return true;
            case R.id.delete_note:
                if(mNotesDatas.size() !=0) {
                    mPosition = mViewPager.getCurrentItem();
                    String id = mNotesDatas.get(mPosition).getId().toString();
                    NotesLab.get(this).deleteNote(id);
                    updateUI();
                    Toast.makeText(this, "Note Deleted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"NoteBook is empty",Toast.LENGTH_SHORT).show();
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static List<NotesData> getmNotesDatas () {
        return mNotesDatas;
    }

    @Override
    public void onResume () {
        super.onResume();
        updateUI();
    }

    public void updateUI () {
        mNotesDatas = mHelper.getNotes();
        mViewPager.getAdapter().notifyDataSetChanged();

    }


}
