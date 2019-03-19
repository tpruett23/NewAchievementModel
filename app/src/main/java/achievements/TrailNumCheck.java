package achievements;

import android.content.Intent;

import screens.UserCompleted;

public class TrailNumCheck implements CheckAchievements {
    UserCompleted UC = new UserCompleted();
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
