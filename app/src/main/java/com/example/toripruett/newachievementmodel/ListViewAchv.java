package com.example.toripruett.newachievementmodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListViewAchv extends AppCompatActivity {
    private static ArrayList<Achievements> achievements;
    private static ArrayList<Achievements> completed;
    private ListView lv;
    AchievementFactory AF;
    ArrayAdapter<Achievements> adapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);



        lv = (ListView) findViewById(R.id.list);

        achievements = new ArrayList<Achievements>();

        completed = UserInfo.completed;

        AF = new AchievementFactory();


        adapter = new CustomListAdapter(this,R.layout.list_item,R.layout.activity_list_view,achievements);

        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            @Override
            public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
            {
                String selectedAch = achievements.get(position).getName();


                Intent myIntent = new Intent(v.getContext(),AchievementDetails.class);

                myIntent.putExtra("name",selectedAch);

                 if(position == 0) {
                     Intent data = new Intent(v.getContext(),AchievementDetails.class);
                     data.putExtra("pic", "mile5");
                     data.putExtra("title", "1 Mile Achievement");
                     data.putExtra("text", "You have traveled 1 Mile on the WCU Trail System, Congrats!");
                     data.putExtra("points", "Points: 10");
                     data.putExtra("distance", "Distance: 1 Mile");
                     startActivity(data);
                 }
                 if(position == 1){
                     Intent data = new Intent(v.getContext(),AchievementDetails.class);
                     data.putExtra("pic", "mile");
                     data.putExtra("title", "5 Mile Achievement");
                     data.putExtra("text", "You have traveled 5 Miles on the WCU Trail System, Congrats!");
                     data.putExtra("points", "Points: 15");
                     data.putExtra("distance", "Distance: 5 Miles");
                     startActivity(data);
                 }
                if(position == 2){
                    Intent data = new Intent(v.getContext(),AchievementDetails.class);
                    data.putExtra("picflower", "flowerach");
                    data.putExtra("title","Flower Achievement");
                    data.putExtra("text", "You have found the correct flower on the trail, Congrats!");
                    data.putExtra("points", "Points: 5");
                    data.putExtra("distance", "Distance: 0 Miles");
                    startActivity(data);
                }
                if(position == 3){
                    Intent data = new Intent(v.getContext(),AchievementDetails.class);
                    data.putExtra("pic", "hourach");
                    data.putExtra("title", "1 Hour Achievement");
                    data.putExtra("text", "You have been traveling on the WCU Trail System for 1 Hour, Congrats!");
                    data.putExtra("points", "Points: 20");
                    data.putExtra("distance", "Distance: 0 Miles");
                    startActivity(data);
                }

                setResult(RESULT_OK,myIntent);

                Toast.makeText(getApplicationContext(), "Achievement Selected : " + selectedAch,   Toast.LENGTH_LONG).show();

            }

        });
        //lv.setOnItemClickListener(this);

    }



    public static void addAch(Achievements ach){
        achievements.add(ach);
    }


}
