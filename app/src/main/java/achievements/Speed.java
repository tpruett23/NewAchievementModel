package achievements;

import achievements.AchievementDescriptor;

public class Speed extends AchievementDescriptor {
    /**
     * The name of the achievement
     **/
    String name;

    /**
     * How many points for the achievement.
     **/
    int points;

    /**
     * The description of the achievement.
     **/
    String description;

    /**
     * The distance associated with the achievement.
     **/
    double distance;

    /**
     * The constructor for the Speed Achievement.
     */
    public Speed() {
        name = "Speed Achievement";
        points = 15;
        distance = 0;
        description = "This is how long it took to complete the course.";

    }

    /**
     * The method to check to see if the achievement has been met.
     *
     * @param num The value to be checked.
     * @return true if met false if not met.
     */
    @Override
    public boolean checkCompleted(double num) {
        boolean check = false;
        if (num > 10) {
            check = true;
        }
        return check;
    }

}