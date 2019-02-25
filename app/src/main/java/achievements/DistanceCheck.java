package achievements;

import android.content.Context;
import android.content.Intent;

import screens.UserCompleted;

public class DistanceCheck implements CheckAchievements {
    UserCompleted UC = new UserCompleted();



    @Override
    public boolean checkAchievement(Achievements ach) {
        boolean check = false;

        if (UC.getDistanceUser() > ach.getDescriptorA().getDistance()) {
            if (!AchievementFactory.achievements.contains(ach)) {
                check = true;

            }
        }
        return check;

    }
}
