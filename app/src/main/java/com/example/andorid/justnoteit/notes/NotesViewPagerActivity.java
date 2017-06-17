package com.example.andorid.justnoteit.notes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.andorid.justnoteit.R;
import com.example.andorid.justnoteit.database.notesdata.NotesBaseHelper;
import com.example.andorid.justnoteit.login.UserLoginActivity;
import com.example.andorid.justnoteit.models.NotesData;
import com.example.andorid.justnoteit.utils.SharedPreferencesData;

import java.util.List;


public class NotesViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    public static List<NotesData> mNotesDatas;
    private NotesBaseHelper mHelper;

    public static Intent newIntent (Context packageContext) {
        return new Intent(packageContext, NotesViewPagerActivity.class);
    }


    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_viewpager);

        mHelper = new NotesBaseHelper(this);

        mNotesDatas = mHelper.getNotes();


        if (SharedPreferencesData.getStoredLoginStatus(NotesViewPagerActivity.this) &&
                UserLoginActivity.mActive) {
            UserLoginActivity.mActivity.finish();
            UserLoginActivity.mActivity = null;
        } else {
            return;
        }


        mViewPager = (ViewPager) findViewById(R.id.assignment_viewPager);
        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fm) {

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
                intent = new Intent(NotesViewPagerActivity.this, EditAddNewNoteActivity.class);
                startActivity(intent);
                return true;
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
