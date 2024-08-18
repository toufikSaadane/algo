package avd.ads.toets.opgave2;

import java.util.List;
import java.util.ArrayList;

class Player {
    List<Playlist> playlists = new ArrayList<>();

    void addPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    /**
     * Toon alle speellijsten waar een bepaalde artiest in voorkomt
     * @param artist
     */
    void showPlayListsForArtist(String artist) {
        for (Playlist playlist : playlists) {
            for (Song song : playlist.songs) {
                if (song.artists.contains(artist)) {
                    System.out.println(playlist.title);
                    break;
                }
            }
        }
    }
}
