package achievements;

import trailsystem.Trail;

/**
 * The class checks the achievements and if met adds it to the appropriate arraylist.
 *
 * @author Tori Pruett
 * @version 1.0
 */
public class AchievementFactory {
    /**
     * The userinfo instance to access the completed arraylist.
     **/
    static UserInfo UI = new UserInfo();


    /**
     * The usercompleted instance to access values held in the class.
     **/
    static UserCompleted UC = new UserCompleted();

    /**
     * The boolean value to make sure they are only added once.
     **/
    boolean checked = false;



    /**
     * The constructor for an Achievement Factory.
     */
    public AchievementFactory() {

        if (!checked) {
            ///addCompleted();
        }else{

        }
    }

    /**
     * Calls the method in the abstract AchievementDescriptor class to check to see if the
     * achievement has been met.
     */
   public static void addCompleted(Achievements ach) {

        //this.checked = true;

        if(UI.getTotalDistance() >= ach.getDescriptorA().getDistance()){
            UC.getCompleted().add(ach);

        }
        if(UI.getSpeed() >= ach.getDescriptorA().getSpeed()){
            UC.getCompleted().add(ach);
        }
        if(UI.getSteps() >= ach.getDescriptorA().getSteps()){
            UC.getCompleted().add(ach);
        }


    }


}

