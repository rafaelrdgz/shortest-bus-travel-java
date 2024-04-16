import java.util.LinkedList;

public class Map {
    private Map() {}

    public static Travel getTravel(BusStop start, BusStop end) {
        Travel travel = new Travel();
        travel.addBS(new Target(start, 0));
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
}
