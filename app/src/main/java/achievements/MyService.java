package achievements;

import android.app.AlarmManager;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorEvent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
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




    @Override
    public int onStartCommand(Intent intent, int flags, int startid) {

        TrailMap map = new TrailMap();
        StepCounterActivity stepCounterActivity = new StepCounterActivity();
        SAXParserReader saxParserReader = new SAXParserReader(this);
        saxParserReader.parseXML();
        ListViewAchv LV = new ListViewAchv();

        return START_NOT_STICKY;

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}


