package achievements;

import achievements.AchievementDescriptor;

public class Steps extends AchievementDescriptor {
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
     * The constructor for the Steps achievement.
     */
    public Steps() {
        name = "Step Achievement";
        points = 20;
        distance = 0;
        description = "This is for the number of steps you have taken.";

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
        if (num > 300) {
            check = true;
        }
        return check;
    }

}