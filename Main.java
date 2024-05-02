import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        BusStop A = new BusStop("A");
        BusStop B = new BusStop("B");
        BusStop C = new BusStop("C");
        BusStop D = new BusStop("D");
        BusStop E = new BusStop("E");
        BusStop F = new BusStop("F");
        BusStop G = new BusStop("G");
        BusStop H = new BusStop("H");
        BusStop I = new BusStop("I");
        BusStop J = new BusStop("J");
        BusStop K = new BusStop("K");
        BusStop L = new BusStop("L");

        Route A1 = new Route("A1");
        A1.addBS(new Target(A,0, true));
        A1.addBS(new Target(B,4, false));
        A1.addBS(new Target(C,2, false));
        A1.addBS(new Target(A,3, false));

        Route A2 = new Route("A2");
        A2.addBS(new Target(E,0, true));
        A2.addBS(new Target(H,3, false));
        A2.addBS(new Target(I,4, false));
        A2.addBS(new Target(C,4, false));
        A2.addBS(new Target(B,2, false));
        A2.addBS(new Target(E,3, false));

        Route A3 = new Route("A3");
        A3.addBS(new Target(E,0, true));
        A3.addBS(new Target(F,2, false));
        A3.addBS(new Target(D,5, false));
        A3.addBS(new Target(E,3, false));

        Route A4 = new Route("A4");
        A4.addBS(new Target(E,0, true));
        A4.addBS(new Target(H,3, false));
        A4.addBS(new Target(G,2, false));
        A4.addBS(new Target(E,2, false));

        Route A5 = new Route("A5");
        A5.addBS(new Target(A,0, true));
        A5.addBS(new Target(K,10, false));
        A5.addBS(new Target(L,2, false));
        A5.addBS(new Target(H,5, false));
        A5.addBS(new Target(I,4, false));
        A5.addBS(new Target(J,4, false));
        A5.addBS(new Target(K,3, false));

        A.addNearbyBS(new Target(B, 3, true));
        B.addNearbyBS(new Target(A, 3, true));
        B.addNearbyBS(new Target(H, 2, true));
        H.addNearbyBS(new Target(B, 2, true));

        Map m = Map.getInstance();
        Travel t = m.getTravel(A, D);
        t.print();

        LinkedList<Pair<Route, BusStop>> list = m.getRoutes(t);
        for (Pair<Route, BusStop> p: list) {
            if(p.getKey() == null) System.out.println("Camina hacia la parada " + p.getValue().getId());
            else System.out.println("Coge el omnibus " + p.getKey().getId() + " hasta la parada " + p.getValue().getId());
        }
    }
}
