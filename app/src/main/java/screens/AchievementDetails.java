package screens;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toripruett.newachievementmodel.R;

/**
 * The class displays the details of the Achievement when clicked.
 * @author Tori Pruett
 * @version 1.0
 */
public class AchievementDetails extends Activity {
    /**
     * The image for that achievement.
     */
    ImageView achvImage;
    /**
     * The textview for the description that is displayed for that achievement.
     */
    TextView achvDetails;
    /**
     * The  textview for the name of the achievement to be displayed.
     */
    TextView achvTitle;
    /**
     * The textview for the points to be displayed for that achievement.
     */
    TextView points;

    /**
     * The textview for the distance to be displayed for that achievement.
     */
    TextView distance;

    /**
     * The method is called to build and start the activity.
     * @param savedInstanceState
     */
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

    /**
     * Sets the image and other textview boxes with the achievement details.
     */
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


