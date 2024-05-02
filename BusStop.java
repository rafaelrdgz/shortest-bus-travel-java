import java.util.ArrayList;

public class BusStop implements Comparable {
    private ArrayList<Target> nextBS;
    private ArrayList<Target> nearbyBS;
    private ArrayList<Route> routes;
    private String id;

    public BusStop(String id) {
        nextBS = new ArrayList<Target>();
        nearbyBS = new ArrayList<Target>();
        routes = new ArrayList<Route>();
        setId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addNextBS(Target BS) {
        add(nextBS, BS);
    }

    public void addNearbyBS(Target BS) {
        add(nearbyBS, BS);
    }

    public void addRoute(Route r) {
        if (!routes.contains(r)) routes.add(r);
    }

    private void add(ArrayList<Target> list, Target BS) {
        if (!list.contains(BS)) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                if (list.get(i).getDistance() > BS.getDistance()) break;
                i++;
            }
            list.add(i, BS);
        }
    }

    public ArrayList<Target> getNextBS() {
        return nextBS;
    }

    public ArrayList<Target> getNearbyBS() {
        return nearbyBS;
    }

    public ArrayList<Route> getRoutes() {
        return routes;
    }

    @Override
    public int compareTo(Object o) {
        return id.compareTo(((BusStop)o).getId());
    }

    @Override
    public boolean equals(Object o) {
        return ((BusStop) o).getId().equalsIgnoreCase(id);
    }
}
