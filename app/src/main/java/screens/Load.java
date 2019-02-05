package screens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import achievements.AchievementFactory;
import achievements.AchievementXMLHandler;
import achievements.ListViewAchv;
import achievements.SAXParserReader;
import achievements.UserCompletedDisplay;
import achievements.UserInfo;

public class Load extends AppCompatActivity {

    public void onCreate(){

    }

    @Override
    protected void onStart() {
        super.onStart();
        TrailMap map = new TrailMap();
        SAXParserReader saxParserReader = new SAXParserReader(this);
        saxParserReader.parseXML();
        ListViewAchv LV = new ListViewAchv();
        Handler handler = new Handler();
        handler.postDelayed(runner, 0);

    }

    /**
     * Runs the app.
     */
    private final Runnable runner = new Runnable() {
        @Override
        public void run() {
            nextScreen();

        }
    };

    /**
     * Brings the user to the main menu screen after the splash screen.
     */
    private void nextScreen() {
        Intent i = new Intent(this, MainMenu.class);

        this.startActivity(i);
        this.finish();

    }
}
