package achievements;


import android.content.Intent;

public class StepCheck implements CheckAchievements{



    @Override
    public boolean checkAchievement(Achievements ach) {
        boolean check = false;

            if (UserInfo.steps > ach.getDescriptorA().getSteps()) {
                if(!(AchievementFactory.achievements.contains(ach))) {
                    check = true;
                }

            }
            return check;

        }

    }

