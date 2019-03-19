package services;

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
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       AchievementXMLHandler.checkAll();
        return super.onStartCommand(intent, flags, startId);


    }
}
