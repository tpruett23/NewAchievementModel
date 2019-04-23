package achievements;

import android.content.Context;
import android.content.Intent;

import screens.UserCompleted;

/**
 * Class for checking for the distance achievement.
 * @author Tori Pruett
 * @version 1.0
 */

public class DistanceCheck implements CheckAchievements {


    /**
     * Method that compares values to see if the achievement has been met.
     * @param ach The achievement to check for and against.
     * @return True if achieved.
     */
    @Override
    public boolean checkAchievement(Achievements ach) {
        boolean check = false;

        if (UserCompleted.distanceUser > ach.getDescriptorA().getDistance()) {
            if(!(AchievementFactory.achievements.contains(ach))) {

                check = true;
            }

        }
        return check;

    }
}
