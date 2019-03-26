package achievements;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.widget.Toast;

import services.CheckAllService;


/**
 * @author  Tori Pruett
 * The class is a service that checks for new achievements.
 */
public class MyIntentService extends Service {

    /**
     * Starts the service every 1 minute to check for new achievements.
     * @param intent
     * @param flags
     * @param startid
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
                ha.postDelayed(this, 10000);

            }
        }, 10000);


        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}