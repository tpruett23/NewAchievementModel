package achievements;

public class SpeedCheck implements CheckAchievements {
    UserInfo UI = new UserInfo();

    @Override
    public void checkAchievement(Achievements ach) {

            if (UI.getSpeed() > ach.getDescriptorA().getSpeed()) {
                if (!AchievementFactory.achievements.contains(ach)) {

                 AchievementFactory.achievements.add(ach);
                }
            }
        }

}
