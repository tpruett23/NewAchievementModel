package screens;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toripruett.newachievementmodel.R;

import java.util.LinkedList;

import achievements.QuestionEvent;
import minigame.ColorBlobDetectionActivity;
import trailsystem.Trail;

import static screens.TrailMap.*;
/**
 * The class is the screen for the story events and manages the dialog.
 * @author Melchor Dominguez
 * @version 1.0
 */
public class CharacterScreen extends Activity implements View.OnClickListener {

    ImageView imageView;
    TextView textView;
    public static LinkedList<String> dialogue;
    public static MediaPlayer mediaPlayer;
    public static int voicePlaying;
    public boolean wasPlaying;
    
    /**
     * The method is called to create the activity and initialize values before it is started.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Log.v("Andrew1","CCREATED!!!");

        setContentView(R.layout.character_screen);
        textView = findViewById(R.id.script);
        imageView = findViewById(R.id.imageView);
        textView.setOnClickListener(this);
        imageView.setOnClickListener(this);
        if(dialogue != null && dialogue.size() != 0) {
            onClick(textView);
        }

        if(TrailMap.mediaPlayer != null) {
            wasPlaying = TrailMap.mediaPlayer.isPlaying();
        }else{
            wasPlaying = false;
        }


        if(wasPlaying) {
            TrailMap.mediaPlayer.pause();
        }

        //TrailMap.mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.lost_traveler);

        //TrailMap.mediaPlayer.start();
    }
    /**
     * When the text is clicked this method pops up the next text.
     * @param view The view that is being checked to see if it is clicked.
     */
    @Override
    public void onClick(View view) {
        if(view == textView) {
            if (dialogue != null && !dialogue.isEmpty()) {
                parseLine(dialogue.pop());
            } else {
                if(wasPlaying) {
                    //TrailMap.mediaPlayer.setVolume(1, 1);
                }
                this.finish();

            }
        }else if(view == imageView){
            playVoice();
        }
    }
    
    /**
     * Parses through the xml file to get the correct dialog and display events correctly.
     * @param line the line to parse.
     */
    private void parseLine(String line){
        if(line.startsWith("<!")){
            String command = line.substring(2, line.length()-1);
            if(command.startsWith("screen")){
                String newPicture = command.substring(7);
                int id = getResource(newPicture, "drawable");
                imageView.setImageResource(id);
                parseLine(dialogue.pop());
            }else if(command.startsWith("voice")){
                String newVoice = command.substring(6);
                voicePlaying = getResource(newVoice, "raw");
                playVoice();
                parseLine(dialogue.pop());
            }else if(command.startsWith("search")){
                String newSearch = command.substring(7);
                Context context = this.textView.getContext();
                Intent intent = new Intent(this.textView.getContext(), ColorBlobDetectionActivity.class);
                context.startActivity(intent);

            }else if(command.startsWith("question")){
                String newSearch = command.substring(9);
                Context context = this;
                Intent intent = new Intent(context, QuestionEvent.class);
                context.startActivity(intent);
            }
        }else{
            textView.setText(line);
        }

    }
    /**
     * Gets the resource.
     * @return Returns the id of the resource.
     */
    private int getResource(String tag, String  type){
        int id = getResources().getIdentifier(tag, type, getPackageName());
        return id;
    }
    /**
     * This method plays the voice of the characters.
     */
    private void playVoice(){
        if(TrailMap.mediaPlayer.isPlaying()) {
            TrailMap.mediaPlayer.setVolume(Float.valueOf("0.2"), Float.valueOf("0.2"));
            mediaPlayer = MediaPlayer.create(getApplicationContext(), voicePlaying);
            mediaPlayer.start();
            //TrailMap.mediaPlayer.setVolume(1,1);
        }else{
            try {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), voicePlaying);
                mediaPlayer.start();
            }catch (Exception e){
                //do nothing
            }
        }
    }

}
