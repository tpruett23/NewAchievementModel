package com.example.toripruett.newachievementmodel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class UserCompleted extends AppCompatActivity {
    private ListView lv;
    private int trails = 4;
    private int questionsCorrect = 11;
    private int questionsIncorrect = 2;
    private int achievementsWon = 3;
    private int challenges = 4;

    ArrayList<AchievementDescriptor> completed = UserInfo.getCompleted();

    ArrayAdapter<AchievementDescriptor> adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.usertrophycabinet);


        lv = (ListView) findViewById(R.id.list);
        adapter = new CustomListAdapter(this, R.layout.userlist, R.layout.activity_list_view, completed);

        lv.setAdapter(adapter);
    }


    public  int getTrails(){
        return this.trails;
    }

    public  int getChallenges(){
        return challenges;
    }

    public  int getQuestionsCorrect() {
        return questionsCorrect;
    }

    public  int getQuestionsIncorrect(){
        return questionsIncorrect;
    }

    public  int getAchievementsWon() {
        return achievementsWon;
    }

    public ArrayList<AchievementDescriptor> getCompleted(){
    return this.completed;
    }
}






