package tests;

import com.google.android.gms.maps.model.LatLng;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import trailsystem.Trail;
import trailsystem.WayPoint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class TrailTest {

    /** Empty trail to compare in tests*/
    private static Trail emptyTrail;
    /** Compare trial to check in tests*/
    private static Trail compareTrail;

    /**
     * Set up before the tests
     */
    @Before
    public void setUp(){
        emptyTrail = new Trail();
        compareTrail = new Trail();

        WayPoint compare = new WayPoint(new LatLng(3.0, 3.0));
        WayPoint compare2 = new WayPoint(new LatLng(4.0, 4.0));
        compareTrail.addPoint(compare);
        compareTrail.setName("Trail1");
        compareTrail.setStart(compare);
        compareTrail.setEnd(compare2);
    }//end setUp

    /**
     * Test the addPoint method
     */
    @Test
    public void addPoint(){
        //set up WayPoints that will be added
        WayPoint add = new WayPoint(new LatLng(3.0, 3.0));
        WayPoint add2 = new WayPoint(new LatLng(5.0,5.0));

        //add way points for different possibilities
        emptyTrail.addPoint(add);
        compareTrail.addPoint(add);
        compareTrail.addPoint(add2);

        //get the values to compare
        Collection<WayPoint> trail1 = emptyTrail.getPath();
        Collection<WayPoint> trail2 = emptyTrail.getPath();

        //set up actual answers
        Collection<WayPoint> correct1 = new ArrayList<WayPoint>();
        correct1.add(new WayPoint (new LatLng(3.0, 3.0)));
        Collection<WayPoint> correct2 = new ArrayList<WayPoint>();
        correct2.add(new WayPoint(new LatLng(3.0, 3.0)));
        correct2.add(new WayPoint(new LatLng(4.0, 4.0)));
        correct2.add(new WayPoint(new LatLng(5.0, 5.0)));

        //run tests
        assertEquals(trail1, correct1);
        assertEquals(trail2, correct2);
        assertNotEquals(trail1, correct2);
        assertNotEquals(trail2, correct1);

    }//end addPoint()

    /**
     * Test the removePoint method
     */
    @Test
    public void removePoint(){
        //create WayPoint to test removal
        WayPoint remove = new WayPoint(new LatLng(3.0, 3.0));

        //test the removal of a WayPoint
        assertFalse(emptyTrail.removePoint(remove));
        assertTrue(compareTrail.removePoint(remove));
    }//end removePoint()


}
