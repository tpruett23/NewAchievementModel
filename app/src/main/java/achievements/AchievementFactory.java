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
    UserInfo UI = new UserInfo();


    /**
     * The usercompleted instance to access values held in the class.
     **/
    UserCompleted UC = new UserCompleted();

    /**
     * The boolean value to make sure they are only added once.
     **/
    boolean checked = false;



    /**
     * The constructor for an Achievement Factory.
     */
    public AchievementFactory() {

        if (!checked) {
            //addCompleted();
        }else{

        }
    }

    /**
     * Calls the method in the abstract AchievementDescriptor class to check to see if the
     * achievement has been met.
     */
   public void addCompleted(Achievements ach) {

        this.checked = true;

        if(Steps.checkCompleted(UserInfo.getSteps(),ach.getChackValue())){
            UC.getCompleted().add(ach);

        }




    }


}

