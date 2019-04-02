package achievements;


import android.content.Intent;

public class StepCheck implements CheckAchievements{
UserInfo userInfo = new UserInfo();


    @Override
    public boolean checkAchievement(Achievements ach) {
        boolean check = false;

            if (userInfo.getSteps() > ach.getDescriptorA().getSteps()) {
                if(!(AchievementFactory.achievements.contains(ach))) {
                    check = true;
                }

            }
            return check;

        }

    }

