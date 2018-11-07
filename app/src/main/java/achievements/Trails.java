package achievements;

import achievements.AchievementDescriptor;
import achievements.Achievements;

public class Trails extends AchievementDescriptor {

    String name;
    int points;
    String description;
    double distance;
    Achievements ach;

    public Trails(){

       name = "Trail Achievement";
       points = 20;
       distance = 0;
       description = "This is the number of trails you have completed.";


    }

    @Override
    public boolean checkCompleted(double num) {
        boolean check =  false;
        if(num > 3){
            check = true;
        }
        return check;
    }

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
