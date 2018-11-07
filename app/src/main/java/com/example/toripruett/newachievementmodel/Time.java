package com.example.toripruett.newachievementmodel;

public class Time extends AchievementDescriptor {

        String name;
        int points;
        double distance;
        String description;

        public Time(){
            name = "Time Achievement";
            points = 10;
            distance = 0;
            description = "This is how long you have been on the trail.";
        }

        @Override
        public boolean checkCompleted(double num) {
            boolean check = false;
            if(num > 3.0){
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
