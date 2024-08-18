package opgave1;

import java.util.Iterator;

/**
 * De LinkedList bevat in eerste instantie
 * alleen een verwijzing naar de eerste Node
 */
class LinkedList<Item> implements Iterable<Item> {

    Node first;
    Node last; // for OPGAVE 3
    int size; // for OPGAVE 4

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

        // OPGAVE 1: Voeg de toString methode toe
        @Override
        public String toString() {
            return item.toString();
        }
    }

    LinkedList() {
        first = null;
        last = null; // for OPGAVE 3
        size = 0; // for OPGAVE 4
    }

    /**
     * Voeg een item toe aan het BEGIN van de lijst
     * 
     * @param item
     */
    void insert(Item item) {
        if (first == null) {
            first = new Node(item);
            last = first; // for OPGAVE 3
        } else {
            Node link = new Node(item);
            link.next = first;
            first = link;
        }
        size++; // for OPGAVE 4
    }

    // OPGAVE 2: maak de methode appendSlow()
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
            size++; // for OPGAVE 4
        }
    }

    // OPGAVE 3: maak de methode appendFast()
    void appendFast(Item item) {
        Node newNode = new Node(item);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++; // for OPGAVE 4
    }

    // OPGAVE 4: maak de count() efficienter
    int count() {
        return size;
    }

    // OPGAVE 5: maak de for-each-lus in Test.showList() werkend
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item item = current.item;
                current = current.next;
                return item;
            }
        };
    }
}
