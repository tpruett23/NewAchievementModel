package achievements;

import android.content.Intent;
/**
 * Checks if the speed achievement has been completed.
 * @author Tori Pruett
 * @version 1.0
 */
public class SpeedCheck implements CheckAchievements {
    UserInfo UI = new UserInfo();
/**
 * Checks to see if the achievement has been completed.
 * @param ach The achievement instance to check the values against.
 * @return true if completed, false if not.
 */
    @Override
    public boolean checkAchievement(Achievements ach) {
        boolean check = false;

            if (UI.getSpeed() > ach.getDescriptorA().getSpeed()) {
                    check= true;

            }
            return check;
        }

}
