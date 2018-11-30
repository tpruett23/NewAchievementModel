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
    private ArrayList<AchievementDescriptor> allAchievements = new ArrayList<>();

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

    AchievementDescriptor a;





    /**
     * Constructor for the Achievements class.
     */
    public Achievements() {
        //allAchievements = new ArrayList<>();


    }

    public Achievements(AchievementDescriptor a, AchievementDescriptor b){

    }


    /**
     * The getter method to get the achievements arraylist.
     *
     * @return The arraylist of achievements.
     */
    public ArrayList<AchievementDescriptor> getAllAchievements() {
        return this.allAchievements;
    }


    public  String getName(){
        return this.name;
    }

    public String getDescription() {
        return description;
    }

    public int getPoints() {
        return points;
    }

    public void setName(String name1){
        name = name1;
    }

    public void setDescription(String description1){
        description = description1;
    }

    public void setPoints(int points1){
        points = points1;
    }


    public void setDescriptors(AchievementDescriptor a){
        this.a = a;
    }
    public void setDescriptor(AchievementDescriptor a){
        this.a = a;

    }

    public AchievementDescriptor getDescriptorA(){
        return this.a;

    }



}
