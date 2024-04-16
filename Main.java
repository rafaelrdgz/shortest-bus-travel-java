public class Main {
    public static void main(String[] args){
        BusStop A = new BusStop('A');
        BusStop B = new BusStop('B');
        BusStop C = new BusStop('C');
        BusStop D = new BusStop('D');
        BusStop E = new BusStop('E');
        BusStop F = new BusStop('F');
        BusStop G = new BusStop('G');
        BusStop H = new BusStop('H');
        BusStop I = new BusStop('I');
        BusStop J = new BusStop('J');
        BusStop K = new BusStop('K');
        BusStop L = new BusStop('L');

        A.addNextBS(new Target(B, 4));
        A.addNextBS(new Target(C, 3));
        A.addNextBS(new Target(K, 10));
        B.addNextBS(new Target(A, 3));
        B.addNextBS(new Target(C, 2));
        B.addNextBS(new Target(E, 3));
        C.addNextBS(new Target(A, 3));
        C.addNextBS(new Target(B, 2));
        C.addNextBS(new Target(I, 4));
        D.addNextBS(new Target(E, 3));
        D.addNextBS(new Target(F, 5));
        E.addNextBS(new Target(F, 2));
        E.addNextBS(new Target(D, 3));
        E.addNextBS(new Target(B, 3));
        E.addNextBS(new Target(G, 2));
        E.addNextBS(new Target(H, 3));
        F.addNextBS(new Target(D, 5));
        F.addNextBS(new Target(E, 2));
        G.addNextBS(new Target(E, 2));
        G.addNextBS(new Target(H, 2));
        H.addNextBS(new Target(E, 3));
        H.addNextBS(new Target(G, 2));
        H.addNextBS(new Target(I, 4));
        H.addNextBS(new Target(L, 5));
        I.addNextBS(new Target(H, 4));
        I.addNextBS(new Target(C, 4));
        I.addNextBS(new Target(J, 4));
        J.addNextBS(new Target(I, 4));
        J.addNextBS(new Target(K, 3));
        K.addNextBS(new Target(K, 3));
        K.addNextBS(new Target(A, 10));
        K.addNextBS(new Target(L, 2));
        L.addNextBS(new Target(K, 2));
        L.addNextBS(new Target(H, 5));

        A.addNearbyBS(new Target(B, 3));
        B.addNearbyBS(new Target(A, 3));
        B.addNearbyBS(new Target(H, 2));
        H.addNearbyBS(new Target(B, 2));

        Map.getTravel(A, H).print();
    }
}
