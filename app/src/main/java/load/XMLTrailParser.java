package load;


import android.content.res.AssetManager;

import com.example.toripruett.newachievementmodel.R;
import com.google.android.gms.maps.model.LatLng;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import trailsystem.Trail;
import trailsystem.TrailSystem;
import trailsystem.WayPoint;

/**
 * Uniform Class to hold constants after receiving information
 * from an xml class holding trails
 * @author Melchor Dominguez
 * @version 1.1
 */
public class XMLTrailParser {

    private TrailSystem trailSystem;

    private static final String TRAIL_SYSTEM_FILE = "wcu_trail_system.xml";

    public XMLTrailParser(){
        trailSystem = new TrailSystem();
    /* end constructor */
    }

    public void setTrailSystemName

    /**
     * parse through all the waypoints listed under the xml file
     * @param wayPointList - list which contains latitude and longitude points
     * @return - collection of waypoints
     */
    private Collection<WayPoint> parseWayPoints(NodeList wayPointList){
        ArrayList<WayPoint> wayPoints = new ArrayList<>();
        for(int temp = 0; temp < wayPointList.getLength(); temp++){
            Node wayPointNode = wayPointList.item(temp);

            if(wayPointNode.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) wayPointNode;

                Float latitude = Float.parseFloat(eElement.getElementsByTagName("latitude").item(0).toString());
                Float longitude = Float.parseFloat(eElement.getElementsByTagName("longitude").item(0).toString());
                wayPoints.add(new WayPoint(new LatLng(latitude, longitude)));
            }//end if
        }//end for
        return wayPoints;
    /* end parseWayPoints*/
    }


    public TrailSystem getTrailSystem(){
        return trailSystem;
    }

}
