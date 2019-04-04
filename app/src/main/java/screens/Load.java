package screens;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.example.toripruett.newachievementmodel.R;

import java.util.Date;

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

    public static final int REQUEST_CODE = (int) new Date().getTime();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scheduleAlarm();
    }

    /**
     * When this activity is started this method is starting all needed services for the
     * application.
     */
    @Override
    protected void onStart() {
        super.onStart();
        startService(new Intent(this, StepCounterActivity.class));
        startService(new Intent(this, MyService.class));
        startService(new Intent(getApplicationContext(),MyIntentService.class));

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


    public void scheduleAlarm()
    {
        // Construct an intent that will execute the AlarmReceiver
        Intent intent = new Intent(getApplicationContext(), MyIntentService.class);
        // Create a PendingIntent to be triggered when the alarm goes off
        final PendingIntent pIntent = PendingIntent.getBroadcast(
                this, REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Setup periodic alarm every every half hour from this point onwards
        long firstMillis = System.currentTimeMillis(); // alarm is set right away
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        // First parameter is the type: ELAPSED_REALTIME, ELAPSED_REALTIME_WAKEUP, RTC_WAKEUP
        // Interval can be INTERVAL_FIFTEEN_MINUTES, INTERVAL_HALF_HOUR, INTERVAL_HOUR, INTERVAL_DAY
        alarm.setRepeating(AlarmManager.ELAPSED_REALTIME, firstMillis, (long) (1000 * 10), pIntent);



    }

}
