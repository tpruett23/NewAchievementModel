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
     * The amount of challenges completed.
     */

    int challengeNum;

    /**
     * The constructor for the Challenges achievement.
     */
    public Challenges(String name, int points, int challengeNum,String description) {
        this.name = name;
        this.points = points;
        this.distance = distance;
        this.description = description;
        this.challengeNum = challengeNum;
    }

    public Challenges(){

    }

    /**
     * The method to check to see if the achievement has been met.
     *
     * @param num The value to be checked.
     * @return true if met false if not met.
     */
   // @Override
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
     * Gets the description of the achievement.
     *
     * @return The description of the achievement.
     */
    @Override
    public String getDescription() {
        return this.description;
    }


}



