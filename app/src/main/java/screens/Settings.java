package screens;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    /**
     * The seekbar to adjust the volume.
     */
    SeekBar bar;

    /**
     * The volume the sound is at.
     */
    int volume;

    /**
     * The buttons to save, load, and go back to the previous screen.
     */
    Button load, save, back;

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
        sound.setChecked(true);

        darkMode = (CheckBox) findViewById(R.id.darkcheck);
        darkMode.setOnClickListener(this);
        darkMode.setChecked(true);



       /* bar = (SeekBar) findViewById(R.id.seekbar);
        load = (Button) findViewById(R.id.loadb);
        save = (Button) findViewById(R.id.saveb);*/
        //back = (Button) findViewById(R.id.backb);

     /*   load.setOnClickListener(this);
        save.setOnClickListener(this);
        */


    }
        /*bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                volume = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Settings.this, "Seek bar progress is :" + volume,
                        Toast.LENGTH_SHORT).show();
                int newVolume = bar.getProgress();
                if(newVolume == 0) {
                    TrailMap.mediaPlayer.pause();
                }else {
                    TrailMap.mediaPlayer.setVolume(Float.parseFloat(Integer.toString(newVolume)), Float.parseFloat(Integer.toString(newVolume)));
                    if(!TrailMap.mediaPlayer.isPlaying()){
                        TrailMap.mediaPlayer.start();
                    }
                }
            }


        });

        loadPrefs();
    }*/

    /**
     * The method that is called when one of the buttons is clicked.
     *
     * @param v The button that is clicked.
     */
    public void onClick(View v) {
        Intent i = null;
//        if (v.getId() == R.id.backb) {
//            i = new Intent(this, MainMenu.class);
//            startActivity(i);
//
//        } else if (v.getId() == R.id.loadb) {
//            loadPrefs();
//
//
//        } else if (v.getId() == R.id.saveb) {
//            savePrefs();
//
//
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
            }else{
                MapStyleOptions mapStyleOptions = MapStyleOptions.loadRawResourceStyle(this, R.raw.style2_json);
                TrailMap.UpdateMapStyleOptions(mapStyleOptions);
            }
        }
    }

    //}

    /**
     * Loads the preferences put in by the user after being saved.
     */
    public void loadPrefs() {
        SharedPreferences settings = getPreferences(Context.MODE_PRIVATE);
        int att = settings.getInt("sound", 1);
        int seek = settings.getInt("seekbar", 0);


        bar.setProgress(seek);


        if (att == 1) {
            sound.setChecked(true);
        } else {
            sound.setChecked(false);
        }


    }

    /**
     * Saves the preferences entered by the user.
     */

    public void savePrefs() {
        SharedPreferences.Editor settings = getPreferences(MODE_PRIVATE).edit();
        int vol = bar.getProgress();
        settings.putInt("seekbar", vol);

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


        settings.commit();

    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
