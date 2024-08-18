package opgave2;

class Pirate implements Comparable<Pirate> {

    private final String area;
    private final String name;

    Pirate(String area, String name) {
        this.area = area;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " (" + area + ")";
    }

    /**
     * De lijst van piraten
     */
    private final static Pirate[] allPirates = new Pirate[]{
        new Pirate("SE", "Barbossa"),
        new Pirate("SE", "Blackbeard"),
        new Pirate("N", "Captain Hook"),
        new Pirate("NW", "Edward Canway"),
        new Pirate("NE", "Grace O'Malley"),
        new Pirate("N", "Jack Sparrow"),
        new Pirate("S", "Piet Piraat"),
        new Pirate("E", "Sayyida al-Hurra"),
        new Pirate("S", "Willem van der Decken")
    };

    static Pirate[] getTestData() {
        return allPirates;
    }

    static Pirate getByName(String name) {
        for (Pirate pirate : allPirates) {
            if (pirate.name.equals(name)) {
                return pirate;
            }
        }
        return null;
    }

    @Override
    public int compareTo(Pirate that) {
        return this.name.compareTo(that.name);
    }

}
