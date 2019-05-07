package achievements;

import achievements.AchievementDescriptor;
/**
 * The class is the achievement descriptor for the speed achievement.
 * @author Tori Pruett
 * @version 1.0
 */
public class Speed extends AchievementDescriptor {
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
     * The speed of the achievement.
     */
    private int speed;

    /**
     * The constructor for the Speed Achievement.
     */
    public Speed(String name, int points,int speed, String description) {
        this.name = name;
        this.points = points;
        this.distance = distance;
        this.speed = speed;
        this.description = description;

    }

    public Speed(){

    }

    /**
     * The method to check to see if the achievement has been met.
     *
     * @param num The value to be checked.
     * @return true if met false if not met.
     */
    //@Override
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
     * Gets the distance of the achievement.
     *
     * @return The distance.
     */

    public int getSpeed() {
        return this.speed;
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




