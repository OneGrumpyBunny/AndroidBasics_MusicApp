package com.example.SoundHound;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @link SongDetail represents a detailed view of a selected song with action buttons
 */

public class SongDetail extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_detail);

        //collect our intent data to populate the layout
        Intent intent = getIntent();
        String songTitle = intent.getStringExtra("songTitle");
        String songLength = intent.getStringExtra("songLength");
        String albumTitle = intent.getStringExtra("albumTitle");
        String artistName = intent.getStringExtra("artistName");
        int BigCoverArt = intent.getIntExtra("coverArt", 0);

        // Sets songTitle
        TextView SongTitleDetail = (TextView) findViewById(R.id.songTitle);
        SongTitleDetail.setText(songTitle);

        // Sets songLength
        TextView SongLengthDetail = (TextView) findViewById(R.id.songLength);
        SongLengthDetail.setText(songLength);

        // Sets the album title
        TextView albumTitleDetailBig = (TextView) findViewById(R.id.albumTitle);
        albumTitleDetailBig.setText(albumTitle); // The Album title shows twice on the detail activity

        // Sets artist name
        TextView artistNameDetail = (TextView) findViewById(R.id.artistName);
        artistNameDetail.setText(artistName);

        // Sets cover art image
        ImageView coverArt = (ImageView) findViewById(R.id.coverArt);
        coverArt.setImageResource(BigCoverArt);
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

}
