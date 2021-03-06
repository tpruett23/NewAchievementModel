package achievements;

import achievements.AchievementDescriptor;

/**
 * The Steps Achievement Descriptor.
 * @author Tori Pruett
 * @version 2.0
 */

public class Steps extends AchievementDescriptor {
    /**
     * The name of the achievement
     **/
    private String name;

    /**
     * How many points for the achievement.
     **/
    private int points;

    /**
     * The description of the achievement.
     **/
    private String description;

    /**
     * The distance associated with the achievement.
     **/
    private double distance;


    /**
     * The steps taken to complete this achievement.
     */
    private int steps;

    /**
     * The constructor for the Steps achievement.
     */
    public Steps(String name, int points,String description, int steps) {
        this.name = name;
        this.points = points;
        this.distance = distance;
        this.description = description;
        this.steps = steps;

    }

    public Steps(){

    }

    /**
     * The method to check to see if the achievement has been met.
     *
     * @param num The value to be checked.
     * @return true if met false if not met.
     */
    public static boolean checkCompleted(double num, double numCheck) {
        boolean check = false;
        if (num > numCheck) {
            check = true;
        }
        return check;
    }

    /**
     * Gets the name of the achievement.
     *
     * @return The name of the achievement.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Gets the points of the achievement.
     *
     * @return The points of the achievement.
     */

    public int getSteps() {
        return this.steps;
    }

    /**
     * Gets the points of the achievement.
     *
     * @return The points of the achievement.
     */
    @Override
    public int getPoints() {
        return this.points;
    }

    /**
     * Sets the points of the achievement.
     *
     * @return The points of the achievement.
     */
    public void setPoints(int points){
        this.points = points;
    }

    /**
     * Gets the distance of the achievement.
     *
     * @return The distance.
     */
    @Override
    public double getDistance() {
        return this.distance;
    }

    /**
     * Gets the description of the achievement.
     *
     * @return The description of the achievement.
     */
    @Override
    public String getDescription() {
        return this.description;
    }


}


