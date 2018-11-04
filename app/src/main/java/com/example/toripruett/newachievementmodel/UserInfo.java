package com.example.toripruett.newachievementmodel;

import java.util.ArrayList;

public class UserInfo {

   public static ArrayList<Achievements> completed = new ArrayList<>();
   public static int totalPoints;
   public static double totalDistance;
   public static double timePlayed;


    public void UserInfo(){
        totalPoints = 0;
        totalDistance = 0;
        timePlayed = 0.0;

    }

    public static ArrayList<Achievements> getCompleted(){
        return completed;
    }


    public static void addCompleted(Achievements ach){
            completed.add(ach);
        }

        public static void setTotalPoints(int points){ totalPoints = points;}

        public static void setTotalDistance(int distance){ totalDistance = distance; }

         public static int getTotalPoints(){
            return totalPoints;
            }

        public static double getTotalDistance(){
            return totalDistance;
        }

        public static double getTimePlayed(){
            return timePlayed;
        }

        public static void setTimePlayed(double time){
            timePlayed = time;
        }


}

