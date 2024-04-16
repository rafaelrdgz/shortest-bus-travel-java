public class Target implements Comparable{
    private BusStop BS;
    private int distance;

    public Target(BusStop BS, int distance) {
        setBS(BS);
        setDistance(distance);
    }

    public BusStop getBS() {
        return BS;
    }

    public int getDistance() {
        return distance;
    }

    private void setBS(BusStop BS) {
        if (BS == null)
            throw new IllegalArgumentException("BS null");
        else
            this.BS = BS;
    }

    private void setDistance(int distance) {
        if(distance < 0)
            throw new IllegalArgumentException("La distancia tiene que ser mayor que 0");
        else
            this.distance = distance;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(distance, ((Target)o).distance);
    }

}
