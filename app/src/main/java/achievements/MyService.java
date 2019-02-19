package achievements;

import android.app.AlarmManager;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import achievements.AchievementXMLHandler;
import achievements.ListViewAchv;
import achievements.SAXParserReader;
import screens.Load;
import screens.MainMenu;
import screens.TrailMap;


public class MyService extends Service {
    private final int UPDATE_INTERVAL = 60 * 1000;
    private Timer timer = new Timer();



    public MyService() {


    }


    @Override
    public IBinder onBind(Intent intent) {

        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {


    }

    @Override
    public void onDestroy() {


        Toast.makeText(this, "Service stopped", Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startid) {

        TrailMap map = new TrailMap();
        SAXParserReader saxParserReader = new SAXParserReader(this);
        saxParserReader.parseXML();
        ListViewAchv LV = new ListViewAchv();




        return START_NOT_STICKY;

    }


        @Override
        public void onStart (Intent intent,int startid){
            TrailMap map = new TrailMap();
            SAXParserReader saxParserReader = new SAXParserReader(this);
            saxParserReader.parseXML();
            ListViewAchv LV = new ListViewAchv();


          //   Toast.makeText(this, "Service started by user.", Toast.LENGTH_LONG).show();
        }


    }


