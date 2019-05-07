package achievements;
/**
 * @author Tori Pruett
 * @version 1.0
 */
public abstract class AchievementDescriptor {
    /**
     * The name of the Achievement.
     **/
    private String name;
    /**
     * How many points the achievement is worth.
     **/
    private int points;
    /**
     * The distance associated with the achievement.
     **/
    private double distance;
    /**
     * The amount of questions the user has been asked.
     */
    private int questions;
    /**
     * The speed of the user traveling.
     */
    private int speed;
    /**
     * The amount of steps the user has traveled.
     */
    private int steps;
    /**
     * The amount of trails completed.
     */
    private int trails;
    /**
     * The description of the achievement.
     **/
    String description;
    /**
     * The time the user has been playing.
     */
    double time;

    /**
     * Checks to see if the achievement has been met.
     *
     * @param num The value to be checked.
     * @return true if met false if not met.
     */
    public static boolean checkCompleted(double num, double checkNum){
       return true;
    }

    /**
     * Checks completed achievements.
     * @param num
     * @return
     */

    public static boolean checkCompleted(int num){return true;}

    /**
     * Gets the name of the achievement.
     *
     * @return Name of the achievement.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets the points of the achievement.
     *
     * @return The points of the achievement.
     */
    public int getPoints(){
        return this.points;
    }


    /**
     * Sets the points of the achievement.
     *
     * @return The points of the achievement.
     */
    public void setPoints(int points){
        this.points = points;
    }


    /**
     * Gets the distance associated with the achievement.
     *
     * @return The distance of the achievement.
     */
    public double getDistance(){
        return this.distance;
    }

    /**
     * Gets the description of the achievement.
     *
     * @return The description.
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Gets the speed of the achievement.
     *
     * @return The distance.
     */

    public int getSpeed() {
        return this.speed;
    }

    /**
     * Gets the amount of steps of the achievement.
     *
     * @return The distance.
     */

    public int getSteps() {
        return this.steps;
    }

    /**
     * Gets the amount of trails of the achievement.
     *
     * @return The distance.
     */

    public int getTrails() {
        return this.trails;
    }

    /**
     * Gets the time the user has been playing.
     * @return
     */
    public double getTime(){
        return this.time;
    }

    /**
     * Gets the questions the user has been answered correctly.
     * @return
     */
    public int getQuestions(){
        return this.questions;
    }


}
