import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;

public class Map {
    private static Map instance;
    private ArrayList<Route> list;

    private Map() {
        list = new ArrayList<Route>();
    }

    public static Map getInstance() {
        if (instance == null)
            instance = new Map();
        return instance;
    }

    public void addRoute(Route r) {
        list.add(r);
    }

    public Travel getTravel(BusStop start, BusStop end) {
        Travel travel = new Travel();
        travel.addBS(new Target(start, 0, false));
        LinkedList<Travel> list = travel.getNext(end);
        travel = null;

        while (true) {
            if (!list.isEmpty()) {
                Travel t = list.removeFirst();
                if (t.isComplete() && (travel == null || t.getDistance() < travel.getDistance() || (t.getDistance() == travel.getDistance() && t.getSize() < travel.getSize())))
                    travel = t;

                list.addAll(t.getNext(end));
            } else break;
        }

        return travel;
    }

    public LinkedList<Pair<Route, BusStop>> getRoutes(Travel t) {
        ArrayList<Target> targetList = new ArrayList<Target>(t.getTravel());
        LinkedList<Pair<Route, BusStop>> pair = new LinkedList<>();

        Pair<Route, BusStop> p = new Pair<>(null, targetList.get(0).getBS());
        pair.add(p);

        ArrayList<Route> routes = new ArrayList<>();

        for (int i = 1; i < targetList.size(); i++)
            if (targetList.get(i).isWalk()) {
                p = new Pair<>(null, targetList.get(i).getBS());
                pair.add(p);
            } else {
                routes = p.getValue().getRoutes();
                int mayor = 0;
                for (Route r : routes) {
                    int aux = 0;
                    for (int j = i; j < targetList.size(); j++) {
                        if (targetList.get(j).isWalk()) break;
                        if (r.exist(targetList.get(j - 1).getBS(), targetList.get(j).getBS(), targetList.get(j).getDistance())) {
                            aux++;
                        } else{
                            System.out.println(targetList.get(j).getBS().getId());
                            break;
                        }
                    }
                    if (aux > mayor) {
                        mayor = aux;
                        p = new Pair<>(r, targetList.get(i + mayor - 1).getBS());
                    }
                }
                pair.add(p);
                i += mayor - 1;
            }
        return pair;
    }
}
