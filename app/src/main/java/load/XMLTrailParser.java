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

public class XMLTrailParser {

    private DocumentBuilderFactory docFactory;
    private DocumentBuilder docBuilder;
    private Document document;

    private TrailSystem trailSystem;

    private static final String TRAIL_SYSTEM_FILE = "wcu_trail_system.xml";

    public XMLTrailParser(){

        File trailFile = new File(TRAIL_SYSTEM_FILE);
        docFactory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = docFactory.newDocumentBuilder();
            document = docBuilder.parse(trailFile);

            document.getDocumentElement().normalize();

            parseFile();

        }catch(ParserConfigurationException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch(SAXException e){
            e.printStackTrace();
        }
    /* End Constructor */
    }

    public XMLTrailParser(InputStream inputStream){
        try{
            docFactory = DocumentBuilderFactory.newInstance();
            docFactory.setNamespaceAware(false);
            docFactory.setValidating(false);
            docBuilder = docFactory.newDocumentBuilder();
            document = docBuilder.parse(inputStream);

            parseFile();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    /**
     * Helper method to parse through the entire file creating a trail system
     */
    private void parseFile(){
        //gather the trail system from the xml
        NodeList tsList = document.getElementsByTagName("trail_system");
        //Create the trail system
        trailSystem = new TrailSystem(( (Element) tsList.item(0)).getAttribute("name"));

        //gather the list of trails
        NodeList trailList = document.getElementsByTagName("trail");

        //parse through the trails
        for(int temp = 0; temp < trailList.getLength(); temp++){
            Node trailNode = trailList.item(temp);
            //create a trail
            Trail trail = new Trail();
            if(trailNode.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) trailNode;

                //set the name of the trail
                trail.setName(eElement.getElementsByTagName("name").item(0).toString());

                NodeList waypointList = eElement.getElementsByTagName("waypoint");

                //add each waypoint to trail
                Collection<WayPoint> wayPoints = parseWayPoints(waypointList);
                for(WayPoint wayPoint: wayPoints){
                    trail.addPoint(wayPoint);
                }//end for

            }//end if
            trailSystem.addTrail(trail);
        }//end for

    /* end parseFile*/
    }

    /***
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
