package com.example.toripruett.newachievementmodel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class UserCompleted extends AppCompatActivity {
    private ListView lv;
    public static int trails;
    public static int questionsCorrect;
    public static int questionsIncorrect;
    public static int achievementsWon;


    ArrayAdapter<Achievements> adapter;
    ArrayList<Achievements> completed = UserInfo.completed;

    public UserCompleted(){
        trails = 0;
        questionsCorrect = 0;
        questionsIncorrect = 0;
        achievementsWon = 0;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.usertrophycabinet);


        lv = (ListView) findViewById(R.id.list);
        adapter = new CustomListAdapter(this, R.layout.userlist, R.layout.activity_list_view, completed);

        lv.setAdapter(adapter);
    }


    public static int getTrails(){
        return trails;
    }

    public static int getQuestionsCorrect() {
        return questionsCorrect;
    }

    public static int getQuestionsIncorrect(){
        return questionsIncorrect;
    }

    public static int getAchievementsWon() {
        return achievementsWon;
    }

    public void setTrails(int trail){
        trails = trail;
    }

    public static void setAchievementsWon(int achievements) {
        achievementsWon = achievements;
    }

    public static void setQuestionsCorrect(int correct){
        questionsCorrect = correct;
    }

    public void setQuestionsIncorrect(int incorrect){
        questionsIncorrect = incorrect;
    }
}
