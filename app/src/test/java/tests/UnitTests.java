package tests;


import com.google.android.gms.maps.model.LatLng;

import org.junit.Test;

import achievements.AchievementDescriptor;
import achievements.Challenges;
import achievements.Distance;
import achievements.Speed;
import achievements.Steps;
import achievements.Time;
import achievements.Trails;
import trailsystem.Information;
import trailsystem.Question;
import trailsystem.WayPoint;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


public class UnitTests {
    LatLng point;
    WayPoint wp = new WayPoint(point);
    Information info = new Information();
    Trails trails = new Trails();
    Speed speed = new Speed();
    Challenges chall = new Challenges();
    Distance dis = new Distance();
    Steps step = new Steps();
    Time time = new Time();
    Question ques = new Question();

    @Test
    public void checkCompleted(){
        assertTrue(AchievementDescriptor.checkCompleted(4));
        assertTrue(AchievementDescriptor.checkCompleted(11));
        assertTrue(AchievementDescriptor.checkCompleted(4));
        assertTrue(AchievementDescriptor.checkCompleted(6));
        assertTrue(AchievementDescriptor.checkCompleted(400));
        assertTrue(AchievementDescriptor.checkCompleted(11));

}

    @Test
    public void information(){
        info.setName("name");
        assertEquals(info.getName(), "name");
    }

    @Test
    public void question(){

        ques.setQuestion("What is your name?");
        String question = ques.getQuestion();

        assertEquals(question,"What is your name?");
    }

    @Test
    public void wayPoint(){

    }






}
