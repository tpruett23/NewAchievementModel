package screens;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.toripruett.newachievementmodel.R;

import achievements.SAXParserReader;

/**
 * The class represents the splash screen of the application.
 * @author Tori Pruett
 * @version 1.0
 */
public class SplashScreen extends AppCompatActivity {

    /**
     * The delay before the splash screen goes to the main menu.
     */
    private final int DELAY = 5000;

    /**
     * The method is called to build and start the activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

    }

    /**
     * Part of the activity lifecycle it starts the activity.
     */
    public void onStart() {
        super.onStart();
        Handler handler = new Handler();
        handler.postDelayed(runner, DELAY);
    }

    /**
     * Runs the app.
     */
    private final Runnable runner = new Runnable() {
        @Override
        public void run() {
            nextScreen();

        }
    };

    /**
     * Brings the user to the main menu screen after the splash screen.
     */
    private void nextScreen() {
        Intent i = new Intent(this, TrailMap.class);
        this.startActivity(i);
        this.finish();

    }
}
