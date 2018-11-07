package achievements;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toripruett.newachievementmodel.R;

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


    public static class AchievementDetails extends Activity {

        ImageView achvImage;
        TextView achvDetails;
        TextView achvTitle;
        TextView points;
        TextView distance;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.detailacheivements);

            achvImage = (ImageView)findViewById(R.id.detailimage1);
            achvDetails = (TextView)findViewById(R.id.detailtextview1);
            achvTitle = (TextView)findViewById(R.id.detailtitle);
            points = (TextView)findViewById(R.id.pointtextview);
            distance = (TextView)findViewById(R.id.distancetextview);

            setImage();
        }

        public void setImage(){




            Bundle extras = getIntent().getExtras();
            //String image = extras.getString("pic");
            //String imageFlower = extras.getString("picflower");


            /*
            if(image != null) {
                int pic = getResources().getIdentifier(image + ".png","drawable",getPackageName());

                achvImage.setImageResource(pic);
                achvImage.setVisibility(View.VISIBLE);

            }else {
                int flowerPic = getResources().getIdentifier(imageFlower + ".jpg", "drawable", getPackageName());
                achvImage.setImageResource(flowerPic);
                achvImage.setVisibility(View.VISIBLE);
            }*/

            String text = extras.getString("text");
            achvDetails.setText(text);

            String title = extras.getString("title");
            achvTitle.setText(title);

            int points1 = extras.getInt("points");
            points.setText("Points: " + points1);

            double distance1 = extras.getDouble("distance");
            distance.setText("Distance: " + distance1);

        }

    }
}