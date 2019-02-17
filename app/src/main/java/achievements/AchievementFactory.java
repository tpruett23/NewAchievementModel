package achievements;

import android.util.Log;

import java.util.ArrayList;

import screens.UserCompleted;
import trailsystem.Trail;

/**
 * The class checks the achievements and if met adds it to the appropriate arraylist.
 *
 * @author Tori Pruett
 * @version 1.0
 */
public class AchievementFactory {

    /**
     * The boolean value to make sure they are only added once.
     **/
    boolean checked = false;
    /**
     * Arraylist to hold all the users completed achievements.
     */
     static ArrayList<Achievements> achievements = new ArrayList<>() ;

    public ArrayList<Achievements> getAchievements(){
    return this.achievements;
}



    }






