package screens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.toripruett.newachievementmodel.R;

/**
 * The class represents the Mini Game portion of the application.
 * @author Tori Pruett
 * @version 1.0
 */
public class MiniGame extends AppCompatActivity {
    /**
     * This is called when the activity is created where it can build and create values.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minigame);
    }

}
