package trailsystem;

import java.util.Collection;

/**
 * Trail System which will contain different trails
 * to contain a whole trail system
 *
 * @author - Melchor Dominguez
 * @version - 1.0
 */
public class TrailSystem {

    /** Collection of trails associated with the trail system*/
    private Collection<Trail> trails;

    /** Name of the Trail System*/
    private String name;

    /**
     * Constructor for a trail system with no trails
     * and no name assigned
     */
    public TrailSystem(){
        trails = null;
        name = "No name yet assigned";
    }//end constructor

    /**
     * Constructor for a trail system with trail system
     * already defined; no name assigned
     */
    public TrailSystem(Collection<Trail> trails){
        this.trails = trails;
        name = "No name yet assigned";
    }//end TrailSystem

    /**
     * Constructor for a trail system that has an assigned name
     * @param name - name of the trail system
     */
    public TrailSystem(String name){
        trails = null;
        setName(name);
    }//end constructor

    /**
     *
     * @param trails
     * @param name
     */
    public TrailSystem(Collection<Trail> trails, String name){
        this.trails = trails;
        setName(name);
    }//end TrailSystem

    /**
     * Sets the name.
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
}
