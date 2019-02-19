package trailsystem;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import android.widget.Toast;


import com.example.toripruett.newachievementmodel.R;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class StoryEvent extends PointOfInterest {
    static String filename = "character1_1";
    static Context context;
    static String data;

    public StoryEvent(Context context) {
        this.context = context;
        StoryEvent.CharacterScreen cs = new StoryEvent.CharacterScreen();
    }


    public static void nextLine(Scanner scan) {
        while (scan.hasNext()) {
            data = scan.nextLine();
        }


    }


    public static class CharacterScreen extends AppCompatActivity {
        TextView text;
        File file = new File(context.getFilesDir(), filename);
        Scanner scan;


        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.character_screen);
            try {
                scan = new Scanner(file);


            } catch (FileNotFoundException e) {
                e.printStackTrace();

            }
            text = (TextView) findViewById(R.id.textView);

            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nextLine(scan);
                    text.setText(data);


                }
            });
        }
    }
}

