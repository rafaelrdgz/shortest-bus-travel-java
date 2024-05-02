public class Target implements Comparable {
    private BusStop BS;
    private int distance;
    private boolean walk;

    public Target(BusStop BS, int distance, boolean walk) {
        setBS(BS);
        setDistance(distance);
        this.walk = walk;
    }

    public BusStop getBS() {
        return BS;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isWalk() {
        return walk;
    }

    private void setBS(BusStop BS) {
        if (BS == null)
            throw new IllegalArgumentException("BS null");
        else
            this.BS = BS;
    }

    private void setDistance(int distance) {
        if (distance < 0)
            throw new IllegalArgumentException("La distancia tiene que ser mayor que 0");
        else
            this.distance = distance;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(distance, ((Target) o).distance);
    }

    @Override
    public boolean equals(Object o) {
        Target t = (Target) o;
        return t.getDistance() == this.distance && t.getBS().getId().equalsIgnoreCase(this.getBS().getId()) && this.walk == t.walk;
    }
}
