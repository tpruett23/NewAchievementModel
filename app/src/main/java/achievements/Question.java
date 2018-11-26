package achievements;

import achievements.AchievementDescriptor;

public class Question extends AchievementDescriptor {
    /**
     * The name of the achievement
     **/
    String name;

    /**
     * How many points for the achievement.
     **/
    int points;

    /**
     * The description of the achievement.
     **/
    String description;

    /**
     * The distance associated with the achievement.
     **/
    double distance;


    /**
     * The number of questions answered correctly to receive this achievement.
     */
    int questionsCorrect;


    /**
     * The constructor for the Question achievement.
     */
    public Question(String name, int points, double distance, String description, int questionsCorrect) {
        this.name = name;
        this.points = points;
        this.distance = distance;
        this.description = description;
        this.questionsCorrect = questionsCorrect;

    }

    public Question(){

    }

    /**
     * The method to check to see if the achievement has been met.
     *
     * @param num The value to be checked.
     * @return true if met false if not met.
     */
    //@Override
    public static boolean checkCompleted(double num, double checkNum) {
        boolean check = false;
        if (num > 10) {
            check = true;
        }
        return check;

    }

    /**
     * Gets the name of the achievement.
     *
     * @return The name of the achievement.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Gets the points of the achievement.
     *
     * @return The points of the achievement.
     */
    @Override
    public int getPoints() {
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
     * Gets the distance of the achievement.
     *
     * @return The distance.
     */
    @Override
    public double getDistance() {
        return this.distance;
    }

    /**
     * Gets the description of the achievement.
     *
     * @return The description of the achievement.
     */
    @Override
    public String getDescription() {
        return this.description;
    }


}
