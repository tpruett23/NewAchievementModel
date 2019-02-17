package achievements;

import screens.UserCompleted;

public class TrailNumCheck implements CheckAchievements {
    UserCompleted UC = new UserCompleted();
    @Override
    public void checkAchievement(Achievements ach) {
        if (UC.getTrails() > ach.getDescriptorA().getTrails()) {
            int trails = ach.getDescriptorA().getSpeed();
            if (!AchievementFactory.achievements.contains(ach)) {

               AchievementFactory.achievements.add(ach);
            }
        }

    }
}
