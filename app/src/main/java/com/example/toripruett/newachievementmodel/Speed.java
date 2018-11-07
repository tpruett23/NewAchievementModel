package com.example.toripruett.newachievementmodel;

public class Speed extends AchievementDescriptor {
    String name;
    int points;
    double distance;
    String description;

    public Speed(){
        name = "Speed Achievement";
        points = 15;
        distance = 0;
        description = "This is how long it took to complete the course.";

    }
    @Override
    public boolean checkCompleted(double num) {
        boolean check = false;
        if(num > 10){
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
