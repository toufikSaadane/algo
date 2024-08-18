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
     * (ArrayList, want we gebruiken de index in de List in de Map)
     * We voegen een Map met lijsten van indexen per artiest toe
     * Dit wordt een TreeMap, gesorteerd op artiest
     */
    List<Song> songs = new ArrayList<>();
    Map<String, List<Integer>> songIndexesForArtist;

    Playlist(String title) {
        this.title = title;
        songs = new ArrayList<>();
        songIndexesForArtist = new TreeMap<>();
    }
    /**
     * Voeg een Song toe aan het einde van de lijst
     * 
     * N = songs.size()
     * 
     * Voor Arraylist:
     *    Tijdsefficiëntie = O(1), toevoegen aan arraylist meestal onmiddellijk, worst case O(N)
     *    Geheugenefficiëntie = O(1), geen recursie of andere afhankelijkheid van N
     * 
     * Voor TreeMap:
     *    Tijdsefficiëntie = O(log(N)), zoeken in gebalanceerde zoekboom
     *    Geheugenefficiëntie = O(log(N)), recursie tot boomdiepte
     * 
     * Resultaat
     *    Tijdsefficiëntie = O(log(N))
     *    Geheugenefficiëntie = O(log(N))
     * 
     * 
     * @param song
     */
    void addSong(Song song) {
        songs.add(song);

		// zoek of maak de lijst voor deze artiest
        var listForArtist = songIndexesForArtist.get(song.getArtists());
        if(listForArtist == null) {
            listForArtist = new ArrayList<Integer>();
            songIndexesForArtist.put(song.getArtists(), listForArtist);
        }
        // voeg de index van song in songs toe aan de lijst voor de artiest
        listForArtist.add(songs.size() - 1);
    }

    /**
     * Toon de speellijst op volgorde van invoer
     * Zet vóór elke song het volgnummer in de lijst
     * 
     * N = songs.size()
     * Tijdsefficiëntie = O(N), elke song komt één keer aan de beurt
     * Geheugenefficiëntie = O(1), geen recursie of andere afhankelijkheid van N
     */
    void showByNumber() {
        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i));
        }
    }

    /**
     * Toon de speellijst op willekeurige volgorde
     * Zet vóór elke song het oorspronkelijke volgnummer in de lijst
     * 
     * N = songs.size()
     * Tijdsefficiëntie = O(N), elke song komt één keer aan de beurt
     * Geheugenefficiëntie = O(1), geen recursie of andere afhankelijkheid van N
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
     * 
     * N = songs.size()
     * Tijdsefficiëntie = O(N), elke song komt één keer aan de beurt
     * Geheugenefficiëntie = O(1), geen recursie of andere afhankelijkheid van N
     */
    void showByArtist() {
        for (var indexes : songIndexesForArtist.values()) {
            for(int index : indexes)
                System.out.println((index + 1) + ". " + songs.get(index));
        }
    }
}
