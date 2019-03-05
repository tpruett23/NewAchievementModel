package screens;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toripruett.newachievementmodel.R;

import java.util.LinkedList;

public class CharacterScreen extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    TextView textView;
    public static LinkedList<String> dialogue;
    public static MediaPlayer mediaPlayer;
    public static int voicePlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.character_screen);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        textView.setOnClickListener(this);
        textView.setText(dialogue.pop());

        if(TrailMap.mediaPlayer.isPlaying())
            TrailMap.mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.lost_traveler);
    }

    @Override
    public void onClick(View view) {
        if(!dialogue.isEmpty()){
            textView.setText(dialogue.pop());
        }else{
            this.finish();
        }
    }

    private void parseLine(String line){
        if(line.startsWith("<!")){
            String command = line.substring(2, line.length()-1);
            if(line.startsWith("screen")){
                String newPicture = line.substring(7);
                int id = getResource(newPicture, "drawable");
                imageView.setImageResource(id);
            }else if(line.startsWith("voice")){
                String newVoice = line.substring(6);
                voicePlaying = getResource(newVoice, "raw");
                playVoice();
            }else if(line.startsWith("search")){
                String newSearch = line.substring(7);
                //TODO: connect to color recognition
            }
        }

    }

    private int getResource(String tag, String  type){
        int id = getResources().getIdentifier(tag, type, getPackageName());
        return id;
    }

    private void playVoice(){
        if(TrailMap.mediaPlayer.isPlaying()) {
            TrailMap.mediaPlayer.setVolume(Float.valueOf("0.2"), Float.valueOf("0.2"));
            mediaPlayer = MediaPlayer.create(getApplicationContext(), voicePlaying);
            TrailMap.mediaPlayer.setVolume(1,1);
        }
    }

}
