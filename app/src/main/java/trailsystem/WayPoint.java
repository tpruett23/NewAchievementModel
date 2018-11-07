package trailsystem;


import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Waypoint class for every location of a trail
 * @author - Melchor Dominguez
 * @version - 1.0
 */
public class WayPoint {

    /** Latitude and Longitude points for the point */
    private LatLng point;

    /** Collection of events for different game-modes
     * -- This may later be changed into a key-value pair -- */
    private Collection<PointOfInterest> pOIs;

    /**
     * Constructor which will create a waypoint with a location
     * @param point - location of the waypoint
     */
    public WayPoint(LatLng point){
        setPoint(point);
        pOIs = null;
    }//end constructor

    /**
     * Constructor which will create a waypoint with a location
     * and a correlating point of interest
     * @param point - location of the waypoint
     * @param pOI - point of interface for the waypoint
     */
    public WayPoint(LatLng point, PointOfInterest pOI){
        setPoint(point);
        pOIs = null;
        addPOI(pOI);
    }//end constructor

    /**
     * Constructor which will create a WayPoint with a location
     * and a collections of points of interests
     * @param point - location of the WayPoint
     * @param pOIs - point of interfaces for the WayPoint
     */
    public WayPoint(LatLng point, Collection<PointOfInterest> pOIs){
        setPoint(point);
        this.pOIs = pOIs;
    }//end constructor;

    /**
     * Set the location for the WayPoint
     * @param point - new location
     */
    public void setPoint(LatLng point){
        this.point = point;
    }//end setPoint()

    /**
     * returns the location for the waypoint
     * @return - location
     */
    public LatLng getPoint() {
        return point;
    }//end getPoint()

    /**
     * Add a new point of interest for the WayPoint
     */
    public void addPOI(PointOfInterest pOI){

        //check if collection is already initialized
        if(pOIs == null){
            pOIs = new ArrayList<PointOfInterest>();
        }

        if (!pOIs.contains(pOI))
            pOIs.add(pOI);
    }//end addPOI

    /**
     * Return all the points of interests for the WayPoint
     * @return - points of interests
     */
    public Collection<PointOfInterest> getPOIs(){
        return pOIs;
    }//end getPOIs()

    /**
     * Removes a point of interest from the WayPoint
     * @param pOI - points of interest to be removed
     * @return - true if removed
     */
    public boolean removePOI(PointOfInterest pOI){
        if(pOIs.contains(pOI)){
            pOIs.remove(pOI);
            return true;
        }//end removePOI
        return false;
    }//end removePOI

}//end WayPoint class
