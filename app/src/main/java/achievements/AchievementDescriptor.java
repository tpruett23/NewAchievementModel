package achievements;

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


    private int speed;

    private int steps;

    /**
     * The description of the achievement.
     **/
    String description;


    /**
     * Checks to see if the achievement has been met.
     *
     * @param num The value to be checked.
     * @return true if met false if not met.
     */
    public static boolean checkCompleted(double num, double checkNum){
       return true;
    };

    public static boolean checkCompleted(int num){return true;};

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
     * Gets the distance of the achievement.
     *
     * @return The distance.
     */

    public int getSpeed() {
        return this.speed;
    }

    /**
     * Gets the distance of the achievement.
     *
     * @return The distance.
     */

    public int getSteps() {
        return this.steps;
    }




}
