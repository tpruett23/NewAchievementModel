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

public class StepCounterActivity extends Service implements SensorEventListener {

    private static SensorManager mSensorManager;

    private static Sensor mStepCounterSensor;

    private static Sensor mStepDetectorSensor;
    UserInfo ui = new UserInfo();


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

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

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




