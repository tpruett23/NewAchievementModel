package com.example.toripruett.newachievementmodel;


public class Achievements {
    private String name;
    private static int points;
    private static double distance;


    public Achievements(String achName, int pointTotal, double distanceTrav){
        this.name = achName;
        points = pointTotal;
        distance = distanceTrav;

    }

    public Achievements(){
        this("",0,0.0);

    }


    public String getName(){
        return this.name;
    }

    public static int getPoints(){
        return points;
    }

    public static double getDistance(){
        return distance;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public void setDistance(double traveled){
        this.distance = traveled;
    }





}
