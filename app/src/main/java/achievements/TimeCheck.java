package achievements;

import android.content.Intent;
/**
 * The class checks to see if the time achievement has been met.
 * @author Tori Pruett
 * @version 1.0
 */
public class TimeCheck implements CheckAchievements {
    UserInfo UI = new UserInfo();

    /**
     * The method checks to see if the time achievement has been completed.
     * @param ach The achievement to check the values against.
     * @return true if completed, false if not.
     */
    @Override
    public boolean checkAchievement(Achievements ach) {
        boolean check = false;
        if (UI.getTimePlayed() > ach.getDescriptorA().getTime()) {

                check= true;

        }
        return check;

    }
}
