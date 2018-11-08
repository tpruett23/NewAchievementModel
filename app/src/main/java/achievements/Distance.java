package achievements;

import achievements.AchievementDescriptor;

public class Distance extends AchievementDescriptor {
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
     * The constructor for the Distance achievement.
     */
    public Distance() {
        name = "Distance Achievement";
        points = 10;
        distance = 3;
        description = "This is the total distance achievement.";
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
        if (num > 5) {

            check = true;
        }
        return check;
    }

}