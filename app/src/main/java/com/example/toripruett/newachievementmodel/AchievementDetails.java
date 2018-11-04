package com.example.toripruett.newachievementmodel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AchievementDetails extends Activity {

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
        String image = extras.getString("pic");
        String imageFlower = extras.getString("picflower");



        if(image != null) {
            int pic = getResources().getIdentifier(image + ".png","drawable",getPackageName());

            achvImage.setImageResource(pic);
            achvImage.setVisibility(View.VISIBLE);

        }else {
            int flowerPic = getResources().getIdentifier(imageFlower + ".jpg", "drawable", getPackageName());
            achvImage.setImageResource(flowerPic);
            achvImage.setVisibility(View.VISIBLE);
        }

        String text = extras.getString("text");
        achvDetails.setText(text);

        String title = extras.getString("title");
        achvTitle.setText(title);

        String points1 = extras.getString("points");
        points.setText(points1);

        String distance1 = extras.getString("distance");
        distance.setText(distance1);
    }

}
