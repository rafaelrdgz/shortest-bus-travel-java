public class RouteStop {
    private BusStop next;
    private double distance;

    public RouteStop(BusStop next, double distance){
        setBusStop(next);
        setDistance(distance);
    }
    private void setBusStop(BusStop next){
        if(next != null){
            this.next = next;
        }
        else{
            throw new IllegalArgumentException("La parada no puede ser vacia");
        }
    }
    public void setDistance(double distance){
        if(distance >= 0 && distance < Main.maxDistance ){
            this.distance = distance;
        }
        else{
            throw new IllegalArgumentException("La distancia tiene que estar entre 0 y 3000 metros");
        }
    }
    public BusStop getNext(){
        return next;
    }
    public double getDistance(){
        return distance;
    }

}
