package com.example.toripruett.newachievementmodel;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import achievements.AchievementXMLHandler;
import achievements.ListViewAchv;

public class CheckAllService extends Service {
    public CheckAllService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
        AchievementXMLHandler achievementXMLHandler = new AchievementXMLHandler();
        achievementXMLHandler.checkAll();
        ListViewAchv L = new ListViewAchv();

    }
}
