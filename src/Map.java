import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.edge.WeightedEdge;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class Map extends LinkedGraph {
    private String name;
    private ArrayList<Route> routes;

    public Map(String name){
        super();
        setName(name);
        routes = new ArrayList<Route>();
    }

    private void setName(String name){
        if(!name.replaceAll(" ", "").equals("")){
            this.name = name;
        }
        else{
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }
    public String getName(){
        return name;
    }

    /**
     * Metodo para obtener la posicion de una parada en la lista de vertices
     * @param b
     * @return
     */
    public int getPos(BusStop b){
        LinkedList<Vertex> v = super.getVerticesList();
        Iterator<Vertex> iter= v.iterator();
        BusStop b1 = null;

        int i = 0;
        boolean found = false;

        while(iter.hasNext() && !found){
            b1 = (BusStop) iter.next().getInfo();
            if(b.equals(b1))
                found = true;
            i++;
        }

        return found ? i-1 : -1;
    }
    public void addBusStop(BusStop b){
        if(getPos(b) == -1) {
            insertVertex(b);
        }
    }
    public void conectBusStop(BusStop a, BusStop b, double distance){
        insertWEdgeNDG(getPos(a), getPos(b), new Target(distance));
    }
    public void addRoute(Route r){
        if(r != null){
            routes.add(r);
            ArrayList<RouteStop> stops = r.getStops();
            for(int i = 0; i < stops.size(); i++){
                if(i > 0) {
                    if(!conectedBusStopNW(stops.get(i - 1).getNext(), stops.get(i).getNext()))
                        conectBusStop(stops.get(i - 1).getNext(), stops.get(i).getNext(), stops.get(i).getDistance());
                }
                int pos = getPos(stops.get(i).getNext());
                ((BusStop) super.getVerticesList().get(pos).getInfo()).addRoute(r);

            }
        }
    }
    public boolean conectedBusStopNW(BusStop head, BusStop tail){
        boolean found = false;

        LinkedList<Edge> edges = getVerticesList().get(getPos(head)).getEdgeList();
        Iterator<Edge> iter = edges.iterator();

        while(iter.hasNext() && !found){
            WeightedEdge edge =  ((WeightedEdge) iter.next());
            Target t = (Target) edge.getWeight();

            if(((BusStop) edge.getVertex().getInfo()).equals(tail)){
                found = true;
            }
        }
        return found;
    }
    public void deleteRoute(Route r){
        Iterator<Vertex> iter = super.getVerticesList().iterator();

        while(iter.hasNext()){
            BusStop BS = ((BusStop) iter.next().getInfo());
            BS.removeRoute(r);
        }

        routes.remove(r);

    }
    public void deleteBusStop(BusStop b){
        deleteVertex(getPos(b));

        for(Route r: routes){
            r.removeBusStop(this, b);
        }
    }
    public BusStop findBusStop(BusStop bs){
        Iterator<Vertex> iter = this.getVerticesList().iterator();
        while (iter.hasNext()) {
            Vertex v = iter.next();
            if(((BusStop)v.getInfo()).getId().equalsIgnoreCase(bs.getId()))
            return (BusStop) v.getInfo();
        }
        return null;
    }

}
