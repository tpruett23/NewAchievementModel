package achievements;

import android.app.Activity;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.drm.DrmStore;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.example.toripruett.newachievementmodel.R;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import screens.UserCompleted;

public class Validation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(mMessageReceiver,
                new IntentFilter("Valid"));

    }


    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context1, Intent intent) {
            Toast.makeText(context1, "Message Received", Toast.LENGTH_LONG).show();
            String message = intent.getStringExtra("message");
            Toast.makeText(context1, message, Toast.LENGTH_LONG).show();
            Log.d("receiver", "Got message: " + message);
        }
    };

    /*public void add() {
        Achievements dis = (Achievements) getIntent().getParcelableExtra("distance");
        Achievements trails = (Achievements) getIntent().getParcelableExtra("trails");
        Achievements speed = (Achievements) getIntent().getParcelableExtra("speed");
        Achievements time = (Achievements) getIntent().getParcelableExtra("time");
        Achievements steps = (Achievements) getIntent().getParcelableExtra("steps");

        if (dis != null) {
            AchievementXMLHandler.getAchievements().add(dis);
        }
        if (trails != null) {
            AchievementXMLHandler.getAchievements().add(speed);

        }
        if (time != null) {
            AchievementXMLHandler.getAchievements().add(time);

        }
        if (steps != null) {
            AchievementXMLHandler.getAchievements().add(steps);
        }
    }*/




    public void testAdd(Achievements ach) {

            AchievementFactory.achievements.add(ach);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);


    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.
                getInstance(this).
                registerReceiver(mMessageReceiver, new IntentFilter("Valid"));
    }
}


