package trailsystem;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Trail class which will model a specific trail
 * @author - Melchor Dominguez
 * @version - 1.0
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

    public Trail(){
        path = new ArrayList<>();
        name = "";
        start = null;
        end = null;
        progress = new TrailProgress();
    }//end Trail

    /**
     * Add a specific WayPoint to the path if not already added
     * @param add - WayPoint to be added
     */
    public void addPoint(WayPoint add){
        if(!path.contains(add)){
            path.add(add);
        }//end if
    }//end addPoint()

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
     * @param - new name for the trail
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
}
