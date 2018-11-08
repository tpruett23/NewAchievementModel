package achievements;

public abstract class AchievementDescriptor {
    /**
     * The name of the Achievement.
     **/
    String name;

    /**
     * How many points the achievement is worth.
     **/
    int points;

    /**
     * The distance associated with the achievement.
     **/
    double distance;

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
    public boolean checkCompleted(double num){
       return true;
    }

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


}
