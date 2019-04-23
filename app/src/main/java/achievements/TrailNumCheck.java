package achievements;

import android.content.Intent;

import screens.UserCompleted;

/**
 * Checks to see if the user has completed enough trails for this achievement.
 * @author Tori Pruett
 * @version 1.0
 */
public class TrailNumCheck implements CheckAchievements {
    UserCompleted UC = new UserCompleted();

    /**
     * Checks to see if the trail achievement has been met.
     * @param ach The achievement to check for and against.
     * @return
     */
    @Override
    public boolean checkAchievement(Achievements ach) {

        boolean check = false;
        if (UC.getTrails() > ach.getDescriptorA().getTrails()) {
            int trails = ach.getDescriptorA().getSpeed();
                check = true;
               //AchievementFactory.achievements.add(ach);

        }
        return check;

    }
}
