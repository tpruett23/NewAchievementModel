package achievements;


import android.content.Intent;

public class StepCheck implements CheckAchievements{
    UserInfo UI = new UserInfo();
    //AchievementFactory af = new AchievementFactory();


    @Override
    public boolean checkAchievement(Achievements ach) {
        boolean check = false;

            if (UI.getSteps() > ach.getDescriptorA().getSteps()) {
                if (!AchievementFactory.achievements.contains(ach)) {
                    check = true;
                   AchievementFactory.achievements.add(ach);
                }

            }
            return check;

        }

    }

