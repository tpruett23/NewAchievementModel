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
import trailsystem.StoryEvent;

public class Load extends AppCompatActivity {


    public void onCreate(){



    }

    @Override
    protected void onStart() {
        super.onStart();
        startService(new Intent(this, StepCounterActivity.class));
        startService(new Intent(this, MyService.class));
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
     * Brings the user to the main menu screen after the splash screen.
     */
    private void nextScreen() {
        Intent i = new Intent(this, TrailMap.class);
        startService(new Intent(this,MyIntentService.class));
        this.startActivity(i);
        this.finish();

    }
}
