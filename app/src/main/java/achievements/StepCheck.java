package achievements;


public class StepCheck implements CheckAchievements{
    UserInfo UI = new UserInfo();
    //AchievementFactory af = new AchievementFactory();


    @Override
    public void checkAchievement(Achievements ach) {

            if (UI.getSteps() > ach.getDescriptorA().getSteps()) {
                if (!AchievementFactory.achievements.contains(ach)) {
                   AchievementFactory.achievements.add(ach);
                }

            }
        }

    }

