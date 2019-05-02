package trailsystem;

import android.location.Location;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Trail class which will model a specific trail
 * @author - Melchor Dominguez
 * @version - 1.1
 */
public class Trail {

    /** The collections of WayPoints on the trail*/
    private Collection<WayPoint> path;
    /** The name of the trail*/
    private String name;
    /** The beginning of the trail*/
    private WayPoint start;
    /** The end of the trail*/
    private WayPoint end;
    /** The progress achieved of the trail*/
    private TrailProgress progress;

    private LinkedList<WayPoint> events;

    /**
     * Initialize a completely empty trail
     */
    public Trail(){
        path = new ArrayList<>();
        name = "";
        start = null;
        end = null;
        progress = new TrailProgress();
        events = new LinkedList<WayPoint>();
    /* end constructor*/
    }

    /**
     * initialize a trail with a specified name
     * @param name
     */
    public Trail(String name){
        this();
        setName(name);
    /* end constructor*/
    }

    /**
     * Add a specific WayPoint to the path if not already added
     * @param add - WayPoint to be added
     */
    public void addPoint(WayPoint add){
        end = add;
        if(!path.contains(add)){
            path.add(end);
        }//end if
    }//end addPoint()

    /**
     * add a point for the trail system
     * @param add - the latitude and longitude points to be added
     */
    public void addPoint(LatLng add){
        // Check if there is a point with the same coordinates
        for (WayPoint wayPoint: path){
            if (wayPoint.getPoint().equals(add)){
                return;
            }//end if
        }//end for

        WayPoint wayPoint = new WayPoint(add);
        end = wayPoint;
        path.add(end);
    /* end addPoint()*/
    }

    /**
     * Remove a specific WayPoint from the path
     * @param remove - WayPoint to remove
     * @return - true if successful
     */
    public boolean removePoint(WayPoint remove){
        if(path.contains(remove)){
            path.remove(remove);
            return true;
        }//end if
        return false;
    }//end removePoint()

    /**
     * Sets the new start location for the trail
     * @param add - the new start location
     */
    public void setStart(WayPoint add){
        start = add;
    }

    /**
     * Get the first point of the trail
     * @return - first location of the trail
     */
    public WayPoint getStart(){
        return start;
    }//end getStart()

    /**
     * Set a new end to the trail
     * @param end - new end
     */
    public void setEnd(WayPoint end){
        this.end = end;
    }//end setEnd()

    /**
     * Get the end of the trail
     * @return - last Waypoint of the trail
     */
    public WayPoint getEnd(){
        return end;
    }//end getEnd()

    /**
     * Get the path of the trail
     * @return - the WayPoints on the trail
     */
    public Collection<WayPoint> getPath(){
        return path;
    }//end getPath()

    /**
     * Set a new name for the trail
     * @param name - new name for the trail
     */
    public void setName(String name){
        this.name = name;
    }//end setName()

    /**
     * Get the name of the trail
     * @return - name of the trail
     */
    public String getName(){
        return name;
    }//end getName()

    /**
     * check the progress against the current trail
     * @param location - location to be compared with
     * @return - collection of WayPoints if progress is different
     *         - null if no changes occurred
     */
    public Collection<WayPoint> checkProgress(Location location){
        Log.v("checkProgress", "begin check progress");
        Log.v("checkProgress", name + path.toString());
        //check if the location accessed is in the trail
        for(WayPoint wayPoint: path){
            LatLng latLng = wayPoint.getPoint();
            double curLng = location.getLongitude();
            double curLat = location.getLatitude();
            boolean longitude,latitude;
            Log.v("checkProgress", String.valueOf(curLng));
            Log.v("checkProgress", String.valueOf(latLng.longitude));
            Log.v("checkProgress", String.valueOf(curLat));
            Log.v("checkProgress", String.valueOf(latLng.latitude));

            longitude = Double.compare(latLng.longitude, curLng) == 0;

            latitude = Double.compare(latLng.latitude, curLat) == 0;

            if(longitude & latitude) {
                return progress.addPoint(wayPoint);
            }//end if

        }//end for
        return null;
    /* end checkProgress */
    }

    public void addEvent(InputStream inputStream){
        end.addEvent(inputStream);
        events.add(end);

    }

    public boolean checkEvent(LatLng latLng){
        if(events.isEmpty())
            return false;
        LatLng top = events.peek().getPoint();
        if(measure(top, latLng) < 20){
            return true;
        }
        return true; //change back to false
    }

    public StoryEvent getEvent(){
        return events.pop().getEvent();
    }

    private double measure(LatLng first, LatLng compare){
        double R = 6378.137; // Radius of earth in KM
        double dLat = compare.latitude * Math.PI/180 - first.latitude * Math.PI/180;
        double dLon = compare.longitude * Math.PI/180 - first.longitude * Math.PI/180;
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                    Math.cos(first.latitude * Math.PI/180) * Math.cos(compare.latitude * Math.PI / 180) *
                            Math.sin(dLat/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c;
        return (d * 1000); //meters
    }
/* end Trail class */
}
