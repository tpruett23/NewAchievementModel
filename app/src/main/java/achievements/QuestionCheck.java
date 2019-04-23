package achievements;

import screens.UserCompleted;

public class QuestionCheck implements CheckAchievements {
    /**
     * The class checks to see if a question achievement has been completed.
     * @param ach The achievement to check for and against.
     * @return true if achieved.
     */
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
