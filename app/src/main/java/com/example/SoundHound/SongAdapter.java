package com.example.SoundHound;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SongAdapter extends RecyclerView.Adapter<BaseViewHolder>  {



    private List<Song> SongList;

    public SongAdapter(List<Song> songList) {

        SongList = songList;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.songlist_item, parent, false));
    }

    @Override
    public int getItemCount() {
        return SongList.size();
    }

    public void addItems(List<Song> sportList) {
        SongList.addAll(sportList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.songTitle) TextView songTitle;
        @BindView(R.id.songLength) TextView songLength;
        @BindView(R.id.artistName) TextView artistName;
        @BindView(R.id.albumTitle) TextView albumTitle;
        @BindView(R.id.coverArt) ImageView coverArt;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            songTitle.setText("");
            albumTitle.setText("");
            songLength.setText("");
            artistName.setText("");
            coverArt.setImageDrawable(null);
        }

        public void onBind(int position) {
            super.onBind(position);

            final Song song = SongList.get(position);

            if (song.getSongTitle() != null) {
                songTitle.setText(song.getSongTitle());
            }

            if (song.getAlbumTitle() != null) {
                albumTitle.setText(song.getAlbumTitle());
            }
            if (song.getSongLength() != null) {
                songLength.setText(song.getSongLength());
            }

            if (song.getArtistName() != null) {
                artistName.setText(song.getArtistName());
            }

            if (song.getCoverArt() != 0) {
                coverArt.setImageResource(song.getCoverArt());
            }

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), SongDetail.class);
                intent.putExtra("songTitle", song.getSongTitle());
                intent.putExtra("songLength", song.getSongLength());
                intent.putExtra("albumTitle", song.getAlbumTitle());
                intent.putExtra("artistName", song.getArtistName());
                intent.putExtra("coverArt", song.getCoverArt());
                v.getContext().startActivity(intent);
            });
        }
    }
}