package achievements;

import android.content.Intent;

public class SpeedCheck implements CheckAchievements {
    UserInfo UI = new UserInfo();

    @Override
    public boolean checkAchievement(Achievements ach) {
        boolean check = false;

            if (UI.getSpeed() > ach.getDescriptorA().getSpeed()) {
                if (!AchievementFactory.achievements.contains(ach)) {
                    check= true;
                 //AchievementFactory.achievements.add(ach);
                }
            }
            return check;
        }

}
