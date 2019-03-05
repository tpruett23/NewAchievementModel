package screens;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.toripruett.newachievementmodel.R;
import com.google.android.gms.maps.model.MapStyleOptions;

import trailsystem.Trail;

/**
 * The class represents the settings screen and the values associated with it.
 *
 * @author Tori Pruett
 */
public class Settings extends AppCompatActivity implements OnClickListener {
    /**
     * The checkbox to turn the sound on and off.
     */
    CheckBox sound;
    CheckBox darkMode;
    CheckBox autolight;

    static float mLightQuantity;

    /**
     * The buttons to save, load, and go back to the previous screen.
     */
    Button load, save, back;

    public Settings(){

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

        sound = (CheckBox) findViewById(R.id.soundcheck);
        sound.setOnClickListener(this);


        autolight = (CheckBox) findViewById(R.id.autolight);
        autolight.setOnClickListener(this);
        autolight.setChecked(false);

        darkMode = (CheckBox) findViewById(R.id.darkcheck);
        darkMode.setOnClickListener(this);
        darkMode.setChecked(true);

        loadPrefs();


    }

    /**
     * The method that is called when one of the buttons is clicked.
     *
     * @param v The button that is clicked.
     */
    public void onClick(View v) {
        Intent i = null;

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
                autolight.setChecked(false);

            }else{
                MapStyleOptions mapStyleOptions = MapStyleOptions.loadRawResourceStyle(this, R.raw.style2_json);
                TrailMap.UpdateMapStyleOptions(mapStyleOptions);

            }
        }


        if (v.getId() == R.id.autolight) {
            if (autolight.isChecked()) {
                final SensorManager mSensorManager;

                mSensorManager =
                        (SensorManager) getSystemService(Context.SENSOR_SERVICE);

                final Sensor LightSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

                SensorEventListener sensorlistener = new SensorEventListener() {
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
                        sensorlistener,
                        LightSensor,
                        SensorManager.SENSOR_DELAY_NORMAL);
            }
        }
        savePrefs();
    }

    //}

    /**
     * Loads the preferences put in by the user after being saved.
     */
    public void loadPrefs() {
        SharedPreferences settings = getPreferences(Context.MODE_PRIVATE);
        int att = settings.getInt("sound", 1);
        int mode = settings.getInt("mode",1);
        int light = settings.getInt("light",1);

        if (att == 1) {
            sound.setChecked(true);
        } else {
            sound.setChecked(false);
        }

        if(mode == 1){
            darkMode.setChecked(true);
        }else{
            darkMode.setChecked(false);
        }


        if(light == 1){
            darkMode.setChecked(true);
        }else{
            darkMode.setChecked(false);
        }



    }

    /**
     * Saves the preferences entered by the user.
     */

    public void savePrefs() {
        SharedPreferences.Editor settings = getPreferences(MODE_PRIVATE).edit();

        boolean save = sound.isChecked();
        if (save) {
            settings.putInt("sound", 1);
        } else {
            settings.putInt("sound", 3);

        }

        boolean mode = darkMode.isChecked();
        if(mode){
            settings.putInt("mode", 1);
        }else{
            settings.putInt("mode", 2);
        }

        boolean light = autolight.isChecked();
        if(light){
            settings.putInt("light", 1);
        }else{
            settings.putInt("light", 2);
        }


        settings.commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        savePrefs();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
