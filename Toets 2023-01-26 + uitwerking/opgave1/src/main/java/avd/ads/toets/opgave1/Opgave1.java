package avd.ads.toets.opgave1;

public class Opgave1 {

    public static void main(String[] args) {
        Test test = new Test();
        test.testAll();
    }
}

class Test {

    Node<String> a, b, c, d, e, f, g, k, m;

    private void setup() {
        a = new Node<String>("a");
        b = new Node<String>("b");
        c = new Node<String>("c");
        d = new Node<String>("d");
        e = new Node<String>("e");
        f = new Node<String>("f");
        g = new Node<String>("g");
        k = new Node<String>("k");
        m = new Node<String>("m");
    }

    /**
     * Alle tests
     */
    void testAll() {
        System.out.println();
        testNormal();
        testInsertTwice();
        testInsertDeleteInsert();
    }

    /**
     * Test of er een boom kan worden opgebouwd
     */
    private void testNormal() {
        System.out.println("Test normal tree");
        System.out.println("==========================================");
        setup();

        a.addChild(b);
        a.addChild(c);
        b.addChild(k);
        b.addChild(m);
        c.addChild(d);
        d.addChild(e);
        d.addChild(f);
        d.addChild(g);

        a.printTree();
        System.out.println();
    }

    /**
     * Test of er wordt opgemerkt dat een node twee keer als child wordt opgevoerd
     */
    private void testInsertTwice() {

        System.out.println("Test add twice");
        System.out.println("==========================================");

        setup();

        a.addChild(b);
        a.addChild(c);
        c.addChild(e);
        c.addChild(d);
        b.addChild(e);  // zou foutmelding moeten geven

        a.printTree();
        System.out.println();
    }

    /**
     * Test of een child correct wordt verwijderd en opnieuw toegevoegd
     */
    private void testInsertDeleteInsert() {

        System.out.println("Test add, remove, add");
        System.out.println("==========================================");

        setup();

        a.addChild(b);
        a.addChild(c);
        c.addChild(e);
        c.addChild(d);
        c.removeChild(e);
        b.addChild(e);

        a.printTree();
        System.out.println();
    }
}