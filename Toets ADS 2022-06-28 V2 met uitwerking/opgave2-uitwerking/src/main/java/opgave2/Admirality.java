package opgave2;

import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Admirality {

    // Per piraat een lijst met gemelde schepen:
    // piraat -> lijst met schepen
    // TreeMap O(log(n)) voor alfabetische volgorde van piraten
    //  met daarin een HashSet van schepen per piraat
    //   'Hash' O(1), volgorde niet belangrijk
    //   'Set' om dubbele waarden te voorkomen
    Map<Pirate, HashSet<String>> shipsPerPirate = new TreeMap<>();

    // Per gemeld schip een lijst met meldende piraten:
    // schip -> lijst met piraten
    // TreeMap O(log(n)) voor *alfabetische* volgorde van schepen
    //  met daarin voor elk schip een LinkedHashSet van piraten
    //   'Linked' om volgorde van *toevoegen* te bewaren (om eerste te bepalen)
    //   'Hash' voor O(1)
    //   'Set' om dubbele meldingen uit te sluiten
    // LinkedHashset heeft meer overhead dan HashSet omdat er een dubbel
    // gekoppelde lijst word bijgehouden én een hash, maar blijft O(1)
    Map<String, LinkedHashSet<Pirate>> piratesPerShip = new TreeMap<>();

    /**
     * Piraten moeten melden welke schepen ze hebben buitgemaakt. Als een schip
     * voor de tweede keer door dezelfde piraat wordt gemeld, wordt dat niet nog
     * eens opgeslagen.
     *
     * De gewenste volgorde in de uitvoer en de meeste logica zit in de keuze
     * van de collectietypes. De uitvoermethodes worden daarom heel simpel.
     *
     * @param pirate: de melder
     * @param ship: het veroverde schip
     */
    void addConquest(Pirate pirate, String ship) {
        System.out.println("melding: " + pirate + " -> " + ship);

        // haal de schepenlijst voor deze piraat op
        var ships = shipsPerPirate.get(pirate);
        // maak een nieuwe als die er nog niet is
        if (ships == null) {
            ships = new HashSet<>();
            shipsPerPirate.put(pirate, ships);
        }
        // voeg het gemelde schip toe aan de schepenlijst van deze piraat
        ships.add(ship);

        // haal de piratenlijst voor dit schip op
        // maak een nieuwe als die er nog niet is
        var pirates = piratesPerShip.get(ship);
        if (pirates == null) {
            pirates = new LinkedHashSet<>();
            piratesPerShip.put(ship, pirates);
        }
        // voeg de piraat to aan de piratenlijst voor dit schip
        pirates.add(pirate);
    }

    /**
     * Afabetische lijst van piraten die iets veroverd hebben plus per piraat
     * hun veroveringen
     */
    void showPirates() {
        for (Pirate pirate : shipsPerPirate.keySet()) {
            System.out.println(pirate + " -> " + shipsPerPirate.get(pirate));
        }
    }

    /**
     * Alfabetische lijst van alle veroverde schepen met per schip de eerste
     * piraat die het gemeld heeft
     */
    void showShips() {
        for (String ship : piratesPerShip.keySet()) {
            // gebruik iterator().next() om eerste element te krijgen
            Pirate firstPirate = piratesPerShip.get(ship).iterator().next();
            System.out.println(ship + " <- " + firstPirate);
        }
    }

    /**
     * Lijst van schepen die gemeld zijn door meerdere piraten met per schip de
     * betrokken piraten
     */
    void showCheats() {
        for (String ship : piratesPerShip.keySet()) {
            Set<Pirate> pirates = piratesPerShip.get(ship);
            if (pirates.size() > 1) {
                System.out.println(ship + " <- " + pirates);
            }
        }
    }

}
