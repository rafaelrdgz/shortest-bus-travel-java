import java.util.ArrayList;

public class BusStop implements Comparable {

    private String id;
    private ArrayList<Route> routes;

    public BusStop(String id){
        setId(id);
        routes = new ArrayList<Route>();
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
    public void addRoute(Route r){
        if(r != null && !routes.contains(r))
            routes.add(r);
    }
    public void removeRoute(Route r){
        routes.remove(r);
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
