package avd.ads.toets.opgave1;

import java.util.List;
import java.util.LinkedList;

/**
 * Elke Node bevat een Item, een verwijzing naar zijn parent en een lijst met
 * children
 *
 * @author fjspijke
 * @param <Item>
 */
class Node<Item> {

    // Elke Node bevat een Item, een verwijzing naar zijn parent en een lijst met
    // children
    private Item value;
    private Node<Item> parent;
    private List<Node<Item>> children;

    /**
     * Maak een nieuwe node met een waarde
     * Zet parent op nul en maak een lege lijst children
     * 
     * @param value
     */
    Node(Item value) {
        this.value = value;
        parent = null;
        children = new LinkedList<Node<Item>>();
    }

    /**
     * Voeg een bestaande node toe aan this.children
     * Vul de parent van de toe te voegen node met de juiste waarde
     * -> Schrijf een melding naar System.err als de node al ergens een child is
     * Zie voorbeelduitvoer
     * 
     * Tijdefficiëntie: O(1), er wordt een element toegevoegd aan een linked list.
     * Onfahankelijk val de lengte is er altijd direct een link naar het invoegpunt bekend.
     * De lijst hoeft niet doorlopen te worden.
     * 
     * Geheugenefficiëntie: O(1), er is geen extra geheugen nodig.
     * 
     * @param node
     */
    void addChild(Node<Item> node) {
        if (node.parent != null) {
            System.err.println("Cannot add '" + node.value + "' to '" + this.value + "'. It's already in '"
                    + node.parent.value + "'");
            return;
        }
        children.add(node);
        node.parent = this;
    }

    /**
     * Verwijder een bestaande node uit de lijst children
     * Zorg dat de parent wordt aangepast
     * 
     * Tijdefficiëntie: O(1), er wordt een element toegevoegd aan een linked list.
     * Onfahankelijk val de lengte is er altijd direct een link naar de te verwijderen node bekend.
     * De lijst hoeft niet doorlopen te worden.
     * 
     * Geheugenefficiëntie: O(1), er is geen extra geheugen nodig.
     * 
     * @param node
     */
    void removeChild(Node<Item> node) {
        if (node.parent == this) {
            children.remove(node);
            node.parent = null;
        }
    }

    /**
     * De volgende functies werken. Niks aan veranderen!
     * 
     * Tijdefficeëntie: O(n), elke node moet worden afgedrukt
     * Geheugenefficiëntie: best case O(log(n)) bij een gebalanceerde boom,
     *   worst case O(n) bij een uiterst ongebalanceerde boonm (= linked list).
     *   Geheugenefficiëntie = stackdiepte, wordt bepaald door de diepte van de boom.
     */
    void printTree() {
        printTree("", this, false, true);
    }

    private void printTree(String prefix, Node<Item> node, boolean isLeft, boolean isFirst) {
        if (node == null) {
            return;
        }
        if (!isFirst) {
            System.out.print(prefix);
            System.out.print(isLeft ? "├──" : "└──");
        }
        System.out.println(node.value);
        prefix += (isFirst ? "" : isLeft ? "│  " : "   ");
        Node<Item> toPrint = null;
        for (Node<Item> child : node.children) {
            printTree(prefix, toPrint, true, false);
            toPrint = child;
        }
        printTree(prefix, toPrint, false, false);
    }

}