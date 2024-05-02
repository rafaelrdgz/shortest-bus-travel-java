public class Target {

    private double distance;
    private boolean walk;

    public Target(double distance){
        setDistance(distance);
        this.walk = distance <= 500;
    }

    private void setDistance(double distance){
        if(distance >= Main.minDistance && distance < Main.maxDistance ){
            this.distance = distance;
        }
        else{
            throw new IllegalArgumentException("La distancia tiene que estar entre 100 y 3000 metros");
        }
    }
    public double getDistance(){
        return distance;
    }
    public boolean getWalk(){
        return walk;
    }

}
