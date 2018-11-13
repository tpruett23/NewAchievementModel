package trailsystem;

/**
 * Point of interest to model an event at a specific location
 * @author - Melchor Dominguez
 * @version - 1.0
 */
public abstract class PointOfInterest {

    /** Name of the event that will occur **/
    private String name;

    /**
     * Sets a new name for the point of interest
     * @param name - new name
     */
    public void setName(String name) {
        this.name = name;
    }//end setName()

    /**
     * Get the name of the point of interest
     * @return - the name
     */
    public String getName(){
        return name;
    }//end getName()

}//end PointOfInterest class
