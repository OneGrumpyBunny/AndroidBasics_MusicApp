package com.example.SoundHound;


/**
 * {@link Song} represents a song details with cover art, song title, album title, artist name,
 * and song length
 */
public class Song {

    /**
     * Cover art for the album
     */
    private int coverArt;

    /**
     * Song Title
     */
    private String songTitle;

    /**
     * Album Title
     */
    private String albumTitle;

    /**
     * Song length
     */
    private String songLength;

    /**
     * Artist Name
     */
    private String artistName;

    /**
     * Create a new Song object.
     *
     * @param SongTitle   is the title of the song
     * @param AlbumTitle  is the title of the album
     * @param SongLength  is the length of the song xx:xx
     * @param ArtistName  is the name of the artist
     * @param CoverArt    is a small cover art photo
     */
    public Song(String SongTitle, String AlbumTitle, String SongLength, String ArtistName, int CoverArt) {
        coverArt = CoverArt;
        songTitle = SongTitle;
        albumTitle = AlbumTitle;
        songLength = SongLength;
        artistName = ArtistName;
    }

    /**
     * Get the title of the song.
     */
    public String getSongTitle() {
        return songTitle;
    }

    /**
     * Get the title of the album.
     */
    public String getAlbumTitle() {
        return albumTitle;
    }

    /**
     * Get the length of the song.
     */
    public String getSongLength() {
        return songLength;
    }

    /**
     * Get the name of the artist.
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * Get the cover art for the song.
     */
    public int getCoverArt() {
        return coverArt;
    }


}

//Checked, good