package achievements;

import android.content.Intent;

public class TimeCheck implements CheckAchievements {
    UserInfo UI = new UserInfo();
    //AchievementFactory af = new AchievementFactory();

    @Override
    public boolean checkAchievement(Achievements ach) {
        boolean check = false;
        if (UI.getTimePlayed() > ach.getDescriptorA().getTime()) {

                check= true;

               //AchievementFactory.achievements.add(ach);

        }
        return check;

    }
}
