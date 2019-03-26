package achievements;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import achievements.Achievements;
import screens.UserCompleted;

/**
 * @author Tori Pruett
 * Interface that is inherited by some classes that check for certain achievements.
 */
public interface CheckAchievements {
    Context context = null;
/**
 * Method to check to see if that achievement has been met.
 */
    boolean checkAchievement(Achievements ach);

}



