import org.junit.Test;

import achievements.Challenges;
import achievements.Distance;
import achievements.Speed;
import achievements.Steps;
import achievements.Time;
import achievements.Trails;

import static org.junit.Assert.assertTrue;

public class UnitTests {
    @Test
    public void checkCompleted(){
        assertTrue(Trails.checkCompleted(4));
        assertTrue(Speed.checkCompleted(11));
        assertTrue(Challenges.checkCompleted(4));
        assertTrue(Distance.checkCompleted(6));
        assertTrue(Steps.checkCompleted(400));
        assertTrue(Time.checkCompleted(11));

}

    @Test
    public void wayPoint(){

    }

}
