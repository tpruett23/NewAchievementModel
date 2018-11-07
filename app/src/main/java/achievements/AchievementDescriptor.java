package achievements;

public abstract class AchievementDescriptor {
    String name;
    int points;
    double distance;
    String description;
    Achievements ach;





    public abstract boolean checkCompleted(double num);
    public abstract String getName();
    public abstract int getPoints();
    public abstract double getDistance();
    public abstract String getDescription();


}
