package achievements;

public class TimeCheck implements CheckAchievements {
    UserInfo UI = new UserInfo();
    //AchievementFactory af = new AchievementFactory();

    @Override
    public void checkAchievement(Achievements ach) {
        if (UI.getTimePlayed() > ach.getDescriptorA().getTime()) {
            if (!AchievementFactory.achievements.contains(ach)) {

               AchievementFactory.achievements.add(ach);
            }
        }

    }
}
