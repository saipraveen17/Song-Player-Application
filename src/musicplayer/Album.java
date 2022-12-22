package musicplayer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    String name;

    String artistName;

    ArrayList<Song> songs;

    public Album(String name, String artistName) {
        this.name = name;
        this.artistName = artistName;
        this.songs = new ArrayList<>();
    }

    public boolean findSong(String title) {

        for(Song s : songs) {
            if(s.getTitle().equals(title))  {
                return true;
            }
        }
        return false;
    }

    public void addSongToAlbum(String title, double duration) {

        if(!findSong(title)) {
            songs.add(new Song(title, duration));
            System.out.println("New song has been added");
        }
        else {
            System.out.println("The Song is already present");
        }
    }

    public void addToPlayList(int trackNo, LinkedList<Song> playlist) {

        int index = trackNo-1;

        if(index>=0&&index<songs.size()) {

            Song song = songs.get(index);
            playlist.add(song);
        }
    }

    public void addToPlayList(String title, LinkedList<Song> playlist) {

        for(Song song : songs) {
            if(song.getTitle().equals(title))  {

                playlist.add(song);
            }
        }

    }
}
