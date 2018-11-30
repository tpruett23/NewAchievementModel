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
     * Instance of UserCompleted class to access values.
     */
    //UserCompleted UC = new UserCompleted();

    /**
     * The total amount of points the user has won.
     */
    public int totalPoints;

    /**
     * The total distance the user has traveled.
     */
    public  double totalDistance;

    /**
     * How long the user has been playing.
     */
    public  double timePlayed;

    /**
     * How fast the user is traveling.
     */
    public  int speed;

    /**
     * The number of steps the user has taken.
     */
    public  int steps;

    /**
     * The arraylist to hold all of the completed achievements.
     */
    //ArrayList<Achievements> completed = UC.getCompleted();


    /**
     * The constructor for UserInfo.
     */
    public void UserInfo() {

        totalDistance = 6;
        timePlayed = 7.0;
        speed = 9;
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

    public  double getTotalDistance() {
        return this.totalDistance;
    }

    /**
     * Gets the total amount of time the user has played.
     *
     * @return total amount of time the user has played.
     */
    public  double getTimePlayed() {
        return this.timePlayed;
    }

    /**
     * Gets how fast the user is traveling.
     *
     * @return How fast the user is traveling.
     */
    public  int getSpeed() {
        return this.speed;
    }

    /**
     * The number of steps the user has taken.
     *
     * @return number of steps the user has taken.
     */
    public int getSteps() {
        return this.steps;
    }



}

