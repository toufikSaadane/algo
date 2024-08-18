package opgave1;

class Pirate {

    private final String name;

    Pirate(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Testgegevens: een alfabetisch gesorteerde lijst van piraten
     */
    private final static Pirate testData[] = new Pirate[]{
        new Pirate("Barbossa"),
        new Pirate("Blackbeard"),
        new Pirate("Captain Hook"),
        new Pirate("Edward Canway"),
        new Pirate("Grace O'Malley"),
        new Pirate("Jack Sparrow"),
        new Pirate("Piet Piraat"),
        new Pirate("Sayyida al-Hurra"),
        new Pirate("Willem van der Decken")
    };

    static Pirate[] getTestData() {
        return testData;
    }

}
