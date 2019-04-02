package screens;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Location;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import achievements.Achievements;

import static android.content.Context.MODE_PRIVATE;
import static android.provider.SyncStateContract.Columns.DATA;

/**
 * The class holds the information for all of the tasks the user has completed.
 */

public class UserCompleted{
    Context context;

    /**
     * The Listview that displays the completed achievements.
     */
    private ListView lv;

    /**
     * The number of trails that have been completed by the user.
     */
    private int trails;

    /**
     * The number of achievements won by the user.
     */
    private int achievementsWon;
    /**
     * The number of questions answered correctly by the user.
     */
    public static int questions;
    /**
     * Distance the user has traveled.
     */
    public static double distanceUser;
    /**
     * The arraylist to hold the completed achievements for the user.
     */
     ArrayList<Location> map = new ArrayList<>();




    public UserCompleted(Context context){

        this.context = context;

    }

    public UserCompleted(){

    }


    /**
     * Updates the users distance after they have been traveling.
     */
    public void updateDistance(double distance) {
        /*TrailMap tm = new TrailMap();*/
        this.distanceUser +=  distance;


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
    public int getQuestions() {
        return this.questions;
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


}






