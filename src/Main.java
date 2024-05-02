import cu.edu.cujae.ceis.graph.vertex.Vertex;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static final int maxDistance = 3000;
    public static final int minDistance = 100;
    public static void main(String[] args) {

        Map test = new Map("test");

        BusStop b1 = new BusStop("A");
        BusStop b2 = new BusStop("B");
        BusStop b3 = new BusStop("C");
        BusStop b4 = new BusStop("D");
        BusStop b5 = new BusStop("E");
        BusStop b6 = new BusStop("F");
        BusStop b7 = new BusStop("G");
        BusStop b8 = new BusStop("H");
        BusStop b9 = new BusStop("I");
        BusStop b10 = new BusStop("J");
        BusStop b11 = new BusStop("K");
        BusStop b12 = new BusStop("L");

        test.addBusStop( b1 );
        test.addBusStop( b2 );
        test.addBusStop( b3 );
        test.addBusStop( b4 );
        test.addBusStop( b5 );
        test.addBusStop( b6 );
        test.addBusStop( b7 );
        test.addBusStop( b8 );
        test.addBusStop( b9 );
        test.addBusStop( b10);
        test.addBusStop( b11);
        test.addBusStop( b12);

        Route r1 = new Route("A1");
        r1.addStop(b1, 0);
        r1.addStop(b8, 680);
        r1.addStop(b3, 200);
        r1.addStop(b7, 480);

        test.addRoute(r1);

        test.deleteBusStop(b8);
        test.deleteRoute(r1);



    }
}