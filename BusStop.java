import java.util.ArrayList;

public class BusStop {
    private ArrayList<Target> nextBS;
    private ArrayList<Target> nearbyBS;
    public char c;

    public BusStop(char c) {
        nextBS = new ArrayList<Target>();
        nearbyBS = new ArrayList<Target>();
        this.c = c;
    }

    public void addNextBS(Target BS) {
        add(nextBS, BS);
    }

    public void addNearbyBS(Target BS) {
        add(nearbyBS, BS);
    }

    private void add(ArrayList<Target> list, Target BS) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            if (list.get(i).getDistance() > BS.getDistance()) break;
            i++;
        }
        list.add(i, BS);
    }

    public ArrayList<Target> getNextBS() {
        return nextBS;
    }

    public ArrayList<Target> getNearbyBS() {
        return nearbyBS;
    }
}
