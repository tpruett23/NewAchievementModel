package com.example.toripruett.newachievementmodel;

public class Question extends AchievementDescriptor {
    String name;
    int points;
    double distance;
    String description;

    public Question(){
        name = "Question Achievement";
        points = 20;
        distance = 0;
        description = "You have answered 10 questions completely.";

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
