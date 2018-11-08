package achievements;

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
     * The boolen value to make sure they are only added once.
     **/
    boolean checked = false;

    /**
     * The Steps achievement to be added to the completed arraylist if met.
     **/
    static Steps steps = new Steps();

    /**
     * The Trails achievement to be added to the completed arraylist if met.
     **/
    static Trails trails = new Trails();

    /**
     * The Question achievement to be added to the completed arraylist if met.
     **/
    static Question question = new Question();

    /**
     * The Challenges achievement to be added to the completed arraylist if met.
     **/
    static Challenges challenges = new Challenges();

    /**
     * The Distance achievement to be added to the completed arraylist if met.
     **/
    static Distance distance = new Distance();

    /**
     * The Time achievement to be added to the completed arraylist if met.
     **/
    static Time time = new Time();

    /**
     * The Speed achievement to be added to the completed arraylist if met.
     **/
    static Speed speed = new Speed();


    /**
     * The constructor for an Achievement Factory.
     */
    public AchievementFactory() {
        if (checked == false) {
            addCompleted();
        }
    }

    /**
     * Calls the method in the abstract AchievementDescriptor class to check to see if the
     * achievement has been met.
     */
    public void addCompleted() {
        boolean see = trails.checkCompleted(UC.getTrails());
        if (trails.checkCompleted(UC.getTrails())) {
            UI.completed.add(trails);
        }
        if (speed.checkCompleted(UserInfo.getSpeed())) {
            UI.completed.add(speed);
        }
        if (steps.checkCompleted(UserInfo.getSteps())) {
            UI.completed.add(steps);
        }
        if (question.checkCompleted(UC.getQuestionsCorrect())) {
            UI.completed.add(question);
        }

        if (distance.checkCompleted(UserInfo.getTotalDistance())) {
            UI.completed.add(distance);
        }
        if (challenges.checkCompleted(UC.getChallenges())) {
            UI.completed.add(challenges);
        }
        if (time.checkCompleted(UserInfo.getTimePlayed())) {
            UI.completed.add(time);
        }
        checked = true;

    }


}

