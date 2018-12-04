package trailsystem;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Class to contain the progress for a specific trail
 * @author - Melchor Dominguez
 * @version - 1.0
 */
public class TrailProgress {

    /** Collection of WayPoint locations that have been reached*/
    private Collection<WayPoint> progress;

    /**
     * Constructor which will begin with no progress made
     */
    public TrailProgress(){
        progress = new ArrayList<WayPoint>();
    }//end Trail Progress()

    /**
     * Add a WayPoint to the progress
     */
    public Collection<WayPoint> addPoint(WayPoint point){
        if(!progress.contains(point)) {
            progress.add(point);
        }//end if

        return progress;
    /* end addPoint */
    }

}//end TrailProgress
