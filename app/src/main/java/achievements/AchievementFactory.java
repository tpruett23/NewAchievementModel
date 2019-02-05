package achievements;

import android.util.Log;

import java.util.ArrayList;

import screens.UserCompleted;
import trailsystem.Trail;

/**
 * The class checks the achievements and if met adds it to the appropriate arraylist.
 *
 * @author Tori Pruett
 * @version 1.0
 */
public class AchievementFactory {
    UserCompleted UC = new UserCompleted();
    /**
     * The userinfo instance to access the completed arraylist.
     **/
    UserInfo UI = new UserInfo();
    /**
     * The boolean value to make sure they are only added once.
     **/
    boolean checked = false;
    /**
     * Arraylist to hold all the users completed achievements.
     */
    static ArrayList<Achievements> achievements = new ArrayList<>();

    int steps;

    /**
     * The constructor for an Achievement Factory.
     */
    public AchievementFactory() {


    }
    public void checkStepsAchievement(Achievements ach) {
        if (UI.getSteps() > ach.getDescriptorA().getSteps()) {
            steps = ach.getDescriptorA().getSteps();
            if (!this.achievements.contains(ach)) {
                this.achievements.add(ach);
            }

        }
    }
     public void checkDistanceAchievement(Achievements ach){
            if (UC.getDistanceUser() > ach.getDescriptorA().getDistance()) {
                if (!this.achievements.contains(ach)) {
                    this.achievements.add(ach);
                }
            }
        }

     public void checkSpeedAchievement(Achievements ach){
            if (UI.getSpeed() > ach.getDescriptorA().getSpeed()) {
                int speed = ach.getDescriptorA().getSpeed();
                if (!this.achievements.contains(ach)) {

                    this.achievements.add(ach);
                }
            }
        }

    public void checkTrailAchievement(Achievements ach){
        if (UC.getTrails() > ach.getDescriptorA().getTrails()) {
            int trails = ach.getDescriptorA().getSpeed();
            if (!this.achievements.contains(ach)) {

                this.achievements.add(ach);
            }
        }
    }


    public void checkTimeAchievement(Achievements ach){
        if (UI.getTimePlayed() > ach.getDescriptorA().getTime()) {
            if (!this.achievements.contains(ach)) {

                this.achievements.add(ach);
            }
        }
    }




     public ArrayList<Achievements> getAchievements () {
            return this.achievements;
        }


    }






