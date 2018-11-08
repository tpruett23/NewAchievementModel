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
     * @param num The value to be checked.
     * @return true if met false if not met.
     */
    public abstract boolean checkCompleted(double num);

    /**
     * Gets the name of the achievement.
     * @return Name of the achievement.
     */
    public abstract String getName();

    /**
     * Gets the points of the achievement.
     * @return The points of the achievement.
     */
    public abstract int getPoints();

    /**
     * Gets the distance associated with the achievement.
     * @return The distance of the achievement.
     */
    public abstract double getDistance();

    /**
     * Gets the description of the achievement.
     * @return The description.
     */
    public abstract String getDescription();


}
