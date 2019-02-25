package achievements;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import achievements.AchievementDescriptor;
import trailsystem.WayPoint;

/**
 * The class represents the users information.
 *
 * @author Tori Pruett
 * @version 2.0
 */
public class UserInfo {

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
    public  double timePlayed = 7;

    /**
     * How fast the user is traveling.
     */
    public  int speed = 10;

    /**
     * The number of steps the user has taken.
     */
    public  int steps = 400;

    int stepsDectected = 0;



    /**
     * The constructor for UserInfo.
     */
    public void UserInfo() {


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
    public double getTimePlayed() {
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

    /**
     * The number of steps the user has taken.
     *
     * @return number of steps the user has taken.
     */
    public void setSteps(int stepz) {
         this.steps = stepz;
    }

    public int getStepsDectected() {
        return stepsDectected;
    }

    public void setStepsDectected(int stepsDectected) {
        this.stepsDectected = stepsDectected;
    }


}

