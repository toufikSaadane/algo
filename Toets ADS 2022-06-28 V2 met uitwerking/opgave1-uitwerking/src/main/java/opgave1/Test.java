package opgave1;

class Test {

    /**
     * Laat de inhoud van een LinkedList zien
     * 
     * @param list
     */
    private void showList(LinkedList<?> list) {
        System.out.println("## Er zijn " + list.count() + " piraten:");

        // In Opgave 5 maak je deze for-each-lus werkend
        // door de LinkedList Iterable te maken (zie aldaar)
        // Deze test-code hoef je niet aan te passen

        if (list.iterator().hasNext()) {
            System.out.println("### we gebruiken de for-each-lus");
            for (Object link : list) {
                System.out.println(link);
            }
        } else {
            System.out.println("### we gebruiken de primitieve for-lus");
            for (var current = list.first; current != null; current = current.next) {
                System.out.println(current);
            }
        }

        System.out.println();
    }

    /**
     * Alle tests
     */
    void testAll() {
        LinkedList<Pirate> pirates;

        /* werkt Insert ? */
        pirates = testInsert();
        System.out.println("# Lijst in omgekeerde volgorde");
        showList(pirates);

        /* werkt AppendSlow ? */
        pirates = testAppendSlow();
        System.out.println("# Lijst in alfabetische volgorde");
        showList(pirates);

        /* werkt AppendFast ? */
        pirates = testAppendFast();
        System.out.println("# Lijst in alfabetische volgorde");
        showList(pirates);

        /* werkt showList 2x achter elkaar ? */
        System.out.println("# Zelfde lijst als hiervoor");
        showList(pirates);
    }

    /**
     * Test insert()
     * Zet alle piraten in een linkedList
     * 
     * @return LinkedList met piraten
     */
    private LinkedList<Pirate> testInsert() {
        LinkedList<Pirate> pirates = new LinkedList<>();
        for (Pirate pirate : Pirate.getTestData()) {
            pirates.insert(pirate);
        }
        return pirates;
    }

    /**
     * Test appendSlow()
     * Zet alle piraten in een linkedList
     * 
     * @return LinkedList met piraten
     */
    private LinkedList<Pirate> testAppendSlow() {
        LinkedList<Pirate> pirates = new LinkedList<>();
        for (Pirate pirate : Pirate.getTestData()) {
            pirates.appendSlow(pirate);
        }
        return pirates;
    }

    /**
     * Test appendFast()
     * Zet alle piraten in een linkedList
     * 
     * @return LinkedList met piraten
     */
    private LinkedList<Pirate> testAppendFast() {
        LinkedList<Pirate> pirates = new LinkedList<>();
        for (Pirate pirate : Pirate.getTestData()) {
            pirates.appendFast(pirate);
        }
        return pirates;
    }
}