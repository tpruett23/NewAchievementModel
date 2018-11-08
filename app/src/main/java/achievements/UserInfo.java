package achievements;

import java.util.ArrayList;

import achievements.AchievementDescriptor;

/**
 * The class represents the users information.
 *
 * @author Tori Pruett
 */
public class UserInfo {
    /**
     * The total amount of points the user has won.
     */
    public int totalPoints;

    /**
     * The total distance the user has traveled.
     */
    public static double totalDistance;

    /**
     * How long the user has been playing.
     */
    public static double timePlayed;

    /**
     * How fast the user is traveling.
     */
    public static int speed;

    /**
     * The number of steps the user has taken.
     */
    public static int steps;

    /**
     * The arraylist to hold the completed achievements for the user.
     */
    static ArrayList<AchievementDescriptor> completed = new ArrayList<>();


    /**
     * The constructor for UserInfo.
     */
    public void UserInfo() {

        totalDistance = 6;
        timePlayed = 7.0;
        speed = 0;
        steps = 200;
    }

    /**
     * Gets the total number of points for the user.
     *
     * @return The total number of point.
     */
    public int getTotalPoints() {
        return this.totalPoints;
    }

    /**
     * Gets the total distance the user has traveled.
     *
     * @return Total distance the user has traveled.
     */

    public static double getTotalDistance() {
        return totalDistance;
    }

    /**
     * Gets the total amount of time the user has played.
     *
     * @return total amount of time the user has played.
     */
    public static double getTimePlayed() {
        return timePlayed;
    }

    /**
     * Gets how fast the user is traveling.
     *
     * @return How fast the user is traveling.
     */
    public static int getSpeed() {
        return speed;
    }

    /**
     * The number of steps the user has taken.
     *
     * @return number of steps the user has taken.
     */
    public static int getSteps() {
        return steps;
    }


    /**
     * Getter method for the completed arraylist.
     *
     * @return The completed arraylist.
     */
    public static ArrayList<AchievementDescriptor> getCompleted() {
        return completed;
    }
}

