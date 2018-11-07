package com.example.toripruett.newachievementmodel;

import java.util.ArrayList;

public class UserInfo {

   public int totalPoints;
   public static double totalDistance;
   public static double timePlayed;
   public static int speed;
   public static int steps;
    static ArrayList<AchievementDescriptor> completed = new ArrayList<>();



    public void UserInfo(){

        totalDistance = 6;
        timePlayed = 7.0;
        speed = 0;
        steps = 200;
    }

         public int getTotalPoints(){
            return this.totalPoints;
            }

        public static double getTotalDistance(){ return totalDistance; }

        public static double getTimePlayed(){
            return timePlayed;
        }

        public static int getSpeed(){ return speed; }

        public static int getSteps(){
        return steps;
    }




public static ArrayList<AchievementDescriptor> getCompleted(){
    return completed;
}
}

