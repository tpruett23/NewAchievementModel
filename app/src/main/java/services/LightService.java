package services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.toripruett.newachievementmodel.R;
import com.google.android.gms.maps.model.MapStyleOptions;

import screens.TrailMap;


public class LightService extends Service {

    static float mLightQuantity;

    /*
    @Override
    public void onCreate(){

        final SensorManager mSensorManager;

        mSensorManager =
                (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        assert mSensorManager != null;
        final Sensor LightSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                mLightQuantity = event.values[0];
                if(mLightQuantity > 150){
                    MapStyleOptions mapStyleOptions = MapStyleOptions.loadRawResourceStyle(getApplicationContext(), R.raw.style2_json);
                    TrailMap.UpdateMapStyleOptions(mapStyleOptions);

                }else{
                    {
                        MapStyleOptions mapStyleOptions = MapStyleOptions.loadRawResourceStyle(getApplicationContext(), R.raw.style_json);
                        TrailMap.UpdateMapStyleOptions(mapStyleOptions);
                    }

                }


            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        mSensorManager.registerListener(
                sensorEventListener,
                LightSensor,
                SensorManager.SENSOR_DELAY_NORMAL);

    } */

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        //Let it continue running until it is stopped

        final SensorManager mSensorManager;

        mSensorManager =
                (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        assert mSensorManager != null;
        final Sensor LightSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                mLightQuantity = event.values[0];
                if(mLightQuantity > 150){
                    MapStyleOptions mapStyleOptions = MapStyleOptions.loadRawResourceStyle(getApplicationContext(), R.raw.style2_json);
                    TrailMap.UpdateMapStyleOptions(mapStyleOptions);

                }else{
                    {
                        MapStyleOptions mapStyleOptions = MapStyleOptions.loadRawResourceStyle(getApplicationContext(), R.raw.style_json);
                        TrailMap.UpdateMapStyleOptions(mapStyleOptions);
                    }

                }


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
}
