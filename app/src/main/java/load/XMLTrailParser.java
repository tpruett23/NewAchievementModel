package load;


import android.content.res.AssetManager;
import android.location.Location;

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
 * @version 1.2
 */
public class XMLTrailParser {

    /** trail system for the application*/
    private TrailSystem trailSystem;

    /**
     * Constructor which will initialize a new trail system
     */
    public XMLTrailParser(){
        trailSystem = new TrailSystem();
    /* end constructor */
    }

    /**
     * Sets/change the name for the trail system
     * @param trailSystemName - Name for the trail system
     */
    public void setTrailSystemName(String trailSystemName){
        trailSystem.setName(trailSystemName);
    /* end setTrailSystemName()*/
    }

    /**
     * Add a trail to the trail system
     * @param trail - predefined trail
     */
    public void addTrail(Trail trail){
        trailSystem.addTrail(trail);
    /* end addTrail()*/
    }

    /**
     * Add an empty trail to the trail system
     * @param trailName - name of the empty trail
     */
    public void addTrail(String trailName){
        Trail trail = new Trail(trailName);
        addTrail(trail);
    /* end addTrail()*/
    }

    /**
     * add point to a specific trail on the trail system
     * @param name - name of the trail
     * @param latlng - coordinates of the point
     */
    public void addPoint(String name, LatLng latlng){
        trailSystem.addPoint(name, latlng);
    /* end addPoint*/
    }

    /**
     * add point to the current trail on the trail system
     * @param latLng - coordinates to add to the trail
     */
    public void addPoint(LatLng latLng){
        trailSystem.addPoint(latLng);
    /* end addPoint()*/
    }

    /**
     * return the trail system that has been created
     * @return - uniform trail system
     */
    public TrailSystem getTrailSystem(){
        return trailSystem;
    /* end getTrailSystem */
    }
    /**
     * Adds an event using an InputStream.
     * @param the InputStream
     */
    public void addEvent(InputStream is){
        trailSystem.addEvent(is);
    }


}
