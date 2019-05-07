package services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.example.toripruett.newachievementmodel.R;
import com.google.android.gms.maps.model.MapStyleOptions;

import screens.TrailMap;

/**
 * The class is a service to detect the surrounding light using the ambient light sensor.
 * @author Melchor Dominguez 
 */
public class LightService extends Service {

    /** indicates the light quality for the light service **/
    private static float mLightQuantity;
    /** indicates how to behave if the service is killed **/
    private int mStartMode;
    /** interface for clients that bind **/
    IBinder mBinder = null;
    /** indicates whether onRebind should be used **/
    private boolean mAllowRebind;

    /**
     * Called when the service is being created.
     */
    @Override
    public void onCreate(){

    }


    /**
     * Return the communication channel to the service. May return null if clients can
     * not bind to service. The returned IBinder is usually for a complex interface
     * that had been described using aidl.
     * @param intent - The intent that was used to bind to this service as given to
     *               Context.bindService. Not that any extras that were included
     *               with the Intent at that point will not be seen here.
     * @return - Return an IBinder through which clients can call on to the service.
     */
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /**
     * Called by the system every time a client explicitly starts the service by calling
     * Context.startService(Intent), providing the arguments it supplied and a
     * unique integer token representing the start request. Do not call this method directly.
     * @param intent - The intent supplied to Context.startService(Intent), as given. This may be
     *               null if the service is being restarted after its process has gone away,
     *               and it had previously returned anything except START_STICKY_COMPATIBILITY
     * @param flags - Additional data about this start request. Value is either 0 or a combination
     *              of START_FLAG_REDELIVERY, and START_FLAG_RETRY;
     * @param startId - A unique integer representing this specific request to start. Use with
     *                stopSelfResult(int).
     * @return - The return value indicates what semantics the system should use for the service's
     *           current started state. It may be one of the constants associated with the
     *           START_CONTINUATION_MASK bits. Value is START_STICKY_COMPATIBILITY, START_STICKY,
     *           START_NOT_STICKY, or START_REDELIVER_INTENT.
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        //Let it continue running until it is stopped

        Log.v("lService", "service started");

        final SensorManager mSensorManager;

        mSensorManager =
                (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        assert mSensorManager != null;
        final Sensor LightSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        //Toast.makeText(this,"Light Service is Running",Toast.LENGTH_LONG).show();
        Log.v("Light", "The light service is running");
        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                mLightQuantity = event.values[0];
                Log.v("lService", String.valueOf(mLightQuantity));
                sendMessage();
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        mSensorManager.registerListener(
                sensorEventListener,
                LightSensor,
                SensorManager.SENSOR_DELAY_NORMAL);

        return START_STICKY;
    }
   /**
     * The method is called when the service is destroyed.
     */
    public void onDestroy(){
        Log.v("lService", "service stopping");
        super.onDestroy();
    }
    /**
     * The method is called to send a message through an intent.
     */
    private void sendMessage(){
        Log.v ("lService", "sending a message");
        Intent intent = new Intent("light-number");
        intent.putExtra("lightQuantity", mLightQuantity);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }


}
