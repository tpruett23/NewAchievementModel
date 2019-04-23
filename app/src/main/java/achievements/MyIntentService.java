package achievements;
import android.app.AlertDialog;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Toast;

import com.example.toripruett.newachievementmodel.R;

import java.util.Random;

import screens.Facts;
import screens.NotificationActivity;
import services.CheckAllService;
import trailsystem.Trail;


/**
 * @author  Tori Pruett
 * The class is a service that checks for new achievements.
 */
public class MyIntentService extends Service {
    Context context;

    /**
     * Starts the service every 30 sec to check for new achievements.
     * @param intent
     //* @param flags
     //* @param startid
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startid) {
        final Handler ha = new Handler(getApplicationContext().getMainLooper());
        ha.postDelayed(new Runnable() {

            @Override
            public void run() {

               Intent intent1 = new Intent(getApplicationContext(), CheckAllService.class);
                startService(intent1);

                //Toast.makeText(getApplicationContext(),"Check All Service Started",Toast.LENGTH_LONG).show();
                ha.postDelayed(this, 30000);

            }
        }, 30000);


        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    }


