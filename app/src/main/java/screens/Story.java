package screens;

import android.app.Activity;
import android.os.Bundle;

import com.example.toripruett.newachievementmodel.R;

/**
 * The class represents the story mode activity/screen.
 * @author Tori Pruett
 * @version 2.0
 */
public class Story extends Activity {

    /**
     * The method is called to build and start the activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
    }


}