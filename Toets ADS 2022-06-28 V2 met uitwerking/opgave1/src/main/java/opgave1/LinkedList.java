package opgave1;

import java.util.Arrays;
import java.util.Iterator;

/**
 * De LinkedList bevat in eerste instantie
 * alleen een verwijzing naar de eerste Node
 */
class LinkedList<Item> implements Iterable<Item> {

    Node first;

    /**
     * Een Node bevat een Item (in ons geval een Pirraat)
     * en een verwijzing naar de volgende Node
     * Als er geen volgende node is, is die verwijzing null
     */
    class Node {

        Item item;
        Node next;

        Node(Item item) {
            this.item = item;
            this.next = null;
        }

        //
        // OPGAVE 1:
        //
        // Zorg ervoor dat je in lijst van piraten hun namen ziet, niet de Link-adressen
        // Voeg daarvoor hieronder een methode toString() toe aan Node
        // ...

        @Override
        public String toString() {
            return item.toString();
        }
    }

    LinkedList() {
        first = null;
    }

    /**
     * Voeg een item toe aan het BEGIN van de lijst
     * 
     * @param item
     */
    void insert(Item item) {
        if (first == null) {
            first = new Node(item);
        } else {
            Node link = new Node(item);
            link.next = first;
            first = link;
        }
    }

    //
    // OPGAVE 2:
    // maak de methode appendSlow() die een Item aan het einde van de lijst
    // toevoegt.
    // deze zoekt steeds naar het einde van de lijst, wat resulteert in Big O(n)
    //
    /**
     * Voeg een item toe aan het EINDE van de lijst
     * 
     * @param item
     */
    void appendSlow(Item item) {
        if (first == null) {
            insert(item);
        } else {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(item);
        }

        System.out.println("## Er zijn " + count() + " piraten:");
    }

    //
    // OPGAVE 3:
    // maak de methode appendFast() die een Item aan het einde van de lijst
    // toevoegt.
    // hou wat extra administratie bij om altijd te weten wat de laatste Link is:
    // je hebt niet alleen 'first' nodig, maar ook 'last'
    // dit resulteert in Big O(1)
    //
    void appendFast(Item item) {

    }

    //
    // OPGAVE 4:
    // maak de count() efficienter door al te tellen in insert en append()
    // deze methode kan dan veel simpeler, zonder loop
    // count() wordt dan: Big O(1)
    //
    int count() {
        int counter = 0;
        for (Node current = first; current != null; current = current.next) {
            counter++;
        }
        return counter;
    }

    //
    // OPGAVE 5:
    // maak de for-each-lus in Test.showList() werkend
    // door de LinkedList Iterable te maken
    // vul daarvor de onderstaande methodes hasNext() en next()
    //
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node current = first;

            /**
             * Geef aan of er nog een volgende Node is
             */
            @Override
            public boolean hasNext() {
                return false;
            }

            /**
             * Geef de inhoud van de eerstvolgende Node
             * en stap naar het volgende
             */
            @Override
            public Item next() {
                return null;
            }
        };

    }
}
