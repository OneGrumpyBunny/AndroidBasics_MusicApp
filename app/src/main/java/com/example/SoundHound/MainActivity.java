package com.example.SoundHound;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    SongAdapter songAdapter;
    LinearLayoutManager layoutManager;

    private static final String TAG = "SongAdapter";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ButterKnife.bind(this);
            setUp();

            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        }

        private void setUp() {
            layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            songAdapter = new SongAdapter(new ArrayList<>());

            prepareDefaultContent();
        }
        private void prepareDefaultContent() {
            ArrayList<Song> songs = new ArrayList<>();
            //Resources r = recyclerView.getContext().getResources();

            String[] songTitle = getResources().getStringArray(R.array.songsTitles);
            String[] albumTitle = getResources().getStringArray(R.array.albumTitle);
            String[] songLength = getResources().getStringArray(R.array.songsLength);
            String[] artistName = getResources().getStringArray(R.array.artistName);

            TypedArray typedArray = getResources().obtainTypedArray(R.array.songsCoverArt);

            for (int i = 0; i < songTitle.length; i++) {

                int coverArtResourceId = typedArray.getResourceId(i, 0);

                Log.d(TAG, "Adding = " + songTitle[i] + " " + albumTitle[i] + " " + songLength[i] + " " + artistName[i] + " " + coverArtResourceId);

                songs.add(new Song(songTitle[i], albumTitle[i], songLength[i], artistName[i], coverArtResourceId));

            }

            typedArray.recycle(); // Important

            songAdapter.addItems(songs);
            recyclerView.setAdapter(songAdapter);

        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // save the instance state
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putArrayList(WORDLIST, songs);
//    }
}
