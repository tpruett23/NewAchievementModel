package achievements;

import achievements.AchievementDescriptor;

/**
 * Question Achievement Descriptor
 * @author Tori Pruett
 * @version 2.0
 */

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
    public Question(String name, int points,String description, int questionsCorrect) {
        this.name = name;
        this.points = points;
        this.distance = distance;
        this.description = description;
        this.questionsCorrect = questionsCorrect;

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
     * Gets the number of questions answered correctly.
     * @param The points we are getting.
     */
    @Override
    public int getQuestions(){
        return this.questionsCorrect;
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
