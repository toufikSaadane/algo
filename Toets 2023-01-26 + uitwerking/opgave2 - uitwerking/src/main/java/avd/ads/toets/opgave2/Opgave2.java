package avd.ads.toets.opgave2;

public class Opgave2 {

    public static void main(String[] args) {
        Test test = new Test();
        test.testAll();
    }
}

class Test {

    void testAll() {
        Playlist frans = new Playlist("Frans");
        Playlist ivo = new Playlist("Ivo");
        Playlist henk = new Playlist("Henk");

        henk.addSong(new Song("Barabas").addArtist("Hooverphonic"));
        henk.addSong(new Song("Het Smurfenlied").addArtist("Vader Abraham").addArtist("De Smurfen"));
        henk.addSong(new Song("De Marsupilami").addArtist("Dennie Christian").addArtist("Guust Flater"));
        henk.addSong(new Song("Lucky Luke").addArtist("Pater Moeskroen"));
        henk.addSong(new Song("Oh Superman").addArtist("Laurie Anderson"));
        henk.addSong(new Song("Speedy Gonzalez").addArtist("Pat Boone"));
        henk.addSong(new Song("Snoopy").addArtist("The Playboys"));

        frans.addSong(new Song("Lucky Luke").addArtist("Pater Moeskroen"));
        frans.addSong(new Song("Speedy Gonzalez").addArtist("Pat Boone"));
        frans.addSong(new Song("Asterix").addArtist("Dizzy Man's Band"));
        frans.addSong(new Song("Obelix").addArtist("Dizzy Man's Band"));
        frans.addSong(new Song("Snoopy").addArtist("The Playboys"));
        frans.addSong(new Song("Oh Superman").addArtist("Laurie Anderson"));
        frans.addSong(new Song("Barabas").addArtist("Hooverphonic"));

        ivo.addSong(new Song("Het Smurfenlied").addArtist("Vader Abraham").addArtist("De Smurfen"));
        ivo.addSong(new Song("De Marsupilami").addArtist("Dennie Christian").addArtist("Guust Flater"));
        ivo.addSong(new Song("Lucky Luke").addArtist("Pater Moeskroen"));
        ivo.addSong(new Song("Asterix").addArtist("Dizzy Man's Band"));
        ivo.addSong(new Song("Oh Superman").addArtist("Laurie Anderson"));
        ivo.addSong(new Song("Speedy Gonzalez").addArtist("Pat Boone"));
        ivo.addSong(new Song("Snoopy").addArtist("The Playboys"));

        Player player = new Player();
        player.addPlaylist(frans);
        player.addPlaylist(ivo);
        player.addPlaylist(henk);

        System.out.println();

        System.out.println("Playlists waar Dizzy Man's Band in staat");
        System.out.println("==========================================");
        player.showPlayListsForArtist("Dizzy Man's Band");
        System.out.println();

        System.out.println("Playlist Frans op nummervolgorde");
        System.out.println("==========================================");
        frans.showByNumber();
        System.out.println();

        System.out.println("Playlist Frans op willekeurige volgorde");
        System.out.println("==========================================");
        frans.showRandom();
        System.out.println();

        System.out.println("Playlist Frans op volgorde van artiest");
        System.out.println("==========================================");
        frans.showByArtist();
        System.out.println();

    }
}