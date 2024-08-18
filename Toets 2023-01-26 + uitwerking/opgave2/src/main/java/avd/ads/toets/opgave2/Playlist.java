package avd.ads.toets.opgave2;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Speellijst, een lijst met liedjes
 */
class Playlist {
    String title;

    /**
     * Er is in eerste instantie gekozen voor één lijst 
     * in de vorm van een ArrayList
     * (dat kan vast slimmer)
     */
    List<Song> songs = new ArrayList<>();

    Playlist(String title) {
        this.title = title;
        songs = new ArrayList<>();
    }
    /**
     * Voeg een Song toe aan het einde van de lijst
     * @param song
     */
    void addSong(Song song) {
        songs.add(song);
    }

    /**
     * Toon de speellijst op volgorde van invoer
     * Zet vóór elke song het volgnummer in de lijst
     */
    void showByNumber() {
        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i));
        }
    }

    /**
     * Toon de speellijst op willekeurige volgorde
     * Zet vóór elke song het oorspronkelijke volgnummer in de lijst
     */
    void showRandom() {
        int n = songs.size();
        for (int i = 0; i < songs.size(); i++) {
            int r = (i * 17 + 13) % n; // pseudo random, good enough
            System.out.println((r + 1) + ". " + songs.get(r));
        }
    }

    /**
     * Toon de speellijst op volgorde van artiest (en daarbinnen op titel)
     * Zet vóór elke song het oorspronkelijke volgnummer in de lijst
     */
    void showByArtist() {
        class Line {
            int number;
            Song song;

            Line(int number, Song song) {
                this.number = number;
                this.song = song;
            }
        }
        Map<String, Line> lines = new TreeMap<>();
        int number = 0;
        for (Song song : songs) {
            number++;
            String key = song.artists.toString() + song.title;
            Line line = new Line(number, song);
            lines.put(key, line);
        }
        for (Line line : lines.values()) {
            System.out.println(line.number + ". " + line.song);
        }
    }

}
