package avd.ads.toets.opgave1;

import java.util.List;

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
    }

    /**
     * Voeg een bestaande node toe aan this.children
     * Vul de parent van de toe te voegen node met de juiste waarde
     * -> Schrijf een melding naar System.err als de node al ergens een child is
     * Zie voorbeelduitvoer
     * 
     * @param node
     */
    void addChild(Node<Item> node) {
    }

    /**
     * Verwijder een bestaande node uit de lijst children
     * Zorg dat de parent wordt aangepast
     * 
     * @param node
     */
    void removeChild(Node<Item> node) {
    }

    /**
     * De volgende functies werken. Niks aan veranderen!
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