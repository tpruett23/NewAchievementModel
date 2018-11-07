package com.example.toripruett.newachievementmodel;


import java.util.ArrayList;

public class Achievements {
   static ArrayList<AchievementDescriptor> allAchievements;
    AchievementDescriptor steps = new Steps();
    AchievementDescriptor trails = new Trails();
    AchievementDescriptor question = new Question();
    AchievementDescriptor challenges = new Challenges();
    AchievementDescriptor distance = new Distance();
    AchievementDescriptor time = new Time();
    AchievementDescriptor speed = new Speed();
    boolean see = false;

    public Achievements(){
        allAchievements = new ArrayList<>();
        if(!see) {
            add();
        }

    }



    public void add(){


        allAchievements.add(steps);
        allAchievements.add(trails);
        allAchievements.add(question);
        allAchievements.add(challenges);
        allAchievements.add(distance);
        allAchievements.add(time);
        allAchievements.add(speed);
        see = true;
    }



    public static ArrayList<AchievementDescriptor> getAllAchievements(){
    return allAchievements;
}


}