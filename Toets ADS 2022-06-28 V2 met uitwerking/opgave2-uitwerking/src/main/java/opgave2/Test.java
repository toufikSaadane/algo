package opgave2;

class Test {

    Admirality admirality = new Admirality();

    void testAll() {
        Pirate hook = Pirate.getByName("Captain Hook");
        Pirate canway = Pirate.getByName("Edward Canway");
        Pirate sparrow = Pirate.getByName("Jack Sparrow");
        Pirate piet = Pirate.getByName("Piet Piraat");
        Pirate blacky = Pirate.getByName("Blackbeard");

        admirality.addConquest(piet, "Vliegende Hollander");
        admirality.addConquest(hook, "Jack Daw");
        admirality.addConquest(piet, "Batavia");
        admirality.addConquest(canway, "Evergiven");
        admirality.addConquest(hook, "Black Pearl");
        admirality.addConquest(sparrow, "Titanic");
        admirality.addConquest(piet, "Titanic");
        admirality.addConquest(canway, "Argo");
        admirality.addConquest(blacky, "Jenny");
        admirality.addConquest(blacky, "Argo");
        admirality.addConquest(hook, "Jack Daw");
        admirality.addConquest(blacky, "Jolly Rodger");

        System.out.println("\nAfabetische lijst van piraten die iets veroverd hebben");
        System.out.println("plus per piraat hun veroveringen:");
        admirality.showPirates();

        System.out.println("\nAlfabetische lijst van alle veroverde schepen");
        System.out.println("met per schip de eerste piraat die het gemeld heeft");
        admirality.showShips();
        
        System.out.println("\nLijst van schepen die gemeld zijn door verschillende piraten");
        System.out.println("met per schip de betrokken piraten:");
        admirality.showCheats();
    }
}
