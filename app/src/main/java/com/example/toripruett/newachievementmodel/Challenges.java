package com.example.toripruett.newachievementmodel;

public class Challenges extends AchievementDescriptor {

    String name;
    int points;
    String description;
    double distance;


    public Challenges() {
        name = "Challenge Achievement";
        points = 15;
        distance = 0;
        description = "This is how many challenges you have completed.";
    }

    @Override
    public boolean checkCompleted(double num) {
        boolean check = false;
        if (num > 3.0) {
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