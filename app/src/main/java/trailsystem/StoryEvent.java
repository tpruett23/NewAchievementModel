package trailsystem;

import screens.CharacterScreen;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.toripruett.newachievementmodel.R;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Class which will hold story events
 * @author - Melchor Dominguez
 */
public class StoryEvent extends PointOfInterest {
    private String data;
    private LinkedList<String> dialogue;

    /** Receives the sorce for the story event from a file
     * @param source - source for the event
     */
    public StoryEvent(InputStream source) {
        dialogue = new LinkedList<>();
        Scanner reader = new Scanner(source);
        while(reader.hasNext()){
            String line = reader.nextLine();
            dialogue.add(line);
        }
    }

    /**
     * Will start the event
     * @param context - context where the event will be started
     */
    public void startEvent(Context context){

        CharacterScreen.dialogue = this.dialogue;
        Intent intent = new Intent(context, CharacterScreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }



}

