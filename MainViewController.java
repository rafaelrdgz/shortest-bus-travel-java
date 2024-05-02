import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.image.BufferedImage;

import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainViewController {

    @FXML
    private Button btnAddBusStop;

    @FXML
    private Button btnDeleteBusStop;

    @FXML
    private Button btnFindBusStop;

    @FXML
    private TextField txtFieldAddBusStop;

    @FXML
    private TextField txtFieldDeleteBusStop;

    @FXML
    private TextField txtFieldFindBusStop;

    @FXML
    private ImageView imgView;

    private Map test;

    public void initialize(){
        test = new Map("test");
        imgView.setImage(null);
    }

    @FXML
    void addBusStop(ActionEvent event) {
        String id = txtFieldAddBusStop.getText();
        test.addBusStop(new BusStop(id));
        paintImg(test);
        txtFieldAddBusStop.setText("");
    }

    @FXML
    void deleteBusStop(ActionEvent event) {
        String id = txtFieldDeleteBusStop.getText();
        test.deleteBusStop(new BusStop(id));
        paintImg(test);
        txtFieldDeleteBusStop.setText("");
    }

    @FXML
    void findBusStop(ActionEvent event) {
        String id = txtFieldFindBusStop.getText();
        BusStop s = test.findBusStop(new BusStop(id));
        if(s == null)
            JOptionPane.showMessageDialog(null, "No existe la parada");
        else
            JOptionPane.showMessageDialog(null, "Si existe la parada");   
    }   

    public void paintImg(Map map){
        GraphViz gv = new GraphViz("C:/Program Files/Graphviz/bin/dot.exe", "C:/Users/rafae/Documents");
        gv.addln(gv.start_graph());
        gv.addln("rankdir=LR");

        Iterator<Vertex> iter = map.getVerticesList().iterator();
        while (iter.hasNext()) {
            Vertex v = iter.next();
            Iterator<Edge> iterEdge = v.getEdgeList().iterator();
            if(!iterEdge.hasNext()){
                gv.addln(((BusStop)v.getInfo()).getId());
            }
            while (iterEdge.hasNext()) {
                Edge e = iterEdge.next();
                gv.addln(((BusStop)v.getInfo()).getId() + " -- " + ((BusStop)e.getVertex().getInfo()).getId());
                //System.out.println(((BusStop)v.getInfo()).getId() + " -- " + ((BusStop)e.getVertex().getInfo()).getId());
            }
        }

        gv.addln(gv.end_graph());
		String type = "png";
		String repesentationType= "dot";
		File out = new File("C:/Users/rafae/Documents/Java Projects/Proyecto-Estructura-de-Datos/out." + type);
		gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, repesentationType), out );
        
        BufferedImage buff = null;
        Image im;

        try {
            buff = ImageIO.read(new File("out.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        im = SwingFXUtils.toFXImage(buff, null);

        imgView.setImage(im);
    }

}
