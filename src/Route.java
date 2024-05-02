import java.util.ArrayList;

public class Route {

    private String id;
    private ArrayList<RouteStop> stops;

    public Route(String id){
        setId(id);
        stops = new ArrayList<RouteStop>();
    }
    private void setId(String id){
        if(!id.replaceAll(" ", "").equals("")){
            this.id = id;
        }
        else{
            throw new IllegalArgumentException("El id no puede estar vacío");
        }
    }
    public String getId(){
        return id;
    }
    public ArrayList<RouteStop> getStops(){
        return stops;
    }
    public void addStop(BusStop next, int distance){
        stops.add(new RouteStop(next, distance));
    }
    public void removeBusStop(Map m, BusStop b){

        int pos = findBusStop(b);
        if(pos != -1){
            if(pos == 0)
                stops.get(1).setDistance(0);
            else{
                RouteStop rs = stops.get(pos+1);
                rs.setDistance(rs.getDistance() + stops.get(pos).getDistance());
                m.conectBusStop(stops.get(pos-1).getNext(), rs.getNext(), rs.getDistance());
            }
            stops.remove(pos);
        }
    }
    public int findBusStop(BusStop b){
        boolean found = false;
        int i;
        for(i = 0; i < stops.size() && !found; i++){
            if(stops.get(i).getNext().equals(b)){
                found = true;
            }
        }

        return found ? i-1 : -1;
    }

}
