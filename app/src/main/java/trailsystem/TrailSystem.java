package trailsystem;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Trail System which will contain different trails
 * to contain a whole trail system
 *
 * @author - Melchor Dominguez
 * @version - 1.2
 */
public class TrailSystem {

    /** Collection of trails associated with the trail system*/
    private Collection<Trail> trails;

    /** Name of the Trail System*/
    private String name;

    /** current trail being accessed */
    private Trail currentTrail;

    /**
     * Constructor for a trail system with no trails
     * and no name assigned
     */
    public TrailSystem(){
        trails = new ArrayList<>();
        name = "No name yet assigned";
    /* end constructor*/
    }

    /**
     * Constructor for a trail system with trail system
     * already defined; no name assigned
     */
    public TrailSystem(Collection<Trail> trails){
        this.trails = trails;
        name = "No name yet assigned";
    /* end constructor*/
    }

    /**
     * Constructor for a trail system that has an assigned name
     * @param name - name of the trail system
     */
    public TrailSystem(String name){
        trails = null;
        setName(name);
    /* end constructor*/
    }

    /**
     * Constructor for a trail system that has an assigned name and
     * predefined collection of trails
     * @param trails - trails associated to the trail system
     * @param name - name of the trail system
     */
    public TrailSystem(Collection<Trail> trails, String name){
        this.trails = trails;
        setName(name);
    /* end constructor*/
    }

    /**
     * Sets/changes the name of the trail system.
     * @param name - the new name
     */
    public void setName(String name) {
        this.name = name;
    }//end setName()

    /**
     * Gets the name of the trail system.
     * @return - the name
     */
    public String getName(){
        return name;
    }//end getName()

    /**
     * add Trail to the trail system and change the recently accessed
     * trail
     * @param trail - new trail to be added
     */
    public void addTrail(Trail trail){
        if(trail == null)
            return;
        if(!trails.contains(trail))
            trails.add(trail);
        currentTrail = trail;
    /* end addTrail()*/
    }

    /**
     * add Trail to the trail system and change the recently accessed trail
     * @param trailName
     * @param point
     */
    public void addPoint(String trailName, LatLng point){
        //check if the current trail is already in the system
        for(Trail trail: trails){
            if(trail.getName().equals(trailName)){
                currentTrail = trail;
                trail.addPoint(point);
                return;
            }//end if
        }//end for

        //create a new trail and add it to the trail system
        Trail trail = new Trail(trailName);
        trail.addPoint(point);
        addTrail(trail);
    /* end addPoint()*/
    }

    /**
     * Adds a point to the most recently accessed trail system
     * @param point - new latitude and longitude points to add to the trail system
     */
    public void addPoint(LatLng point){
        currentTrail.addPoint(point);
    /* end addPoint()*/
    }

    /**
     * Returns the collections of trails contained
     * within the trail system
     * @return - the collections of trails in the trail system
     */
    public Collection<Trail> getTrails(){
        return trails;
    /* end getTrails*/
    }

    /**
     * Add an empty trail with a specified name
     * @param name
     */
    public void addTrail(String name){
        //check if there is already a trail with the specified name
        for (Trail trail: trails){
            if(trail.getName().equals(name)){
                currentTrail = trail;
                return;
            }//end if
        }//end for

        //create a new trail and add it to the trail system
        Trail trail = new Trail(name);
        trails.add(trail);
        currentTrail = trail;

    /* end addTrail()*/
    }

    /**
     * Method to forward the location to the trails and update trail progress
     * accordingly
     * @param location - location received from the user
     */
    public Collection<LatLng> updateLocation(Location location){
        Collection<LatLng> points = new ArrayList<>();
        for(Trail trail: trails){
             Collection<WayPoint> trailProgress = trail.checkProgress(location);
             if(trailProgress == null)
                 break;
             for(WayPoint wayPoint: trailProgress){
                 points.add(wayPoint.getPoint());
             }
             if (points.size() > 0)
                return points;
        }
        return null;
    /* end updateLocation()*/
    }
}
