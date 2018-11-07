package trailsystem;

/**
 * Class containing information that will be displayed at
 * a point of interest
 * @author - Melchor Dominguez
 * @version - 1.0
 */
public class Information extends PointOfInterest {

    /** Information to be displayed */
    private String info;


    /**
     * Constructor that will automatically set the information
     */
    public Information(){
        setInfo("Information not set");
    }//end constructor

    /**
     * Constructor with a pre-chosen message
     * @param info - information message
     */
    public Information(String info){
        setInfo(info);
    }//end constructor


    /**
     * Set a new value for the information
     * @param info - new information
     */
    public void setInfo(String info) {
        this.info = info;
    }//end setInfo()

    /**
     * Returns the information to be displayed
     * @return - information
     */
    public String getInfo(){
        return info;
    }//end getInfo()
}
