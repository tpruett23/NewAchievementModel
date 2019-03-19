package services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import achievements.AchievementXMLHandler;
import achievements.ListViewAchv;
import achievements.MyIntentService;
import achievements.UserInfo;
import screens.TrailMap;
import screens.UserCompleted;

/**
 * Class which extends service to help keep track of the distance
 * @author - Melchor Dominguez
 * @version 1.0
 */
public class DistanceService extends Service {
    UserCompleted userCompleted = new UserCompleted();


    /**
     * Called when the distance service has been created and performs
     * all tasks associated with the distance of the application.
     */
    @Override
    public void onCreate(){
        //get the most recent distance update
        double recentdistance = TrailMap.distance;
        userCompleted.updateDistance(recentdistance);
        Toast.makeText(this,userCompleted.getDistanceUser() + "",Toast.LENGTH_LONG).show();




        stopSelf(); // service no longer needs to continue
                    // will start again when a new distance is calculated.
    }

    /**
     * Return the communication channel to the service. May return null if clients
     * can not bind to the service. The returned IBinder is usually for a complex
     * interface that has been described using aidl.
     *
     * Note: Unlike other application components: calls on to the IBinder interface
     * returned here may not happen on the main thread of the process.
     *
     * @param intent - Intent: The intent that was used to bind to this service, as given
     *               to Context.bindService Note that any extras that were included
     *               with the Intent at that point will not be seen here.
     * @return - null (This Application does not deal with client-server interactions)
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    /**
     * Called by the system every time a client explicitly starts the service by
     * calling Context.startService(Intent), providing the arguments it supplies and a
     * unique integer token representing the start request. Do not call this method directly.
     *
     * Note: System calls occur on your service's main thread. A service's main thread is
     * the same thread where UI operations take place for Activities running in the same
     * process. You should always avoid stalling the main thread'd event loop. When doing
     * long-running operations, network calls, or heavy disk I/O, you should kick off
     * a new thread, or use AsyncTask.
     *
     * @param intent - The Intent supplied to Context.startService(Intent), as given. This
     *               may be null if the service is being restarted after its process has
     *               gone away, and it had previously returned anything except
     *               START_STICKY_COMPATIBILITY
     * @param flags - Additional data about this start request. Value is either 0 or a
     *              combination of START_FLAG_REDELIVERY, and START_FLAG_RETRY
     * @param startId - A unique integer representing this specific request to start. Use with
     *                stopSelfResult(int).
     * @return - The return value indicated what semantics the system should use for the
     *  service's current state. It may be one of the constants associated with the
     *  START_CONTINUATION_MASK bits. Value is START_STICKY_COMPATIBILITY,
     *  START_STICKY, START_NOT_STICKY, or START_REDELIVER_INTENT.
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        //Let it continue running until stopped.
        //Toast.makeText(this, "Distance Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    /**
     * Called by the system to notify a Service that is no longer used and is being removed.
     * The service should clean up any resources it holds (threads, registered receivers, etc)
     * at this point. Upon return, there will be no more calls in to this Service object
     * and it is effectively dead. Do not call this method directly.
     */
    public void onDestroy(){
        super.onDestroy();
        //Toast.makeText(this, "Distance Service stopped", Toast.LENGTH_LONG).show();
    }
}
