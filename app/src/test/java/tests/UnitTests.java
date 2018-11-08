package tests;

import org.junit.Test;

import achievements.Challenges;
import achievements.Distance;
import achievements.Speed;
import achievements.Steps;
import achievements.Time;
import achievements.Trails;
import trailsystem.Information;
import trailsystem.Question;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnitTests {
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
        assertTrue(trails.checkCompleted(4));
        assertTrue(speed.checkCompleted(11));
        assertTrue(chall.checkCompleted(4));
        assertTrue(dis.checkCompleted(6));
        assertTrue(step.checkCompleted(400));
        assertTrue(time.checkCompleted(11));

}

    @Test
    public void information(){
        info.setName("name");
        assertEquals(info.getName(), "name");
    }

    @Test
    public void question(){
        ques.addChoice();




        ques.setQuestion("What is your name?");
        String question = ques.getQuestion();

        assertEquals(question,"What is your name?");
    }





}
