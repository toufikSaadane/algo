package avd.ads.toets.opgave2;

import java.util.List;
import java.util.LinkedList;

/**
 * Lied
 */
class Song {
    String title;
    List<String> artists;

    Song(String title) {
        this.title = title;
        artists = new LinkedList<>();
    }

    Song addArtist(String artist) {
        artists.add(artist);
        return this;
    }

    String getArtists() {
        return artists.toString();
    }

    public String toString() {
        return title + " " + artists;
    }
}