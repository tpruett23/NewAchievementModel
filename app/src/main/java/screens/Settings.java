package screens;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.toripruett.newachievementmodel.R;
import com.google.android.gms.maps.model.MapStyleOptions;

/**
 * The class represents the settings screen and the values associated with it.
 *
 * @author Tori Pruett
 */
public class Settings extends AppCompatActivity implements OnClickListener {
    /**
     * The checkbox to turn the sound on and off.
     */
    static CheckBox sound;
    /**
     * The checkbox to turn darkmode on and off.
     */
    static CheckBox darkMode;
    /**
     * The checkbox to turn on the autoLight service.
     */
     static CheckBox autoLight;
    /**
     * The lightsensor boolean to determine if the autolight service should be started.
     */
    public static boolean lightSensor;
    /**
     * Float value for the light quantity.
     */
    static float mLightQuantity;
    /** 
     * Constructor
     */
    public Settings() {



    }

    /**
     * The method is called to create the activity and to build the activity.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        sound = findViewById(R.id.soundcheck);
        sound.setOnClickListener(this);
        sound.setChecked(true);


        autoLight = findViewById(R.id.autolight);
        autoLight.setOnClickListener(this);

        darkMode = findViewById(R.id.darkcheck);
        darkMode.setOnClickListener(this);



        loadPrefs();


    }

    /**
     * The method that is called when one of the buttons is clicked.
     *
     * @param v The button that is clicked.
     */
    public void onClick(View v) {


        if (v.getId() == R.id.soundcheck) {
            if (sound.isChecked()) {
                if (!TrailMap.mediaPlayer.isPlaying())
                    TrailMap.mediaPlayer.start();
            } else {
                TrailMap.mediaPlayer.pause();
            }
        }

        if (v.getId() == R.id.darkcheck) {
            if (darkMode.isChecked()) {
                MapStyleOptions mapStyleOptions = MapStyleOptions.loadRawResourceStyle(this, R.raw.style_json);
                TrailMap.UpdateMapStyleOptions(mapStyleOptions);


            } else {
                MapStyleOptions mapStyleOptions = MapStyleOptions.loadRawResourceStyle(this, R.raw.style2_json);
                TrailMap.UpdateMapStyleOptions(mapStyleOptions);


            }
        }


        if (v.getId() == R.id.autolight) {
            if (autoLight.isChecked()) {
                /*
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
                        SensorManager.SENSOR_DELAY_NORMAL); */
                lightSensor = true;
            }
            lightSensor = false;

        }
        savePrefs();
    }


    /**
     * Loads the preferences put in by the user after being saved.
     */
    public void loadPrefs() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
        int att = sharedPreferences.getInt("sound", 1);
        int mode = sharedPreferences.getInt("mode", 1);
        int light = sharedPreferences.getInt("light",1);

        if (att == 1) {
            sound.setChecked(true);
        } else {
            sound.setChecked(false);
        }

        if (mode == 1) {
            darkMode.setChecked(true);
        } else if(mode == 4){
            darkMode.setChecked(false);
        }


        if (light == 1) {
            autoLight.setChecked(true);
        } else if (light == 5){
            autoLight.setChecked(false);
    }

}





    /**
     * Saves the preferences entered by the user.
     */

    public  void savePrefs() {
        SharedPreferences sf = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
        SharedPreferences.Editor editor = sf.edit();


        boolean save = sound.isChecked();
        if (save) {
            editor.putInt("sound", 1);
        } else {
            editor.putInt("sound", 3);

        }

        boolean mode = darkMode.isChecked();
        if(mode){
           editor.putInt("mode", 1);
        }else{
            editor.putInt("mode", 4);
        }

        boolean light = autoLight.isChecked();
        if(light){
            editor.putInt("light", 1);
        }else{
            editor.putInt("light", 5);
        }


        editor.apply();
        editor.commit();

    }

    @Override
    protected void onDestroy() {
        savePrefs();
        super.onDestroy();
        //savePrefs();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
