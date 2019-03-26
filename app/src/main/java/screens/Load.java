package screens;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;


import achievements.MyIntentService;
import achievements.MyService;
import achievements.StepCounterActivity;
import achievements.Validation;
import services.CheckAllService;
import trailsystem.StoryEvent;

/**
 * This activity is responsible for starting all services needed to set up the application
 * after the splash screen.
 * @author Tori Pruett
 * @version 2.0
 */
public class Load extends AppCompatActivity {


    /**
     * When this activity is started this method is starting all needed services for the
     * application.
     */
    @Override
    protected void onStart() {
        super.onStart();
        startService(new Intent(this, StepCounterActivity.class));
        startService(new Intent(this, MyService.class));
        startService(new Intent(this,MyIntentService.class));
        Handler handler = new Handler();
        handler.post(runner);

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
     * Brings the user to the TrailMap/Main Menu screen after the splash screen.
     */
    private void nextScreen() {
        Intent i = new Intent(this, TrailMap.class);
        this.startActivity(i);
        this.finish();

    }
}
