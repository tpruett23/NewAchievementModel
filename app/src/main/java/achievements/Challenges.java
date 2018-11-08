package achievements;

import achievements.AchievementDescriptor;

/**
 * The class models the Challenges achievement.
 *
 * @author Tori Pruett
 * @version 1.0
 */

public class Challenges extends AchievementDescriptor {

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
     * The constructor for the Challenges achievement.
     */
    public Challenges() {
        name = "Challenge Achievement";
        points = 15;
        distance = 0;
        description = "This is how many challenges you have completed.";
    }

    /**
     * The method to check to see if the achievement has been met.
     * @param num The value to be checked.
     * @return true if met false if not met.
     */
    //@Override
    public static boolean checkCompleted(double num) {
        boolean check = false;
        if (num > 3.0) {
            check = true;

        }
        return check;
    }

    /**
     * Gets the name of the achievement.
     * @return The name of the achievement.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Gets the points of the achievement.
     * @return The points of the achievement.
     */
    @Override
    public int getPoints() {
        return this.points;
    }

    /**
     * Gets the distance of the achievement.
     * @return The distance.
     */
    @Override
    public double getDistance() {
        return this.distance;
    }

    /**
     * Gets the description of the achievement.
     * @return The description of the achievement.
     */
    @Override
    public String getDescription() {
        return this.description;
    }

}