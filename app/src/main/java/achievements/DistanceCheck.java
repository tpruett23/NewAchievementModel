package achievements;

import screens.UserCompleted;

public class DistanceCheck implements CheckAchievements {
    UserCompleted UC = new UserCompleted();


    @Override
    public void checkAchievement(Achievements ach) {
        if (UC.getDistanceUser() > ach.getDescriptorA().getDistance()) {
            if (!AchievementFactory.achievements.contains(ach)) {
               AchievementFactory.achievements.add(ach);
            }
        }

    }
}
