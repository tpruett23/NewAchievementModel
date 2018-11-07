package achievements;

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

import screens.MainMenu;

public class Settings extends AppCompatActivity implements OnClickListener {
    CheckBox sound;
    SeekBar bar;
    int volume;
    Button load,save,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        sound = (CheckBox)findViewById(R.id.soundcheck);
        bar = (SeekBar)findViewById(R.id.seekbar);
        load = (Button)findViewById(R.id.loadb);
        save = (Button)findViewById(R.id.saveb);
        back = (Button)findViewById(R.id.backb);

        load.setOnClickListener(this);
        save.setOnClickListener(this);


        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {



            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                volume = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Settings.this, "Seek bar progress is :" + volume,
                        Toast.LENGTH_SHORT).show();
            }


    });
        loadPrefs();
    }
    public void onClick(View v){
        Intent i = null;
        if(v.getId() ==  R.id.backb){
            i = new Intent(this, MainMenu.class);
            startActivity(i);

        }else if(v.getId() ==  R.id.loadb){
            loadPrefs();


        }else if(v.getId() == R.id.saveb) {
            savePrefs();


        }else if(v.getId() == R.id.soundcheck){
            sound.setChecked(true);
        }

    }
    public void loadPrefs(){
        SharedPreferences settings = getPreferences(Context.MODE_PRIVATE);
        int att = settings.getInt("sound", 1);
        int seek = settings.getInt("seekbar", 0);


        bar.setProgress(seek);


        if(att == 1){
            sound.setChecked(true);
        }else{
            sound.setChecked(false);
        }



    }

    public void savePrefs(){
        SharedPreferences.Editor settings =   getPreferences(MODE_PRIVATE).edit();
        int vol = bar.getProgress();
        settings.putInt("seekbar",vol);

        boolean save = sound.isChecked();
        if(save){
            settings.putInt("sound",1);
        }else{
            settings.putInt("sound",3);


        }




        settings.commit();

    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
