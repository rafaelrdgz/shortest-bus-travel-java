import java.util.ArrayList;

public class Route {
    private ArrayList<Target> BSList;
    private String id;

    public Route(String id) {
        this.id = id;
        this.BSList = new ArrayList<>();
    }

    public void addBS(Target BS) {
        if (BS == null)
            throw new IllegalArgumentException();
        else {
            if (BSList.isEmpty())
                BSList.add(new Target(BS.getBS(), 0, false));
            else {
                BusStop bs = BSList.get(BSList.size() - 1).getBS();
                bs.addNextBS(BS);
                BS.getBS().addNextBS(new Target(bs, BS.getDistance(), false));
                BSList.add(BS);
            }

            BS.getBS().addRoute(this);
        }
    }

    public ArrayList<Target> getBSList() {
        return BSList;
    }

    public String getId() {
        return id;
    }

    public boolean exist(BusStop BS1, BusStop BS2, int distance){
        for (int i = 1; i < BSList.size(); i++){
            BusStop aux = BSList.get(i - 1).getBS();
            if(aux.equals(BS1) || aux.equals(BS2)){
                aux = BSList.get(i).getBS();
                if((aux.equals(BS1) || aux.equals(BS2)) && BSList.get(i).getDistance() == distance)
                    return true;
            }
        }
        return false;
    }
}
