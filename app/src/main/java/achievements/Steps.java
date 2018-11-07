package achievements;

import achievements.AchievementDescriptor;

public class Steps extends AchievementDescriptor {
    String name;
    int points;
    double distance;
    String description;

    public Steps(){
        name = "Step Achievement";
        points = 20;
        distance = 0;
        description = "This is for the number of steps you have taken.";

    }

    @Override
    public boolean checkCompleted(double num) {
        boolean check = false;
        if(num > 300){
           check =  true;
        }
        return check;
    }

    @Override
    public String getName() {
        return name;
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
