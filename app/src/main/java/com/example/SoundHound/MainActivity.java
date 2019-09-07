package com.example.SoundHound;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.ArrayList;


/**
 * @link MainActivity represents a list view of all items in the custom ArrayAdapter
 */

public class MainActivity extends AppCompatActivity {

    // use ButterKnife to bind the recycler view
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    SongAdapter songAdapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUp();

        // start the toolbar. This will hold icons for actions users can take
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    // Set up the layout for the recycler view
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

        // define the typed array resources that hold the data values

        String[] songTitle = getResources().getStringArray(R.array.songsTitles);
        String[] albumTitle = getResources().getStringArray(R.array.albumTitle);
        String[] songLength = getResources().getStringArray(R.array.songsLength);
        String[] artistName = getResources().getStringArray(R.array.artistName);
        TypedArray typedArray = getResources().obtainTypedArray(R.array.songsCoverArt);

        // populate the list with values from the typed array resources
        for (int i = 0; i < songTitle.length; i++) {

            int coverArtResourceId = typedArray.getResourceId(i, 0);
            songs.add(new Song(songTitle[i], albumTitle[i], songLength[i], artistName[i], coverArtResourceId));

        }

        typedArray.recycle();

        // call the SongAdapter class once all data items are in the array
        songAdapter.addItems(songs);
        recyclerView.setAdapter(songAdapter);

    }

    // methods to inflate menu layout and populate with icons
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
}
