package achievements;

import android.app.Activity;
import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toripruett.newachievementmodel.R;

import screens.TrailMap;
import screens.UserCompleted;
import trailsystem.Trail;
/**
 * This class counts and detects steps the traveler takes.
 * @author Tori Pruett
 * @version 1.1
 */
public class StepCounterActivity extends Service implements SensorEventListener {
    /**
     * The sensor manager that works with the light sensor.
     */
    private static SensorManager mSensorManager;
   
    /**
     * The sensor that counts the steps.
     */
    private static Sensor mStepCounterSensor;
    /**
     * The step dector sensor.
     */
    private static Sensor mStepDetectorSensor;
    /**
     * The userinfo instance to store the steps the user takes.
     */
    UserInfo ui = new UserInfo();

    /**
     * Used to create the class and initialize values on start up.
     */
    public void onCreate() {

        mSensorManager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);
        mStepCounterSensor = mSensorManager
                .getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        mStepDetectorSensor = mSensorManager
                .getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);


        mSensorManager.registerListener(this, mStepCounterSensor,

                SensorManager.SENSOR_DELAY_FASTEST);
        mSensorManager.registerListener(this, mStepDetectorSensor,

                SensorManager.SENSOR_DELAY_FASTEST);
    }

    /**
     * Detects the steps when the sensor detects a change.
     * @param event The sensorEvent to detect change with the sensor.
     */
    public void onSensorChanged(SensorEvent event) {


        Sensor sensor = event.sensor;

        float[] values = event.values;

        int value = -1;


        if (values.length > 0) {
            value = (int) values[0];
        }

        if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            //textView.setText("Step Counter Detected : " + value);
            Toast.makeText(getApplicationContext(), "Steps Taken: " + value, Toast.LENGTH_LONG).show();
            ui.setSteps(value);

        } else if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            // For test only. Only allowed value is 1.0 i.e. for step taken
            //textView2.setText("Step Detector Detected : " + value);
        }

    }
    /**
     * Detects changes in accuracy.
     * @param sensor Detects the change with this sensor.
     * @param accuracy The new accuracy.
     */
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    /**
     * Called when the class is destroyed to unregister listeners.
     */
    public void onDestroy() {
        super.onDestroy();
        mSensorManager.unregisterListener(this, mStepCounterSensor);
        mSensorManager.unregisterListener(this, mStepDetectorSensor);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}




