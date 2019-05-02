package achievements;
import java.util.ArrayList;

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

    /**
     * Gets the list of completed achievements.
     * @return the users completed achievements.
     */
    public ArrayList<Achievements> getAchievements(){
    return achievements;
}

    }






