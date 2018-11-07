package achievements;

import achievements.AchievementDescriptor;

public class Distance extends AchievementDescriptor {
    String name;
    int points;
    double distance;
    String description;


    public Distance(){
        name = "Distance Achievement";
        points = 10;
        distance = 3;
        description = "This is the total distance achievement.";
    }

    @Override
    public boolean checkCompleted(double num) {
        boolean check = false;
        if(num > 5){

            check = true;
        }
            return check;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPoints() {
        return this.points;
    }

    @Override
    public double getDistance() {
        return this.distance;
    }

    @Override
    public String getDescription() {
        return this.description;
    }


}
