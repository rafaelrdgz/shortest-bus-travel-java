import java.util.*;

public class Travel implements Comparable {
    private LinkedList<Target> travel;
    private int distance;
    private boolean walk;
    private boolean complete;

    public int getDistance() {
        return distance;
    }

    public boolean isComplete() {
        return complete;
    }

    public LinkedList<Target> getTravel() {
        return travel;
    }

    public Travel() {
        travel = new LinkedList<Target>();
        distance = 0;
        walk = true;
        complete = false;
    }

    public Travel(Travel travel, boolean walk) {
        this.travel = new LinkedList<>(travel.travel);
        this.distance = travel.distance;
        this.walk = walk;
        this.complete = travel.complete;
    }

    public boolean addBS(Target BS) {
        boolean founded = false;
        ListIterator<Target> iter = travel.listIterator();

        while (iter.hasNext()) {
            Target t = iter.next();
            if (t.getBS().c == BS.getBS().c) {
                founded = true;
                break;
            }
        }

        if (!founded) {
            travel.addLast(BS);
            distance += BS.getDistance();
            return true;
        }
        return false;
    }

    public Target getLast() {
        return travel.getLast();
    }

    public LinkedList<Travel> getNext(BusStop BS) {
        LinkedList<Travel> list = new LinkedList<Travel>();
        BusStop last = this.getLast().getBS();
        ArrayList<Target> next = last.getNextBS();
        ArrayList<Target> nearby = last.getNearbyBS();

        if (walk)
            for (Target o : nearby) {
                Travel t = new Travel(this, false);
                if (t.addBS(o)) {
                    if (o.getBS().equals(BS))
                        t.complete = true;
                    list.add(t);
                }
            }

        for (Target o : next) {
            Travel t = new Travel(this, true);
            if (t.addBS(o)) {
                if (o.getBS().equals(BS))
                    t.complete = true;
                list.add(t);
            }
        }
        if (!list.isEmpty()) Collections.sort(list);
        return list;
    }

    public void print() {
        for (Target t : travel)
            System.out.println(t.getBS().c);
        System.out.println(distance);
    }

    public int getSize() {
        return travel.size();
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(distance, ((Travel) o).distance);
    }
}

