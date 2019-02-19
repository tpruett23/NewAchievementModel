package screens;

import android.location.Location;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import achievements.Achievements;

/**
 * The class holds the information for all of the tasks the user has completed.
 */

public class UserCompleted {

    /**
     * The Listview that displays the completed achievements.
     */
    private ListView lv;

    /**
     * The number of trails that have been completed by the user.
     */
    private int trails = 5;

    /**
     * The number of questions that have answered correctly by the user.
     */
    private int questionsCorrect;

    /**
     * The number of questions that have been answered incorrectly.
     */
    private int questionsIncorrect;

    /**
     * The number of achievements won by the user.
     */
    private int achievementsWon;

    /**
     * The number of challenges met by the user.
     */
    private int challenges;

    /**
     * Distance the user has traveled.
     */

    private double distanceUser = 0;



    /**
     * The arraylist to hold the completed achievements for the user.
     */
     ArrayList<Location> map = new ArrayList<>();

    private Location prevLocation;
    private Location location;



    public UserCompleted(){

    }



    public void updateDistance(Double dis) {
        this.distanceUser += dis;

    }




    /**
     * Gets the number of trails completed.
     *
     * @return The number of trails.
     */
    public int getTrails() {
        return this.trails;
    }

    /**
     * Gets the number of challenges completed.
     *
     * @return Number of challenges.
     */
    public int getChallenges() {
        return challenges;
    }

    /**
     * Gets the number of questions answered correctly.
     *
     * @return The questions answered correctly.
     */
    public int getQuestionsCorrect() {
        return questionsCorrect;
    }

    /**
     * Gets the number of questions answered incorrectly.
     *
     * @return The number of questions answered incorrectly.
     */
    public int getQuestionsIncorrect() {
        return questionsIncorrect;
    }

    /**
     * Gets the amount of achievements won.
     *
     * @return The amount of achievements won.
     */
    public int getAchievementsWon() {
        return achievementsWon;
    }

    /**
     * Gets the total distance the user has completed.
     * @return The total distance the user has traveled.
     */
    public double getDistanceUser(){
        return this.distanceUser;
    }

    /**
     * Gets the arraylist of locations the user has been to.
     * @return Gets the arraylist of locations the user has been to.
     */
    public ArrayList<Location> getMap() {
        return map;
    }

    public void setLocation(Location loc){
        this.location = loc;
    }
}






