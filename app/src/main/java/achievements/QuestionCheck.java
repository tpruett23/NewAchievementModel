package achievements;

import screens.UserCompleted;

public class QuestionCheck implements CheckAchievements {
    @Override
    public boolean checkAchievement(Achievements ach) {
        boolean check = false;

        if (UserCompleted.questions > ach.getDescriptorA().getQuestions()) {
            if(!(AchievementFactory.achievements.contains(ach))) {

                check = true;
            }

        }
        return check;

    }
}
