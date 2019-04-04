package achievements;


import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
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
    static ArrayList<AchievementDescriptor> allAchievements = new ArrayList<>();

    /**
     * Name of the achievement read in by xml.
     */
    private String name;

    /**
     * Description of the achievement read in by xml.
     */
     private String description;

    /**
     * Points of the achievement being read in by XML.
     */
     private int points;

    /**
     * Achievement descriptor contained in the achievement.
     */
    AchievementDescriptor a;


    /**
     * Constructor for the Achievements class.
     */
    public Achievements() {

    }




    /**
     * The getter method to get the achievements arraylist.
     *
     * @return The arraylist of achievements.
     */
    public ArrayList<AchievementDescriptor> getAllAchievements() {
        return this.allAchievements;
    }

    /**
     * Gets the name of the achievement.
     * @return The name.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets the description of the achievement.
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the points of the achievement.
     * @return The points.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Sets the name of the achievement.
     * @param name1
     */
    public void setName(String name1){
        name = name1;
    }

    /**
     * Sets the description of the achievement.
     * @param description1
     */
    public void setDescription(String description1){
        description = description1;
    }

    /**
     * Sets the points of the achievement.
     * @param points1
     */
    public void setPoints(int points1){
        points = points1;
    }

    /**
     * Sets the description of the achievement.
     * @param a1
     */
    public void setDescriptor(AchievementDescriptor a1){
        this.a = a1;
    }

    /**
     * Gets the descriptor of the achievement.
     * @return
     */
    public AchievementDescriptor getDescriptorA(){
        return this.a;
    }


}
