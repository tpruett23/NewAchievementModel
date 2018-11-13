package achievements;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toripruett.newachievementmodel.R;

import java.util.ArrayList;

/**
 * The class models the Arraylist to hold all of the possible achievements.
 *
 * @author Tori Pruett
 * @version 1.0
 */
public class Achievements {

    /**
     * The arraylist to hold all of the achievements.
     **/
    static ArrayList<AchievementDescriptor> allAchievements;

    /**
     * Name of the achievement read in by xml.
     */
    private static String name;
    /**
     * Description of the achievement read in by xml.
     */
    private static String description;
    /**
     * Points of the achievement being read in by XML.
     */
    private static int points;

    /**
     * The value to check to see if the achievement has been completed.
     */
    private static int checkValue;

    /**
     * The step achievement to be added to the List.
     **/
    AchievementDescriptor steps = new Steps();

    /**
     * The trail achievement to be added to the List.
     **/
    AchievementDescriptor trails = new Trails();

    /**
     * The question achievement to be added to the List.
     **/
    AchievementDescriptor question = new Question();

    /**
     * The challenge achievement to be added to the List.
     **/
    AchievementDescriptor challenges = new Challenges();

    /**
     * The distance achievement to be added to the List.
     **/
    AchievementDescriptor distance = new Distance();

    /**
     * The time achievement to be added to the List.
     **/
    AchievementDescriptor time = new Time();

    /**
     * The speed achievement to be added to the List.
     **/
    AchievementDescriptor speed = new Speed();



    /**
     * The boolean value so that the achievements are only added to the list once.
     **/
    boolean see = false;

    /**
     * Constructor for the Achievements class.
     */
    public Achievements() {
        allAchievements = new ArrayList<>();
        if (!see) {
            add();
        }


    }


    /**
     * Adds all of the achievements to the arraylist to be displayed.
     */
    public void add() {

        allAchievements.add(steps);
        allAchievements.add(trails);
        allAchievements.add(question);
        allAchievements.add(challenges);
        allAchievements.add(distance);
        allAchievements.add(time);
        allAchievements.add(speed);
        see = true;
    }

    /**
     * The getter method to get the achievements arraylist.
     *
     * @return The arraylist of achievements.
     */
    public static ArrayList<AchievementDescriptor> getAllAchievements() {
        return allAchievements;
    }


    public static String getName(){
        return name;
    }

    public static String getDescription() {
        return description;
    }

    public static int getPoints() {
        return points;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public int getChackValue(){
        return this.checkValue;
    }

    public void setCheckValue(int checkValue){
        this.checkValue = checkValue;
    }
}
